package com.drop.spper.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.drop.spper.di.module.RePasswordModule;

import com.drop.spper.mvp.ui.activity.RePasswordActivity;

@ActivityScope
@Component(modules = RePasswordModule.class, dependencies = AppComponent.class)
public interface RePasswordComponent {
    void inject(RePasswordActivity activity);
}