package com.example.ai.myapplication2.ui.activity.login.presenter;

import android.support.annotation.NonNull;

import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.entity.AppLogin;
import com.example.ai.myapplication2.ui.activity.login.contract.LoginContract;
import com.example.ai.myapplication2.ui.activity.login.LoginActivity;
import com.example.ai.myapplication2.util.ToastUtil;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.login
 * @Description: presenter of LoginActivity
 * @date 2017/10/17 08:38:03
 */
public class LoginPresenter implements LoginContract.LoginContractPresenter {

    HttpAPIWrapper httpAPIWrapper;
    private final LoginContract.View mView;
    private CompositeDisposable mCompositeDisposable;
    private LoginActivity mActivity;

    @Inject
    public LoginPresenter(@NonNull HttpAPIWrapper httpAPIWrapper, @NonNull LoginContract.View view, LoginActivity activity) {
        mView = view;
        this.httpAPIWrapper = httpAPIWrapper;
        mCompositeDisposable = new CompositeDisposable();
        this.mActivity = activity;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        if (!mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }

    @Override
    public void login(Map<String, String> map) {
        mView.showProgressDialog();
        Disposable disposable = httpAPIWrapper.Login(map)
                .subscribe(new Consumer<AppLogin>() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull AppLogin appLogin) throws Exception {
                        mView.closeProgressDialog();
                        if (appLogin.getStatus() != 0) {
                            ToastUtil.show(mActivity, appLogin.getMSG());
                        } else {
                            mView.loginSuccess(appLogin);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {
                        mView.closeProgressDialog();
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                });
        mCompositeDisposable.add(disposable);

    }

//    @Override
//    public void getUser(HashMap map) {
//        //mView.showProgressDialog();
//        Disposable disposable = httpAPIWrapper.getUser(map)
//                .subscribe(new Consumer<User>() {
//                    @Override
//                    public void accept(User user) throws Exception {
//                        //isSuccesse
//                        KLog.i("onSuccesse");
//                        mView.setText(user);
//                      //mView.closeProgressDialog();
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        //onError
//                        KLog.i("onError");
//                        throwable.printStackTrace();
//                      //mView.closeProgressDialog();
//                      //ToastUtil.show(mActivity, mActivity.getString(R.string.loading_failed_1));
//                    }
//                }, new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        //onComplete
//                        KLog.i("onComplete");
//                    }
//                });
//        mCompositeDisposable.add(disposable);
//    }
}