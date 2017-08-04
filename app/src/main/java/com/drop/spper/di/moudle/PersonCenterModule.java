package com.drop.spper.di.moudle;

import com.drop.spper.mvp.contract.PersonCenterContract;
import com.drop.spper.mvp.model.PersonCenterModel;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Drop on 2017/5/17.
 */

@Module
public class PersonCenterModule {
    PersonCenterContract.View view;

    public PersonCenterModule(PersonCenterContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    PersonCenterContract.View providePersonCenterView (){
        return this.view;
    }

    @ActivityScope
    @Provides
    PersonCenterContract.Model providePersonCenterModel(PersonCenterModel model){
        return model;
    }
}
