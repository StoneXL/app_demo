package com.example.ai.myapplication2.ui.activity.index.module;

import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.ui.activity.base.ActivityScope;
import com.example.ai.myapplication2.ui.activity.index.IndexActivity;
import com.example.ai.myapplication2.ui.activity.index.contract.IndexContract;
import com.example.ai.myapplication2.ui.activity.index.presenter.IndexPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author xxlei
 * @Package com.example.ai.myapplication2.ui.activity.index
 * @Description: The moduele of IndexActivity, provide field for IndexActivity
 * @date 2017/09/26 14:31:52
 */
@Module
public class IndexModule {
    private final IndexContract.View mView;


    public IndexModule(IndexContract.View view) {
        this.mView = view;
    }

    @Provides
    @ActivityScope
    public IndexPresenter provideIndexPresenter(HttpAPIWrapper httpAPIWrapper, IndexActivity mActivity) {
        return new IndexPresenter(httpAPIWrapper, mView, mActivity);
    }

    @Provides
    @ActivityScope
    public IndexActivity provideIndexActivity() {
        return (IndexActivity) mView;
    }
}