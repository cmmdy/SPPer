package com.drop.spper.mvp.ui.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drop.spper.di.component.DaggerAppointmentComponent;
import com.drop.spper.di.moudle.AppointmentModule;
import com.drop.spper.mvp.contract.AppointmentContract;
import com.drop.spper.mvp.presenter.AppointmentPresenter;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.widget.imageloader.ImageLoader;
import com.paginate.Paginate;
import com.tbruyelle.rxpermissions.RxPermissions;

/**
 * Created by Drop on 2017/5/7.
 */

public class Appointment extends BaseFragment<AppointmentPresenter> implements AppointmentContract.View, SwipeRefreshLayout.OnRefreshListener{

    private AppComponent mAppComponent;
    private ImageLoader mImageLoader;
    private Paginate mPaginate;
    private boolean isLoadingMore;
    private RxPermissions mRxPermissions;

    private static Appointment instance;

    public static synchronized Appointment getINSTANCE(){
        if(instance == null){
            instance = new Appointment();
        }
        return instance;
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void setAdapter(DefaultAdapter mAdapter) {

    }

    @Override
    public void startLoadMore() {

    }

    @Override
    public void endLoadMore() {

    }

    @Override
    public RxPermissions getRxPermissions() {
        return null;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        this.mRxPermissions = new RxPermissions(getActivity());
        DaggerAppointmentComponent
                .builder()
                .appComponent(appComponent)
                .appointmentModule(new AppointmentModule(this))
                .build()
                .inject(this);
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        return null;
    }

    @Override
    public void initData() {

    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killMyself() {

    }
}
