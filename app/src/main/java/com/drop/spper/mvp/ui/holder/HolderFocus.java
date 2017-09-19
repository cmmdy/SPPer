package com.drop.spper.mvp.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.drop.spper.R;
import com.drop.spper.mvp.model.entity.HotMovieBean;
import com.drop.spper.mvp.ui.activity.MyFocusActivity;
import com.drop.spper.mvp.ui.adapter.AdapterFocus;
import com.jess.arms.base.App;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.widget.imageloader.ImageLoader;
import com.jess.arms.widget.imageloader.glide.GlideImageConfig;


import butterknife.BindView;
import io.reactivex.Observable;

/**
 * Created by Drop on 2017/5/21.
 */

public class HolderFocus extends BaseHolder<HotMovieBean.SubjectsBean> {

    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.subscribe)
    LinearLayout subscribe;

    private AppComponent mAppComponent;
    private ImageLoader mImageLoader;
    private MyFocusActivity currentActivity;
    private AdapterFocus mAdapterFocus;


    public HolderFocus(View itemView, AdapterFocus adapterFocus) {
        super(itemView);
        mAppComponent = ((App) itemView.getContext().getApplicationContext()).getAppComponent();
        mImageLoader = mAppComponent.imageLoader();
        currentActivity = (MyFocusActivity) mAppComponent.appManager().getCurrentActivity();
        mAdapterFocus = adapterFocus;
    }

    @Override
    public void setData(HotMovieBean.SubjectsBean data, int position) {
        mImageLoader.loadImage(mAppComponent.appManager().getCurrentActivity() == null
                        ? mAppComponent.application() : mAppComponent.appManager().getCurrentActivity(),
                GlideImageConfig
                        .builder()
                        .url(data.getCasts().get(0).getAvatars().getLarge())
                        .imageView(iv)
                        .build());
        Observable.just(data.getCasts().get(0).getName())
                .subscribe(s -> name.setText(s));
        Observable.just(data.getCasts().get(0).getId())
                .subscribe(s -> phone.setText(s));
        subscribe.setOnClickListener(v ->
                mAdapterFocus.notifyItemRemoved(getAdapterPosition())
        );

    }
}

