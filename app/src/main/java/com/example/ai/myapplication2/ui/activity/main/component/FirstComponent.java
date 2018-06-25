package com.example.ai.myapplication2.ui.activity.main.component;

import com.example.ai.myapplication2.application.AppComponent;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.main.FirstFragment;
import com.example.ai.myapplication2.ui.activity.main.module.FirstModule;

import dagger.Component;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.main
 * @Description: The component for FirstFragment
 * @date 2017/10/18 11:56:00
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = FirstModule.class)
public interface FirstComponent {
    FirstFragment inject(FirstFragment Fragment);
}