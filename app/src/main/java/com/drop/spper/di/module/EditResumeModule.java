package com.drop.spper.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.drop.spper.mvp.contract.EditResumeContract;
import com.drop.spper.mvp.model.EditResumeModel;


@Module
public class EditResumeModule {
    private EditResumeContract.View view;

    /**
     * 构建EditResumeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public EditResumeModule(EditResumeContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    EditResumeContract.View provideEditResumeView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    EditResumeContract.Model provideEditResumeModel(EditResumeModel model) {
        return model;
    }
}