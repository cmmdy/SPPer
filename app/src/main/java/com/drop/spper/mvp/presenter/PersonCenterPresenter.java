package com.drop.spper.mvp.presenter;

import com.drop.spper.mvp.contract.PersonCenterContract;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Drop on 2017/5/17.
 */

@ActivityScope
public class PersonCenterPresenter extends BasePresenter<PersonCenterContract.Model, PersonCenterContract.View> {

    @Inject
    public PersonCenterPresenter(PersonCenterContract.Model model, PersonCenterContract.View rootView) {
        super(model, rootView);
    }
}
