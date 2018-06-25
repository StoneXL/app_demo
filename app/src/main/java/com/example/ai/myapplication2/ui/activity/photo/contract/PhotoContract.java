package com.example.ai.myapplication2.ui.activity.photo.contract;

import com.example.ai.myapplication2.ui.activity.base.BasePresenter;
import com.example.ai.myapplication2.ui.activity.base.BaseView;

/**
 * @author xlei
 * @Package The contract for PhotoActivity
 * @Description: $description
 * @date 2017/09/25 18:18:24
 */
public interface PhotoContract {
    interface View extends BaseView<PhotoContractPresenter> {
        /**
         *
         */
        void showProgressDialog();

        /**
         *
         */
        void closeProgressDialog();
    }

    interface PhotoContractPresenter extends BasePresenter {
//        /**
//         *
//         */
//        void getBusinessInfo(Map map);
    }
}