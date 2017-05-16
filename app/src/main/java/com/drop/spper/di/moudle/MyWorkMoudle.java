package com.drop.spper.di.moudle;

import com.drop.spper.mvp.contract.MyWorkContract;
import com.drop.spper.mvp.model.MyWorkModel;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Drop on 2017/5/7.
 */

@Module
public class MyWorkMoudle {

    MyWorkContract.View view;

    public MyWorkMoudle(MyWorkContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MyWorkContract.View provideMyWorkView (){
        return this.view;
    }

    @FragmentScope
    @Provides
    MyWorkContract.Model provideMyWorkModel(MyWorkModel model){
        return model;
    }
}
