package com.drop.spper.mvp.contract;

import com.drop.spper.mvp.model.entity.HotMovieBean;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observable;

/**
 * Created by Drop on 2017/5/15.
 */

public interface MyLikeContract {
    interface View extends IView {
        void setAdapter(DefaultAdapter mAdapter);
        void startLoadMore();
        void endLoadMore();
        RxPermissions getRxPermissions();
    }

    interface Model extends IModel {
        Observable<HotMovieBean> getMyLike(int start, boolean updata);
    }
}
