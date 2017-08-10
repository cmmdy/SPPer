package com.drop.spper.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.drop.spper.di.module.ContractModule;

import com.drop.spper.mvp.ui.activity.ContractActivity;

@ActivityScope
@Component(modules = ContractModule.class, dependencies = AppComponent.class)
public interface ContractComponent {
    void inject(ContractActivity activity);
}