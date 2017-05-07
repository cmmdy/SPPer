package com.drop.spper.mvp.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.drop.spper.R;
import com.drop.spper.di.component.DaggerMainComponent;
import com.drop.spper.di.moudle.MainMoudle;
import com.drop.spper.mvp.contract.MainContract;
import com.drop.spper.mvp.presenter.MainPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.tbruyelle.rxpermissions.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.bottomNavigationBar)
    BottomNavigationBar mBottomNavigationBar;

    private RxPermissions mRxPermissions;


    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        this.mRxPermissions = new RxPermissions(this);
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainMoudle(new MainMoudle(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {

        assignViews();

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
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

    private void assignViews() {
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED)
                            .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                            .setBarBackgroundColor(R.color.transparent)
                            .setBackground(getResources().getDrawable(R.drawable.backgroundbottom));
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.bottom1, "我的作品"))//我的作品
                .addItem(new BottomNavigationItem(R.drawable.bottom2, "我的关注"))//我的关注
                .addItem(new BottomNavigationItem(R.drawable.bottom3, "热门"))//热门
                .addItem(new BottomNavigationItem(R.drawable.bottom4, "活动"))//活动
                .addItem(new BottomNavigationItem(R.drawable.bottom5, "约拍"))//约拍
                .setFirstSelectedPosition(2)
                .initialise();


//        fragments = getFragments();
//        setDefaultFragment();//设置默认选项

    }
}
