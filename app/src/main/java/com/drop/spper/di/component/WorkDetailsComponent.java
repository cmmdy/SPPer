package com.drop.spper.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.drop.spper.di.module.WorkDetailsModule;

import com.drop.spper.mvp.ui.activity.WorkDetailsActivity;

@ActivityScope
@Component(modules = WorkDetailsModule.class, dependencies = AppComponent.class)
public interface WorkDetailsComponent {
    void inject(WorkDetailsActivity activity);
}