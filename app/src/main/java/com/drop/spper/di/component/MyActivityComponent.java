package com.drop.spper.di.component;

import com.drop.spper.di.moudle.MyActivityMoudle;
import com.drop.spper.mvp.ui.fragment.MyActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by Drop on 2017/5/16.
 */

@FragmentScope
@Component (modules = MyActivityMoudle.class, dependencies = AppComponent.class)
public interface MyActivityComponent {
    void inject(MyActivity myActivity);
}
