package com.drop.spper.mvp.model;

import com.drop.spper.mvp.contract.PersonCenterContract;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

/**
 * Created by Drop on 2017/5/17.
 */

@ActivityScope
public class PersonCenterModel extends BaseModel implements PersonCenterContract.Model{

    @Inject
    public PersonCenterModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
}
