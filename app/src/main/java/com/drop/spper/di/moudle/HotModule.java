package com.drop.spper.di.moudle;

import com.drop.spper.mvp.contract.HotContract;
import com.drop.spper.mvp.model.HotModel;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Drop on 2017/5/16.
 */

@FragmentScope
@Module
public class HotModule {
    HotContract.View view;

    public HotModule(HotContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    HotContract.View provideHotView(){
        return this.view;
    }

    @FragmentScope
    @Provides
    HotContract.Model provideHotModel(HotModel model){
        return model;
    }
}
