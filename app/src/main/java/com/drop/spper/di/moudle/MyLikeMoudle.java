package com.drop.spper.di.moudle;

import com.drop.spper.mvp.contract.MyLikeContract;
import com.drop.spper.mvp.model.MyLikeModel;
import com.drop.spper.mvp.ui.fragment.MyLike;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Drop on 2017/5/15.
 */

@Module
public class MyLikeMoudle {

    MyLikeContract.View view;


    public MyLikeMoudle(MyLikeContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MyLikeContract.View provideMyLikeView(){
        return this.view;
    }

    @FragmentScope
    @Provides
    MyLikeContract.Model provideMyLikeModel(MyLikeModel model){
        return model;
    }
}
