package com.drop.spper.mvp.model;

import com.drop.spper.mvp.contract.MyLikeContract;
import com.drop.spper.mvp.model.api.service.DouBanService;
import com.drop.spper.mvp.model.entity.HotMovieBean;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by Drop on 2017/5/15.
 */

@FragmentScope
public class MyLikeModel extends BaseModel implements MyLikeContract.Model {

    public static final int COUNT = 10;

    @Inject
    public MyLikeModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<HotMovieBean> getMyLike(int start, boolean updata) {
        Observable<HotMovieBean> observable =
                mRepositoryManager
                        .obtainRetrofitService(DouBanService.class)
                        .getMovieTop250(start, COUNT);
        return observable;
    }
}
