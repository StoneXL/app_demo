package com.example.ai.myapplication2.ui.activity.fragment.module;

import com.example.ai.myapplication2.adapter.IndexFragmentAdapter;
import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.entity.IndexFragmentBean;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.fragment.SecondFragment;
import com.example.ai.myapplication2.ui.activity.fragment.contract.SecondContract;
import com.example.ai.myapplication2.ui.activity.fragment.presenter.SecondPresenter;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.fragment
 * @Description: The moduele of SecondFragment, provide field for SecondFragment
 * @date 2017/09/27 09:51:09
 */
@Module
public class SecondModule {
    private final SecondContract.View mView;


    public SecondModule(SecondContract.View view) {
        this.mView = view;
    }

    @Provides
    @ActivityScope
    public SecondPresenter provideSecondPresenter(HttpAPIWrapper httpAPIWrapper) {
        return new SecondPresenter(httpAPIWrapper, mView);
    }

    @Provides
    @ActivityScope
    public SecondFragment provideSecondFragment() {
        return (SecondFragment) mView;
    }

    @Provides
    @ActivityScope
    public List<IndexFragmentBean> provideList() {
        ArrayList<IndexFragmentBean> list = new ArrayList<>();
        return list;
    }

    @Provides
    @ActivityScope
    public IndexFragmentAdapter provideAdapter(List<IndexFragmentBean> list) {
        return new IndexFragmentAdapter(list);
    }


}