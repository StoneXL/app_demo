package com.example.ai.myapplication2.ui.activity.login.module;

import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.login.LoginActivity;
import com.example.ai.myapplication2.ui.activity.login.contract.LoginContract;
import com.example.ai.myapplication2.ui.activity.login.presenter.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.login
 * @Description: The moduele of LoginActivity, provide field for LoginActivity
 * @date 2017/10/17 08:38:03
 */
@Module
public class LoginModule {
    private final LoginContract.View mView;


    public LoginModule(LoginContract.View view) {
        this.mView = view;
    }

    @Provides
    @ActivityScope
    public LoginPresenter provideLoginPresenter(HttpAPIWrapper httpAPIWrapper, LoginActivity mActivity) {
        return new LoginPresenter(httpAPIWrapper, mView, mActivity);
    }

    @Provides
    @ActivityScope
    public LoginActivity provideLoginActivity() {
        return (LoginActivity) mView;
    }
}