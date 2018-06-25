package com.example.ai.myapplication2.ui.activity.main.contract;

import com.example.ai.myapplication2.ui.activity.base.BasePresenter;
import com.example.ai.myapplication2.ui.activity.base.BaseView;
/**
 * @author xlei
 * @Package The contract for ThirdFragment
 * @Description: $description
 * @date 2017/10/18 14:21:40
 */
public interface ThirdContract {
    interface View extends BaseView<ThirdContractPresenter> {
        /**
         *
         */
        void showProgressDialog();

        /**
         *
         */
        void closeProgressDialog();
    }

    interface ThirdContractPresenter extends BasePresenter {
//        /**
//         *
//         */
//        void getBusinessInfo(Map map);
    }
}