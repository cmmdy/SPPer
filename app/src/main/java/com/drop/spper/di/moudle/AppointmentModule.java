package com.drop.spper.di.moudle;

import com.drop.spper.mvp.contract.AppointmentContract;
import com.drop.spper.mvp.contract.HotContract;
import com.drop.spper.mvp.model.AppointmentModel;
import com.drop.spper.mvp.model.HotModel;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Drop on 2017/5/16.
 */

@Module
public class AppointmentModule {
    AppointmentContract.View view;

    public AppointmentModule(AppointmentContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    AppointmentContract.View provideHotView(){
        return this.view;
    }

    @FragmentScope
    @Provides
    AppointmentContract.Model provideHotModel(AppointmentModel model){
        return model;
    }
}
