package com.drop.spper.mvp.model;

import com.drop.spper.mvp.contract.AppointmentContract;
import com.drop.spper.mvp.model.api.service.DouBanService;
import com.drop.spper.mvp.model.entity.HotMovieBean;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by Drop on 2017/5/16.
 */

@FragmentScope
public class AppointmentModel extends BaseModel implements AppointmentContract.Model {

    private static final int COUNT = 10;

    @Inject
    public AppointmentModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<HotMovieBean> getAppointment(int start, boolean updata) {
        Observable<HotMovieBean> observable =
                mRepositoryManager
                        .obtainRetrofitService(DouBanService.class)
                        .getMovieTop250(start, COUNT);
        return observable;
    }
}
