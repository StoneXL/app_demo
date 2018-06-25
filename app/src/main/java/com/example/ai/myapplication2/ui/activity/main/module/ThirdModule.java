package com.example.ai.myapplication2.ui.activity.main.module;

import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.main.ThirdFragment;
import com.example.ai.myapplication2.ui.activity.main.contract.ThirdContract;
import com.example.ai.myapplication2.ui.activity.main.presenter.ThirdPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.main
 * @Description: The moduele of ThirdFragment, provide field for ThirdFragment
 * @date 2017/10/18 14:21:40
 */
@Module
public class ThirdModule {
    private final ThirdContract.View mView;


    public ThirdModule(ThirdContract.View view) {
        this.mView = view;
    }

    @Provides
    @ActivityScope
    public ThirdPresenter provideThirdPresenter(HttpAPIWrapper httpAPIWrapper, ThirdFragment mFragment) {
        return new ThirdPresenter(httpAPIWrapper, mView, mFragment);
    }

    @Provides
    @ActivityScope
    public ThirdFragment provideThirdFragment() {
        return (ThirdFragment) mView;
    }
}