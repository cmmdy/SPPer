package com.drop.spper.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.drop.spper.R;
import com.drop.spper.di.component.DaggerForgetPasswordComponent;
import com.drop.spper.di.module.ForgetPasswordModule;
import com.drop.spper.mvp.contract.ForgetPasswordContract;
import com.drop.spper.mvp.presenter.ForgetPasswordPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class ForgetPasswordActivity extends BaseActivity<ForgetPasswordPresenter> implements ForgetPasswordContract.View {


    @BindView(R.id.toolbar_back_tv)
    TextView toolbarBackTv;
    @BindView(R.id.toolbar_back)
    LinearLayout toolbarBack;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.my)
    TextView my;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.Pi)
    EditText Pi;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.Cpassword)
    EditText Cpassword;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerForgetPasswordComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .forgetPasswordModule(new ForgetPasswordModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_forget_password; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        toolbarBackTv.setText("返回");
        toolbarTitle.setText("忘记密码");
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



    @OnClick({R.id.toolbar_back, R.id.get, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
            case R.id.get:
                break;
            case R.id.login:
                break;
        }
    }
}
