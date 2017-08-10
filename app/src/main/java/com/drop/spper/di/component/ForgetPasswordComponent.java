package com.drop.spper.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.drop.spper.di.module.ForgetPasswordModule;

import com.drop.spper.mvp.ui.activity.ForgetPasswordActivity;

@ActivityScope
@Component(modules = ForgetPasswordModule.class, dependencies = AppComponent.class)
public interface ForgetPasswordComponent {
    void inject(ForgetPasswordActivity activity);
}