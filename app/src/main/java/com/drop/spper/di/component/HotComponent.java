package com.drop.spper.di.component;

import com.drop.spper.di.moudle.HotModule;
import com.drop.spper.mvp.ui.fragment.Hot;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by Drop on 2017/5/16.
 */

@FragmentScope
@Component (modules = HotModule.class, dependencies = AppComponent.class)
public interface HotComponent {
    void inject(Hot hot);
}
