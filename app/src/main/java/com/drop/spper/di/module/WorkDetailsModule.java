package com.drop.spper.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.drop.spper.mvp.contract.WorkDetailsContract;
import com.drop.spper.mvp.model.WorkDetailsModel;


@Module
public class WorkDetailsModule {
    private WorkDetailsContract.View view;

    /**
     * 构建WorkDetailsModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public WorkDetailsModule(WorkDetailsContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    WorkDetailsContract.View provideWorkDetailsView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    WorkDetailsContract.Model provideWorkDetailsModel(WorkDetailsModel model) {
        return model;
    }
}