package com.example.ai.myapplication2.ui.activity.main.contract;

import com.example.ai.myapplication2.ui.activity.base.BasePresenter;
import com.example.ai.myapplication2.ui.activity.base.BaseView;
/**
 * @author xlei
 * @Package The contract for FirstFragment
 * @Description: $description
 * @date 2017/10/18 11:56:00
 */
public interface FirstContract {
    interface View extends BaseView<FirstContractPresenter> {
        /**
         *
         */
        void showProgressDialog();

        /**
         *
         */
        void closeProgressDialog();
    }

    interface FirstContractPresenter extends BasePresenter {
//        /**
//         *
//         */
//        void getBusinessInfo(Map map);
    }
}