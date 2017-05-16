package com.drop.spper.di.component;

import com.drop.spper.di.moudle.MyWorkMoudle;
import com.drop.spper.mvp.ui.fragment.MyWork;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by Drop on 2017/5/7.
 */

@FragmentScope
@Component (modules = MyWorkMoudle.class, dependencies = AppComponent.class)
public interface MyWorkComponent {
    void inject(MyWork myWork);
}
