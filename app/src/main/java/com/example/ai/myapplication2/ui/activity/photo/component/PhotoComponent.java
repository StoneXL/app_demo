package com.example.ai.myapplication2.ui.activity.photo.component;

import com.example.ai.myapplication2.application.AppComponent;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.photo.PhotoActivity;
import com.example.ai.myapplication2.ui.activity.photo.module.PhotoModule;

import dagger.Component;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.photo
 * @Description: The component for PhotoActivity
 * @date 2017/09/25 18:18:24
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = PhotoModule.class)
public interface PhotoComponent {
    PhotoActivity inject(PhotoActivity Activity);
}