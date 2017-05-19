package com.drop.spper.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.drop.spper.R;
import com.drop.spper.di.component.DaggerMyLikeComponent;
import com.drop.spper.di.moudle.MyLikeMoudle;
import com.drop.spper.mvp.contract.MyLikeContract;
import com.drop.spper.mvp.presenter.MyLikePresenter;
import com.jess.arms.base.App;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.jess.arms.widget.imageloader.ImageLoader;
import com.paginate.Paginate;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by Drop on 2017/5/7.
 */

public class MyLike extends BaseFragment<MyLikePresenter> implements MyLikeContract.View ,SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.work)
    TextView work;
    @BindView(R.id.photographer)
    TextView photographer;
    @BindView(R.id.model)
    TextView model;
    @BindView(R.id.swipyRl)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private AppComponent mAppComponent;
    private ImageLoader mImageLoader;
    private Paginate mPaginate;
    private boolean isLoadingMore;
    private RxPermissions mRxPermissions;


    private static MyLike instance;

    public static synchronized MyLike getINSTANCE() {
        if (instance == null) {
            instance = new MyLike();
        }
        return instance;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        this.mRxPermissions = new RxPermissions(getActivity());
        DaggerMyLikeComponent
                .builder()
                .appComponent(appComponent)
                .myLikeMoudle(new MyLikeMoudle(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_mylike, container, false);
    }

    @Override
    public void initData() {
        mPresenter.requestMyLike(true);
        work.setTextColor(getResources().getColor(R.color.textclick));
    }

    @Override
    public void setData(Object data) {
    }

    @Override
    public void showLoading() {
        Observable.just(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> swipeRefreshLayout.setRefreshing(true));
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


    private void changeTextColor(TextView textView) {
        work.setTextColor(getResources().getColor(R.color.divisionLight));
        photographer.setTextColor(getResources().getColor(R.color.divisionLight));
        model.setTextColor(getResources().getColor(R.color.divisionLight));
        textView.setTextColor(getResources().getColor(R.color.textclick));
    }

    @OnClick({R.id.work, R.id.photographer, R.id.model})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.work:
                changeTextColor(work);
                mPresenter.requestMyLike(true);
                break;
            case R.id.photographer:
                changeTextColor(photographer);
                mPresenter.requestMyLike(true);
                break;
            case R.id.model:
                changeTextColor(model);
                mPresenter.requestMyLike(true);
                break;
        }
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

    private void initRecycleView() {
        swipeRefreshLayout.setOnRefreshListener(this);
        UiUtils.configRecycleView(recyclerview, new GridLayoutManager(getActivity(), 2));
    }

    @Override
    public void onRefresh() {
        mPresenter.requestMyLike(true);
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
}
