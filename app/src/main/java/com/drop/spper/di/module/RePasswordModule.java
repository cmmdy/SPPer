package com.drop.spper.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.drop.spper.mvp.contract.RePasswordContract;
import com.drop.spper.mvp.model.RePasswordModel;


@Module
public class RePasswordModule {
    private RePasswordContract.View view;

    /**
     * 构建RePasswordModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public RePasswordModule(RePasswordContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    RePasswordContract.View provideRePasswordView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    RePasswordContract.Model provideRePasswordModel(RePasswordModel model) {
        return model;
    }
}