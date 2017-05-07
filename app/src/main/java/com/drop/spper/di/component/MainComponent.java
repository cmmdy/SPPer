package com.drop.spper.di.component;

import com.drop.spper.di.moudle.MainMoudle;
import com.drop.spper.mvp.model.MainModel;
import com.drop.spper.mvp.ui.activity.MainActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by Drop on 2017/5/6.
 */

@ActivityScope
@Component  (modules = MainMoudle.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
