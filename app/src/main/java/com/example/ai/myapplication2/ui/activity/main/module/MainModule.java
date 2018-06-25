package com.example.ai.myapplication2.ui.activity.main.module;

import com.example.ai.myapplication2.R;
import com.example.ai.myapplication2.adapter.DrawLayoutAdapter;
import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.entity.DrawLayoutEntity;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.main.MainActivity;
import com.example.ai.myapplication2.ui.activity.main.contract.MainContract;
import com.example.ai.myapplication2.ui.activity.main.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.main
 * @Description: The moduele of MainActivity, provide field for MainActivity
 * @date 2017/10/17 11:11:46
 */
@Module
public class MainModule {
    private final MainContract.View mView;


    public MainModule(MainContract.View view) {
        this.mView = view;
    }

    @Provides
    @ActivityScope
    public MainPresenter provideMainPresenter(HttpAPIWrapper httpAPIWrapper, MainActivity mActivity) {
        return new MainPresenter(httpAPIWrapper, mView, mActivity);
    }

    @Provides
    @ActivityScope
    public MainActivity provideMainActivity() {
        return (MainActivity) mView;
    }

    @Provides
    @ActivityScope
    public DrawLayoutAdapter provideDraLayoutAdapter(List<DrawLayoutEntity> list) {
        return new DrawLayoutAdapter(list);
    }

    @Provides
    @ActivityScope
    public List<DrawLayoutEntity> provideList() {
        List<DrawLayoutEntity> list = new ArrayList<>();
        list.add(new DrawLayoutEntity("我的收入", R.mipmap.nav_income));
        list.add(new DrawLayoutEntity("工作汇总", R.mipmap.nav_summary));
        list.add(new DrawLayoutEntity("特殊门禁",R.mipmap.nav_quard));
        list.add(new DrawLayoutEntity("通知管理",R.mipmap.nav_night));
        list.add(new DrawLayoutEntity("报修审批",R.mipmap.nav_approval));
        list.add(new DrawLayoutEntity("报修申请",R.mipmap.icon_repair));
        list.add(new DrawLayoutEntity("报废申请",R.mipmap.icon_scrap));
        list.add(new DrawLayoutEntity("申购列表",R.mipmap.icon_shengou));
        list.add(new DrawLayoutEntity("电子券审批",R.mipmap.icon_shengou));
        list.add(new DrawLayoutEntity("区域监控",R.mipmap.icon_gonggong));
        list.add(new DrawLayoutEntity("巡检点录入",R.mipmap.icon_electricity));
        list.add(new DrawLayoutEntity("巡检系统",R.mipmap.icon_electricity));
        list.add(new DrawLayoutEntity("联系客服",R.mipmap.nav_customer));
        list.add(new DrawLayoutEntity("岗位监控",R.mipmap.icon_jiankong));
        return list;
    }
}