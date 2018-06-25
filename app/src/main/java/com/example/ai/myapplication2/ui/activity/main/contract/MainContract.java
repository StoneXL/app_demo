package com.example.ai.myapplication2.ui.activity.main.contract;

import com.example.ai.myapplication2.ui.activity.base.BasePresenter;
import com.example.ai.myapplication2.ui.activity.base.BaseView;
/**
 * @author xlei
 * @Package The contract for MainActivity
 * @Description: $description
 * @date 2017/10/17 11:11:46
 */
public interface MainContract {
    interface View extends BaseView<MainContractPresenter> {
        /**
         *
         */
        void showProgressDialog();

        /**
         *
         */
        void closeProgressDialog();
    }

    interface MainContractPresenter extends BasePresenter {
//        /**
//         *
//         */
//        void getBusinessInfo(Map map);
    }
}