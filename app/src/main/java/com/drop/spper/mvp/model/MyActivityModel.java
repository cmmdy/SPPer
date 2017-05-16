package com.drop.spper.mvp.model;

import com.drop.spper.mvp.contract.MyActivityContract;
import com.drop.spper.mvp.model.api.service.DouBanService;
import com.drop.spper.mvp.model.entity.HotMovieBean;
import com.drop.spper.mvp.ui.fragment.MyActivity;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Drop on 2017/5/16.
 */

@FragmentScope
public class MyActivityModel extends BaseModel implements MyActivityContract.Model {

    private static final int COUNT = 10;

    @Inject
    public MyActivityModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<HotMovieBean> getMyActivity(int start, boolean updata) {
        Observable<HotMovieBean> observable =
                mRepositoryManager
                        .obtainRetrofitService(DouBanService.class)
                        .getMovieTop250(start, COUNT);
        return observable;
    }
}
