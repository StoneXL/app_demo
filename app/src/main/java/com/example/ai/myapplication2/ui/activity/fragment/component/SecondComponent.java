package com.example.ai.myapplication2.ui.activity.fragment.component;

import com.example.ai.myapplication2.application.AppComponent;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.fragment.SecondFragment;
import com.example.ai.myapplication2.ui.activity.fragment.module.SecondModule;

import dagger.Component;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.fragment
 * @Description: The component for SecondFragment
 * @date 2017/09/27 09:51:09
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = SecondModule.class)
public interface SecondComponent {
    SecondFragment inject(SecondFragment Fragment);
}