package com.example.ai.myapplication2.ui.activity.main.component;

import com.example.ai.myapplication2.application.AppComponent;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.main.MainActivity;
import com.example.ai.myapplication2.ui.activity.main.module.MainModule;

import dagger.Component;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.main
 * @Description: The component for MainActivity
 * @date 2017/10/17 11:11:46
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {
    MainActivity inject(MainActivity Activity);
}