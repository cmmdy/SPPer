package com.drop.spper.mvp.ui.adapter;

import android.view.View;

import com.drop.spper.R;
import com.drop.spper.mvp.model.entity.HotMovieBean;
import com.drop.spper.mvp.ui.holder.HolderOne;
import com.drop.spper.mvp.ui.holder.HolderThree;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;

/**
 * Created by Drop on 2017/5/19.
 */

public class AdapterThree extends DefaultAdapter<HotMovieBean.SubjectsBean> {

    public AdapterThree(List<HotMovieBean.SubjectsBean> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<HotMovieBean.SubjectsBean> getHolder(View v, int viewType) {
        return new HolderThree(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.recycle_list_three;
    }
}