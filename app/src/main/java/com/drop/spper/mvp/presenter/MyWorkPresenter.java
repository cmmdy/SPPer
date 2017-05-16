package com.drop.spper.mvp.presenter;

import com.drop.spper.mvp.contract.MyWorkContract;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.mvp.BaseModel;
import com.jess.arms.mvp.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Drop on 2017/5/7.
 */

@FragmentScope
public class MyWorkPresenter extends BasePresenter<MyWorkContract.Model, MyWorkContract.View>{

    @Inject
    public MyWorkPresenter(MyWorkContract.Model model, MyWorkContract.View rootView) {
        super(model, rootView);
    }
}
