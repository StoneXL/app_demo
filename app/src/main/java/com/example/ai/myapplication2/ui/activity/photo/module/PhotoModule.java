package com.example.ai.myapplication2.ui.activity.photo.module;

import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.photo.PhotoActivity;
import com.example.ai.myapplication2.ui.activity.photo.contract.PhotoContract;
import com.example.ai.myapplication2.ui.activity.photo.presenter.PhotoPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.photo
 * @Description: The moduele of PhotoActivity, provide field for PhotoActivity
 * @date 2017/09/25 18:18:24
 */
@Module
public class PhotoModule {
    private final PhotoContract.View mView;


    public PhotoModule(PhotoContract.View view) {
        this.mView = view;
    }

    @Provides
    @ActivityScope
    public PhotoPresenter providePhotoPresenter(HttpAPIWrapper httpAPIWrapper, PhotoActivity mActivity) {
        return new PhotoPresenter(httpAPIWrapper, mView, mActivity);
    }

    @Provides
    @ActivityScope
    public PhotoActivity providePhotoActivity() {
        return (PhotoActivity) mView;
    }
}