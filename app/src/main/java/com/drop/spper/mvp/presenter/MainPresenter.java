package com.drop.spper.mvp.presenter;

import com.drop.spper.mvp.contract.MainContract;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Drop on 2017/5/6.
 */
@ActivityScope
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View>{

    @Inject
    public MainPresenter(MainContract.Model model, MainContract.View rootView) {
        super(model, rootView);

    }


}
