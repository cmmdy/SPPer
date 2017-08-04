package com.drop.spper.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.drop.spper.R;
import com.drop.spper.di.component.DaggerMyWorkComponent;
import com.drop.spper.di.moudle.MyWorkMoudle;
import com.drop.spper.mvp.contract.MyWorkContract;
import com.drop.spper.mvp.presenter.MyWorkPresenter;
import com.jess.arms.base.App;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.widget.imageloader.ImageLoader;
import com.jess.arms.widget.imageloader.glide.GlideImageConfig;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Drop on 2017/5/7.
 */

public class MyWork extends BaseFragment<MyWorkPresenter> implements MyWorkContract.View {

    @BindView(R.id.head)
    CircleImageView head;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.mywork)
    TextView mywork;
    @BindView(R.id.edit)
    TextView edit;
    private AppComponent mAppComponent;
    private ImageLoader mImageLoader;



    private static MyWork instance;

    public static MyWork getINSTANCE() {
        if (instance == null) {
            instance = new MyWork();
        }
        return instance;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerMyWorkComponent.builder()
                .appComponent(appComponent)
                .myWorkMoudle(new MyWorkMoudle(this))
                .build()
                .inject(this);
        mAppComponent = ((App)getContext().getApplicationContext()).getAppComponent();
        mImageLoader = mAppComponent.imageLoader();
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mywork, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Glide.with(getActivity()).load(R.drawable.head).into(head);
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
