package com.example.ai.myapplication2.ui.activity.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ai.myapplication2.R;
import com.example.ai.myapplication2.adapter.IndexFragmentAdapter;
import com.example.ai.myapplication2.application.AppConfig;
import com.example.ai.myapplication2.base.BaseFragment;
import com.example.ai.myapplication2.entity.IndexFragmentBean;
import com.example.ai.myapplication2.ui.activity.fragment.component.DaggerSecondComponent;
import com.example.ai.myapplication2.ui.activity.fragment.contract.SecondContract;
import com.example.ai.myapplication2.ui.activity.fragment.module.SecondModule;
import com.example.ai.myapplication2.ui.activity.fragment.presenter.SecondPresenter;
import com.example.ai.myapplication2.util.ToastUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.fragment
 * @Description: $description
 * @date 2017/09/27 09:51:09
 */

public class SecondFragment extends BaseFragment implements SecondContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    SecondPresenter mPresenter;
    @Inject
    IndexFragmentAdapter mAdapter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    Unbinder unbind;

   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_second_layout, null);
       ButterKnife.bind(this, view);
       Bundle mBundle = getArguments();

       initView();
       return view;
   }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        swipeRefresh.setOnRefreshListener(this);
        //swipeRefresh.setRefreshing(true);
        mPresenter.loadData();
    }
    @Override
    protected void setupFragmentComponent() {
       DaggerSecondComponent
               .builder()
               .appComponent(((AppConfig) getActivity().getApplication()).getApplicationComponent())
               .secondModule(new SecondModule(this))
               .build()
               .inject(this);
    }

    @Override
    protected void initDataFromLocal() {

    }

    @Override
    public void setPresenter(SecondContract.SecondContractPresenter presenter) {
        mPresenter = (SecondPresenter) presenter;
    }



    @Override
    public void showProgressDialog() {
        //progressDialog.show();
    }

    @Override
    public void closeProgressDialog() {
        //progressDialog.hide();
    }

    @Override
    public void setAdapter(List<IndexFragmentBean> list) {

        swipeRefresh.setRefreshing(false);
        mAdapter.setNewData(list);
    }

    @Override
    public void onRefresh() {
    mPresenter.loadData();
    }
}