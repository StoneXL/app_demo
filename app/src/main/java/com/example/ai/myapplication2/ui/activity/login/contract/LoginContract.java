package com.example.ai.myapplication2.ui.activity.login.contract;

import com.example.ai.myapplication2.entity.AppLogin;
import com.example.ai.myapplication2.ui.activity.base.BasePresenter;
import com.example.ai.myapplication2.ui.activity.base.BaseView;

import java.util.Map;

/**
 * @author xlei
 * @Package The contract for LoginActivity
 * @Description: $description
 * @date 2017/10/17 08:38:03
 */
public interface LoginContract {
    interface View extends BaseView<LoginContractPresenter> {
        /**
         *
         */
        void showProgressDialog();

        /**
         *
         */
        void closeProgressDialog();

        void loginSuccess(AppLogin appLogin);
    }

    interface LoginContractPresenter extends BasePresenter {

        void login(Map<String, String> map);
    }
}