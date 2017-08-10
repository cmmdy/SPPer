package com.drop.spper.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.drop.spper.R;
import com.drop.spper.di.component.DaggerContractComponent;
import com.drop.spper.di.module.ContractModule;
import com.drop.spper.mvp.contract.ContractContract;
import com.drop.spper.mvp.presenter.ContractPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class ContractActivity extends BaseActivity<ContractPresenter> implements ContractContract.View {


    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.my)
    TextView my;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerContractComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .contractModule(new ContractModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_contract; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        toolbarTitle.setText("联系我们");
        my.setVisibility(View.INVISIBLE);
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



    @OnClick(R.id.toolbar_back)
    public void onViewClicked() {
        finish();
    }
}
