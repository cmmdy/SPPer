package com.drop.spper.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;

import com.drop.spper.di.component.DaggerEditResumeComponent;
import com.drop.spper.di.module.EditResumeModule;
import com.drop.spper.mvp.contract.EditResumeContract;
import com.drop.spper.mvp.presenter.EditResumePresenter;

import com.drop.spper.R;


import static com.jess.arms.utils.Preconditions.checkNotNull;


public class EditResumeActivity extends BaseActivity<EditResumePresenter> implements EditResumeContract.View {


    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerEditResumeComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .editResumeModule(new EditResumeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_edit_resume; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }


}
