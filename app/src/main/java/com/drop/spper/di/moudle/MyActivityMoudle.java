package com.drop.spper.di.moudle;

import com.drop.spper.mvp.contract.MyActivityContract;
import com.drop.spper.mvp.model.MyActivityModel;
import com.jess.arms.di.scope.FragmentScope;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Drop on 2017/5/16.
 */

@Module
public class MyActivityMoudle {

    MyActivityContract.View view;

    public MyActivityMoudle(MyActivityContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MyActivityContract.View provideMyActivityView(){
        return this.view;
    }

    @FragmentScope
    @Provides
    MyActivityContract.Model provideMyActivityModel(MyActivityModel model){
        return model;
    }
}
