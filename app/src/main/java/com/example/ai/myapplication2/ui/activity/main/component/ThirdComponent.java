package com.example.ai.myapplication2.ui.activity.main.component;

import com.example.ai.myapplication2.application.AppComponent;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.main.ThirdFragment;
import com.example.ai.myapplication2.ui.activity.main.module.ThirdModule;

import dagger.Component;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.main
 * @Description: The component for ThirdFragment
 * @date 2017/10/18 14:21:40
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ThirdModule.class)
public interface ThirdComponent {
    ThirdFragment inject(ThirdFragment Fragment);
}