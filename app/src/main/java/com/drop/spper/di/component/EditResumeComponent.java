package com.drop.spper.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.drop.spper.di.module.EditResumeModule;

import com.drop.spper.mvp.ui.activity.EditResumeActivity;

@ActivityScope
@Component(modules = EditResumeModule.class, dependencies = AppComponent.class)
public interface EditResumeComponent {
    void inject(EditResumeActivity activity);
}