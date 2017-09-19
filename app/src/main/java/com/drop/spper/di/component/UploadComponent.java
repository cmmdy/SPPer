package com.drop.spper.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.drop.spper.di.module.UploadModule;

import com.drop.spper.mvp.ui.activity.UploadActivity;

@ActivityScope
@Component(modules = UploadModule.class, dependencies = AppComponent.class)
public interface UploadComponent {
    void inject(UploadActivity activity);
}