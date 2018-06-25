package com.example.ai.myapplication2.ui.activity.main.module;

import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.main.FirstFragment;
import com.example.ai.myapplication2.ui.activity.main.contract.FirstContract;
import com.example.ai.myapplication2.ui.activity.main.presenter.FirstPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.main
 * @Description: The moduele of FirstFragment, provide field for FirstFragment
 * @date 2017/10/18 11:56:00
 */
@Module
public class FirstModule {
    private final FirstContract.View mView;


    public FirstModule(FirstContract.View view) {
        this.mView = view;
    }

    @Provides
    @ActivityScope
    public FirstPresenter provideFirstPresenter(HttpAPIWrapper httpAPIWrapper, FirstFragment mFragment) {
        return new FirstPresenter(httpAPIWrapper, mView, mFragment);
    }

    @Provides
    @ActivityScope
    public FirstFragment provideFirstFragment() {
        return (FirstFragment) mView;
    }
}