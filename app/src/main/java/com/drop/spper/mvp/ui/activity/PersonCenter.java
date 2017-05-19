package com.drop.spper.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.drop.spper.R;
import com.drop.spper.di.component.DaggerPersonCenterComponent;
import com.drop.spper.di.moudle.PersonCenterModule;
import com.drop.spper.mvp.contract.PersonCenterContract;
import com.drop.spper.mvp.presenter.PersonCenterPresenter;
import com.drop.spper.mvp.ui.fragment.Hot;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static okhttp3.internal.Internal.instance;

public class PersonCenter extends BaseActivity<PersonCenterPresenter> implements PersonCenterContract.View {

    @BindView(R.id.toolbar_back)
    LinearLayout toolbarBack;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.my)
    TextView my;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.toolbar_back_tv)
    TextView toolbarBackTv;
    private RxPermissions mRxPermissions;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        this.mRxPermissions = new RxPermissions(this);
        DaggerPersonCenterComponent
                .builder()
                .appComponent(appComponent)
                .personCenterModule(new PersonCenterModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView() {
        return R.layout.activity_person_center;
    }

    @Override
    public void initData() {
        toolbarBackTv.setText("返回");
        toolbarTitle.setText("个人中心");
        my.setVisibility(View.GONE);
        my.setClickable(false);
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

    @OnClick({R.id.head, R.id.name, R.id.pwallet, R.id.pmyfoucs, R.id.pfoucsme, R.id.psetvoice
            , R.id.pfeedback, R.id.pupdate, R.id.pcontactus, R.id.backll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.head:
                break;
            case R.id.name:
                break;
            case R.id.pwallet:
                break;
            case R.id.pmyfoucs:
                break;
            case R.id.pfoucsme:
                break;
            case R.id.psetvoice:
                break;
            case R.id.pfeedback:
                break;
            case R.id.pupdate:
                break;
            case R.id.pcontactus:
                break;
            case R.id.backll:
                break;
        }
    }

}
