package com.drop.spper.mvp.model;

import com.drop.spper.mvp.contract.MainContract;
import com.drop.spper.mvp.contract.MyWorkContract;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

/**
 * Created by Drop on 2017/5/7.
 */

@FragmentScope
public class MyWorkModel extends BaseModel implements MyWorkContract.Model {

    @Inject
    public MyWorkModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
}
