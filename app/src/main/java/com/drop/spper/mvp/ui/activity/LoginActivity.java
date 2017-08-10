package com.drop.spper.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;

import com.drop.spper.R;
import com.drop.spper.di.component.DaggerLoginComponent;
import com.drop.spper.di.module.LoginModule;
import com.drop.spper.mvp.contract.LoginContract;
import com.drop.spper.mvp.presenter.LoginPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {


    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.password)
    EditText password;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_login; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
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


    @OnClick({R.id.login, R.id.register, R.id.forget, R.id.qq, R.id.wechat, R.id.weibo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                launchActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
            case R.id.register:
                launchActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.forget:
                launchActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
                break;
            case R.id.qq:
                break;
            case R.id.wechat:
                break;
            case R.id.weibo:
                break;
        }
    }
}
