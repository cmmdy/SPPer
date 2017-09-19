package com.drop.spper.mvp.ui.adapter;

import android.view.View;

import com.drop.spper.R;
import com.drop.spper.mvp.model.entity.HotMovieBean;
import com.drop.spper.mvp.ui.holder.HolderAccount;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;

/**
 * Created by Drop on 2017/5/20.
 */

public class AdapterAccount extends DefaultAdapter<HotMovieBean.SubjectsBean> {
    public AdapterAccount(List<HotMovieBean.SubjectsBean> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<HotMovieBean.SubjectsBean> getHolder(View v, int viewType) {
        return new HolderAccount(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.recycle_list_four;
    }
}
