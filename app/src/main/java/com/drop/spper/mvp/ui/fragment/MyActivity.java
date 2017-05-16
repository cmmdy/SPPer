package com.drop.spper.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.drop.spper.R;
import com.drop.spper.di.moudle.MyActivityMoudle;
import com.drop.spper.mvp.contract.DaggerMyActivityComponent;
import com.drop.spper.mvp.contract.MyActivityContract;
import com.drop.spper.mvp.presenter.MyActivityPresenter;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.jess.arms.widget.imageloader.ImageLoader;
import com.paginate.Paginate;
import com.tbruyelle.rxpermissions.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Drop on 2017/5/7.
 */

public class MyActivity extends BaseFragment<MyActivityPresenter> implements MyActivityContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.toolbar_back_tv)
    TextView toolbarBackTv;
    @BindView(R.id.toolbar_back)
    LinearLayout toolbarBack;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.swipyRl)
    SwipeRefreshLayout swipeRefreshLayout;
    Unbinder unbinder;
    private AppComponent mAppComponent;
    private ImageLoader mImageLoader;
    private Paginate mPaginate;
    private boolean isLoadingMore;
    private RxPermissions mRxPermissions;

    private static MyActivity instance;

    public static synchronized MyActivity getINSTANCE() {
        if (instance == null) {
            instance = new MyActivity();
        }
        return instance;
    }

    @Override
    public void onRefresh() {
        mPresenter.requestMyLike(true);
    }

    @Override
    public void setAdapter(DefaultAdapter mAdapter) {
        recyclerview.setAdapter(mAdapter);
        initRecycleView();
        initPaginate();
    }

    @Override
    public void startLoadMore() {
        isLoadingMore = true;
    }

    @Override
    public void endLoadMore() {
        isLoadingMore = false;
    }

    @Override
    public RxPermissions getRxPermissions() {
        return mRxPermissions;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        this.mRxPermissions = new RxPermissions(getActivity());
        DaggerMyActivityComponent
                .builder()
                .appComponent(appComponent)
                .myActivityMoudle(new MyActivityMoudle(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_myactivity, container, false);
    }

    @Override
    public void initData() {
        mPresenter.requestMyLike(true);
        toolbarBack.setVisibility(View.GONE);
        toolbarTitle.setText("我的关注");
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void showLoading() {
        Observable.just(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        swipeRefreshLayout.setRefreshing(true);
                    }
                });
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showMessage(String message) {
        UiUtils.SnackbarText(message);
    }

    @Override
    public void launchActivity(Intent intent) {
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {

    }


    @OnClick(R.id.my)
    public void onViewClicked() {
    }

    private void initPaginate() {
        if (mPaginate == null) {
            Paginate.Callbacks callbacks = new Paginate.Callbacks() {
                @Override
                public void onLoadMore() {
                    mPresenter.requestMyLike(false);
                }

                @Override
                public boolean isLoading() {
                    return isLoadingMore;
                }

                @Override
                public boolean hasLoadedAllItems() {
                    return false;
                }
            };

            mPaginate = Paginate.with(recyclerview, callbacks)
                    .setLoadingTriggerThreshold(0)
                    .build();
            mPaginate.setHasMoreDataToLoad(false);
        }
    }

    private void initRecycleView() {
        swipeRefreshLayout.setOnRefreshListener(this);
        UiUtils.configRecycleView(recyclerview, new LinearLayoutManager(getActivity()));
    }
}
