package com.drop.spper.mvp.model;

import com.drop.spper.mvp.contract.MainContract;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import dagger.Module;

/**
 * Created by Drop on 2017/5/5.
 */

@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {

    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
}
