package com.drop.spper.mvp.model;

import com.drop.spper.mvp.contract.HotContract;
import com.drop.spper.mvp.model.api.service.DouBanService;
import com.drop.spper.mvp.model.entity.HotMovieBean;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Drop on 2017/5/16.
 */

@FragmentScope
public class HotModel extends BaseModel implements HotContract.Model {

    private static final int COUNT = 10;

    @Inject
    public HotModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<HotMovieBean> getHot(int start, boolean updata) {
        Observable<HotMovieBean> observable =
                mRepositoryManager
                .obtainRetrofitService(DouBanService.class)
                .getMovieTop250(start, COUNT);
        return observable;
    }
}
