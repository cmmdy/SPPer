package com.drop.spper.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.drop.spper.di.module.UpdataModule;

import com.drop.spper.mvp.ui.activity.UpdataActivity;

@ActivityScope
@Component(modules = UpdataModule.class, dependencies = AppComponent.class)
public interface UpdataComponent {
    void inject(UpdataActivity activity);
}