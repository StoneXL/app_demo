package com.example.ai.myapplication2.ui.activity.home.component;

import com.example.ai.myapplication2.ui.activity.home.HomeActivity;
import com.example.ai.myapplication2.ui.activity.home.module.HomeModule;
import com.example.ai.myapplication2.application.AppComponent;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;


import dagger.Component;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.home
 * @Description: The component for HomeActivity
 * @date 2017/09/18 10:44:16
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = HomeModule.class)
public interface HomeComponent {
    HomeActivity inject(HomeActivity Activity);
}