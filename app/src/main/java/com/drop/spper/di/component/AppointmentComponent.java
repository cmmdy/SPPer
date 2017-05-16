package com.drop.spper.di.component;

import com.drop.spper.di.moudle.AppointmentModule;
import com.drop.spper.mvp.ui.fragment.Appointment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;

/**
 * Created by Drop on 2017/5/16.
 */

@FragmentScope
@Component (modules = AppointmentModule.class, dependencies = AppComponent.class)
public interface AppointmentComponent {
    void inject(Appointment appointment);
}
