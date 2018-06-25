package com.example.ai.myapplication2.ui.activity.home.module;



import com.example.ai.myapplication2.ui.activity.home.HomeActivity;
import com.example.ai.myapplication2.ui.activity.home.contract.HomeContract;
import com.example.ai.myapplication2.ui.activity.home.presenter.HomePresenter;
import com.example.ai.myapplication2.adapter.HostAdapter;
import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.entity.Host;


import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.home
 * @Description: The moduele of HomeActivity, provide field for HomeActivity
 * @date 2017/09/18 10:44:16
 */
@Module
public class HomeModule {
    private final HomeContract.View mView;


    public HomeModule(HomeContract.View view) {
        this.mView = view;
    }

    @Provides
    @ActivityScope
    public HomePresenter provideHomePresenter(HttpAPIWrapper httpAPIWrapper, HomeActivity mActivity) {
        return new HomePresenter(httpAPIWrapper, mView, mActivity);
    }

    @Provides
    @ActivityScope
    public HomeActivity provideHomeActivity() {
        return (HomeActivity) mView;
    }
    @Provides
    @ActivityScope
    public List<Host.DataBean> provideList() {
        List<Host.DataBean> list = new ArrayList<>();
        return list;
    }

    @Provides
    @ActivityScope
    public HostAdapter provideHostAdapter(List<Host.DataBean> list) {

        return new HostAdapter(list);
    }
//    @Provides
//    @ActivityScope
//    public List<Wuye.DataBean> provideList() {
//
//    }
//
//    @Provides
//    @ActivityScope
//    public WuyeAdapter provideWuyeAdapter(List<Wuye.DataBean> dataBean, HttpAPIWrapper httpAPIWrapper) {
//        return new WuyeAdapter(dataBean, httpAPIWrapper);
//    }
}