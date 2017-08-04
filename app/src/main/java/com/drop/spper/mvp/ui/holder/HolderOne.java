package com.drop.spper.mvp.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.drop.spper.R;
import com.drop.spper.mvp.model.entity.HotMovieBean;
import com.jess.arms.base.App;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.jess.arms.widget.imageloader.ImageLoader;
import com.jess.arms.widget.imageloader.glide.GlideImageConfig;

import butterknife.BindView;
import io.reactivex.Observable;

/**
 * Created by Drop on 2017/5/15.
 */

public class HolderOne extends BaseHolder<HotMovieBean.SubjectsBean> {

    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.photographer)
    TextView photographer;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.circleImageView)
    de.hdodenhof.circleimageview.CircleImageView circleImageView;
    private AppComponent mAppComponent;
    private ImageLoader mImageLoader;

    public HolderOne(View itemView) {
        super(itemView);
        mAppComponent = ((App) itemView.getContext().getApplicationContext()).getAppComponent();
        mImageLoader = mAppComponent.imageLoader();
    }

    @Override
    public void setData(HotMovieBean.SubjectsBean data, int position) {
        Observable.just(data.getCasts().get(0).getName())
                .subscribe(s -> photographer.setText(s));
        Observable.just(data.getTitle())
                .subscribe(s -> tvName.setText(s));
        mImageLoader.loadImage(mAppComponent.appManager().getCurrentActivity() == null
                        ? mAppComponent.application() : mAppComponent.appManager().getCurrentActivity(),
                GlideImageConfig
                        .builder()
                        .url(data.getImages().getLarge())
                        .imageView(ivAvatar)
                        .build());
        mImageLoader.loadImage(mAppComponent.appManager().getCurrentActivity() == null
                        ? mAppComponent.application() : mAppComponent.appManager().getCurrentActivity(),
                GlideImageConfig
                        .builder()
                        .url(data.getCasts().get(0).getAvatars().getMedium())
                        .imageView(circleImageView)
                        .build());
    }

    @Override
    protected void onRelease() {
        mImageLoader.clear(mAppComponent.application(), GlideImageConfig.builder()
                .imageViews(ivAvatar)
                .build());
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
    }

}
