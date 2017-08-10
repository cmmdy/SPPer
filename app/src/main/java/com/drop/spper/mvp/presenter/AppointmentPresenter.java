package com.drop.spper.mvp.presenter;

import android.app.Application;

import com.drop.spper.app.utils.RxUtils;
import com.drop.spper.mvp.contract.AppointmentContract;
import com.drop.spper.mvp.model.entity.HotMovieBean;
import com.drop.spper.mvp.ui.adapter.AdapterAppointment;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

/**
 * Created by Drop on 2017/5/16.
 */

@FragmentScope
public class AppointmentPresenter extends BasePresenter<AppointmentContract.Model, AppointmentContract.View> {
    private RxErrorHandler mErrorHandler;
    private AppManager mAppManager;
    private Application mApplication;
    private List<HotMovieBean.SubjectsBean> subjectsBeens = new ArrayList<>();
    private DefaultAdapter mAdapter;
    private int lastStart;
    private boolean isFirst = true;
    private int preEndIndex;

    @Inject
    public AppointmentPresenter(AppointmentContract.Model model, AppointmentContract.View rootView
            , RxErrorHandler mErrorHandler, AppManager mAppManager, Application mApplication) {
        super(model, rootView);
        this.mErrorHandler = mErrorHandler;
        this.mAppManager = mAppManager;
        this.mApplication = mApplication;
    }

    public void requestAppointment(boolean pullToRefresh){

        if(mAdapter == null){
            mAdapter = new AdapterAppointment(subjectsBeens);
            mRootView.setAdapter(mAdapter);
        }

        boolean isEvictCache = pullToRefresh;//是否驱逐缓存,为ture即不使用缓存,每次上拉刷新即需要最新数据,则不使用缓存

        if (pullToRefresh) {
            lastStart = 1;
        }

        if(pullToRefresh && isFirst){//默认在第一次上拉刷新时使用缓存
            isFirst = false;
            isEvictCache = false;
        }

        mModel.getAppointment(lastStart, isEvictCache)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))//遇到错误时重试,第一个参数为重试几次,第二个参数为重试的间隔
                .doOnSubscribe(disposable -> {
                    if (pullToRefresh)
                        mRootView.showLoading();//显示上拉刷新的进度条
                    else
                        mRootView.startLoadMore();//显示下拉加载更多的进度条
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(() -> {
                    if(pullToRefresh){
                        mRootView.hideLoading();//隐藏上拉刷新进度条
                    } else {
                        mRootView.endLoadMore();//隐藏下拉加载更多进度条
                    }
                })
                .compose(RxUtils.bindToLifecycle(mRootView))//使用RXlifecycle,使subscription和activity一起销毁
                .subscribe(new ErrorHandleSubscriber<HotMovieBean>(mErrorHandler) {
                    @Override
                    public void onNext(HotMovieBean hotMovieBean) {
                        if(pullToRefresh){
                            subjectsBeens.clear();
                        }
                        preEndIndex = subjectsBeens.size() + 1;
                        subjectsBeens.addAll(hotMovieBean.getSubjects());
                        lastStart = subjectsBeens.size() + 1;
                        if(pullToRefresh){
                            mAdapter.notifyDataSetChanged();
                        } else {
                            mAdapter.notifyItemRangeInserted(preEndIndex, hotMovieBean.getSubjects().size());
                        }
                    }
                });
    }
}
