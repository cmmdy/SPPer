package com.drop.spper.di.component;

import com.drop.spper.di.moudle.PersonCenterModule;
import com.drop.spper.mvp.ui.activity.PersonCenterActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by Drop on 2017/5/17.
 */

@ActivityScope
@Component (modules = PersonCenterModule.class, dependencies = AppComponent.class)
public interface PersonCenterComponent {
    void inject(PersonCenterActivity personCenterActivity);
}
