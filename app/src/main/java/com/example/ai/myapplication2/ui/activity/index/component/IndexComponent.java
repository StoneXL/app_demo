package com.example.ai.myapplication2.ui.activity.index.component;

import com.example.ai.myapplication2.application.AppComponent;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.index.IndexActivity;
import com.example.ai.myapplication2.ui.activity.index.module.IndexModule;

import dagger.Component;

/**
 * @author xxlei
 * @Package com.example.ai.myapplication2.ui.activity.index
 * @Description: The component for IndexActivity
 * @date 2017/09/26 14:31:52
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = IndexModule.class)
public interface IndexComponent {
    IndexActivity inject(IndexActivity Activity);
}