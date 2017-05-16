package com.drop.spper.mvp.ui.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.drop.spper.R;
import com.drop.spper.di.component.DaggerMainComponent;
import com.drop.spper.di.moudle.MainMoudle;
import com.drop.spper.mvp.contract.MainContract;
import com.drop.spper.mvp.presenter.MainPresenter;
import com.drop.spper.mvp.ui.fragment.Hot;
import com.drop.spper.mvp.ui.fragment.MyActivity;
import com.drop.spper.mvp.ui.fragment.MyLike;
import com.drop.spper.mvp.ui.fragment.MyWork;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.bottomNavigationBar)
    BottomNavigationBar mBottomNavigationBar;

    private RxPermissions mRxPermissions;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private Fragment currentFragment;


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

        initFragments();
        smartFragmentReplace(fragments.get(2));//设置默认选项

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                smartFragmentReplace(fragments.get(position));
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });



    }

    private void initFragments(){
        fragments.add(MyWork.getINSTANCE());
        fragments.add(MyLike.getINSTANCE());
        fragments.add(Hot.getINSTANCE());
        fragments.add(MyActivity.getINSTANCE());
        fragments.add(MyWork.getINSTANCE());
    }

    protected int getFragmentContentId() {
        return R.id.root;
    }

    private void smartFragmentReplace(Fragment toFragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        // 如有当前在使用的->隐藏当前的
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }
        String toClassName = toFragment.getClass().getSimpleName();
        // toFragment之前添加使用过->显示出来
        if (manager.findFragmentByTag(toClassName) != null) {
            transaction.show(toFragment);
        } else {// toFragment还没添加使用过->添加上去
            transaction.add(getFragmentContentId(), toFragment, toClassName);
        }
        transaction.commit();
        // toFragment更新为当前的
        currentFragment = toFragment;
    }
}
