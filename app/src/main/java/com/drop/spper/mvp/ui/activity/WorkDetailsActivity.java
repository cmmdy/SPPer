package com.drop.spper.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.drop.spper.R;
import com.drop.spper.di.component.DaggerWorkDetailsComponent;
import com.drop.spper.di.module.WorkDetailsModule;
import com.drop.spper.mvp.contract.WorkDetailsContract;
import com.drop.spper.mvp.presenter.WorkDetailsPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class WorkDetailsActivity extends BaseActivity<WorkDetailsPresenter> implements WorkDetailsContract.View {


    @BindView(R.id.expand_text_view)
    ExpandableTextView expandTextView;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerWorkDetailsComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .workDetailsModule(new WorkDetailsModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_work_details; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        expandTextView.setText("kdajkjfdjaljlfksdjlkjfksjakdsjflkjskdajflkjaslkdjflkjsalkfjlksdajlkflkjsdalkjflkasjdlkfjlasjdkfjlaskdjflkjasdkljfljasdlkjflasdjlkfjlkdsajklfjkasjklncx,mnvm,nxzc,mvnkdjfkljsdalfkjalksjfklasdjflkjaslkdjdkfjlkasjdlfkjlkajsfd");
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
