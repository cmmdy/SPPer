package com.drop.spper.di.moudle;

import com.drop.spper.mvp.contract.MainContract;
import com.drop.spper.mvp.model.MainModel;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Drop on 2017/5/6.
 */

@Module
public class MainMoudle {

    MainContract.View view;

    public MainMoudle(MainContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainContract.View provideMainView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MainContract.Model provideMainModel(MainModel model){
        return model;
    }
}
