package com.drop.spper.di.component;

import com.drop.spper.di.moudle.MyLikeMoudle;
import com.drop.spper.mvp.ui.fragment.MyLike;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by Drop on 2017/5/15.
 */

@FragmentScope
@Component (modules = MyLikeMoudle.class, dependencies = AppComponent.class)
public interface MyLikeComponent {

    void inject(MyLike myLike);
}
