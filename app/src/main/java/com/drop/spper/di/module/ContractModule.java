package com.drop.spper.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.drop.spper.mvp.contract.ContractContract;
import com.drop.spper.mvp.model.ContractModel;


@Module
public class ContractModule {
    private ContractContract.View view;

    /**
     * 构建ContractModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ContractModule(ContractContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ContractContract.View provideContractView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ContractContract.Model provideContractModel(ContractModel model) {
        return model;
    }
}