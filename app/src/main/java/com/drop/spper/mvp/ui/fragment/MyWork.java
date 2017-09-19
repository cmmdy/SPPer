package com.drop.spper.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.drop.spper.R;
import com.drop.spper.di.component.DaggerMyWorkComponent;
import com.drop.spper.di.moudle.MyWorkMoudle;
import com.drop.spper.mvp.contract.MyWorkContract;
import com.drop.spper.mvp.presenter.MyWorkPresenter;
import com.drop.spper.mvp.ui.activity.EditResumeActivity;
import com.drop.spper.mvp.ui.activity.UploadActivity;
import com.jess.arms.base.App;
import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.widget.imageloader.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Drop on 2017/5/7.
 */

public class MyWork extends BaseFragment<MyWorkPresenter> implements MyWorkContract.View {

    @BindView(R.id.head)
    CircleImageView head;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.simplefile)
    TextView simplefile;
    @BindView(R.id.mywork)
    TextView mywork;
    @BindView(R.id.edit)
    TextView edit;

    private boolean bedit = true;
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
        mAppComponent = ((App) getContext().getApplicationContext()).getAppComponent();
        mImageLoader = mAppComponent.imageLoader();
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mywork, container, false);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        simplefile.setTextColor(getResources().getColor(R.color.blue));
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
        startActivity(intent);
    }

    @Override
    public void killMyself() {

    }


    @OnClick({R.id.simplefile, R.id.mywork, R.id.edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.simplefile:
                simplefile.setTextColor(getResources().getColor(R.color.blue));
                mywork.setTextColor(getResources().getColor(R.color.white));
                edit.setText("编辑");
                bedit = true;
                break;
            case R.id.mywork:
                mywork.setTextColor(getResources().getColor(R.color.blue));
                simplefile.setTextColor(getResources().getColor(R.color.white));
                edit.setText("上传作品");
                bedit = false;
                break;
            case R.id.edit:
                if(bedit){
                    launchActivity(new Intent(getActivity(), EditResumeActivity.class));
                } else {
                    launchActivity(new Intent(getActivity(), UploadActivity.class));

                }
                break;
        }
    }
}
