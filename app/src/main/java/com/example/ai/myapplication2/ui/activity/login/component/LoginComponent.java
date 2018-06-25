package com.example.ai.myapplication2.ui.activity.login.component;

import com.example.ai.myapplication2.application.AppComponent;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.login.LoginActivity;
import com.example.ai.myapplication2.ui.activity.login.module.LoginModule;

import dagger.Component;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.login
 * @Description: The component for LoginActivity
 * @date 2017/10/17 08:38:03
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = LoginModule.class)
public interface LoginComponent {
    LoginActivity inject(LoginActivity Activity);
}