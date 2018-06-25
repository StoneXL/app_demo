package com.example.ai.myapplication2.ui.activity.home.contract;


import com.example.ai.myapplication2.ui.activity.base.BasePresenter;
import com.example.ai.myapplication2.ui.activity.base.BaseView;
import com.example.ai.myapplication2.entity.Host;

import java.util.List;

/**
 * @author xlei
 * @Package The contract for HomeActivity
 * @Description: $description
 * @date 2017/09/18 10:44:16
 */
public interface HomeContract {
    interface View extends BaseView<HomeContractPresenter> {
        /**
         *
         */
        void showProgressDialog();

        /**
         *
         */
        void closeProgressDialog();
        void loadHostSucces(List<Host.DataBean> list);
        void loadHostFail();
        void setAdapter();



    }

    interface HomeContractPresenter extends BasePresenter {
//        /**
//         *
//         */
//        void getBusinessInfo(Map map);
        void loadHost();
    }
}