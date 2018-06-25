package com.example.ai.myapplication2.ui.activity.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TextInputLayout;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ai.myapplication2.R;
import com.example.ai.myapplication2.application.AppConfig;
import com.example.ai.myapplication2.base.BaseActivity;
import com.example.ai.myapplication2.contain.Contains;
import com.example.ai.myapplication2.contain.ShareStatic;
import com.example.ai.myapplication2.entity.AppLogin;
import com.example.ai.myapplication2.ui.activity.home.HomeActivity;
import com.example.ai.myapplication2.ui.activity.login.component.DaggerLoginComponent;
import com.example.ai.myapplication2.ui.activity.login.contract.LoginContract;
import com.example.ai.myapplication2.ui.activity.login.module.LoginModule;
import com.example.ai.myapplication2.ui.activity.login.presenter.LoginPresenter;
import com.example.ai.myapplication2.ui.activity.main.MainActivity;
import com.example.ai.myapplication2.util.SpUtil;
import com.example.ai.myapplication2.util.StringUitl;
import com.example.ai.myapplication2.util.StringUitls;
import com.example.ai.myapplication2.util.ToastUtil;
import com.socks.library.KLog;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tyrantgit.explosionfield.ExplosionField;

import static com.example.ai.myapplication2.util.StringUitl.hasEmptyItem;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.login
 * @Description: $description
 * @date 2017/10/17 08:38:03
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Inject
    LoginPresenter mPresenter;
    @BindView(R.id.til_account)
    TextInputLayout mTilAccount;
    @BindView(R.id.til_password)
    TextInputLayout mTilPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.et_account)
    EditText mEtAccount;
    @BindView(R.id.et_pass_word)
    EditText mEtPassWord;
    private String mAccount;
    private String mPassWord;
    private ExplosionField explosionField;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mSharedPreferences = this.getSharedPreferences("Login_Sp", MODE_PRIVATE);
        mEtPassWord.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
                    onViewClicked();
                    return true;
                }
                return false;
            }
        });
        //粒子爆炸效果
        explosionField = ExplosionField.attach2Window(LoginActivity.this);
        if (!"".equals(mSharedPreferences.getString(ShareStatic.APP_LOGIN_ACCOUNT, ""))
                && !"".equals(mSharedPreferences.getString(ShareStatic.APP_LOGIN_PASSWORD, ""))) {
            mEtAccount.setText(mSharedPreferences.getString(ShareStatic.APP_LOGIN_ACCOUNT, ""));
            mEtPassWord.setText(mSharedPreferences.getString(ShareStatic.APP_LOGIN_PASSWORD, ""));
            onViewClicked();
        }


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setupActivityComponent() {
        DaggerLoginComponent
                .builder()
                .appComponent(((AppConfig) getApplication()).getApplicationComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void setPresenter(LoginContract.LoginContractPresenter presenter) {
        mPresenter = (LoginPresenter) presenter;
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void closeProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void loginSuccess(AppLogin appLogin) {
        Contains.appLogin = appLogin;
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putString(ShareStatic.APP_LOGIN_ACCOUNT, mAccount);
        edit.putString(ShareStatic.APP_LOGIN_PASSWORD, mPassWord);
        edit.apply();
        explosionField.explode(mBtnLogin);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    startActivty(HomeActivity.class);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        mAccount = mEtAccount.getText().toString().trim();
        mPassWord = mEtPassWord.getText().toString().trim();
        if (!StringUitl.isNoEmpty(mAccount)) {
            ToastUtil.show(LoginActivity.this, getString(R.string.msg_login_account));
            return;
        }
        if (!StringUitl.isNoEmpty(mPassWord)) {
            ToastUtil.show(LoginActivity.this, getString(R.string.msg_login_password));
            return;
        }
        //queryShipperInfo();
        StringBuilder deviceId = new StringBuilder();
        // 渠道标志
        deviceId.append("a");
        try {
            TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            String imei = tm.getDeviceId();
            if (!hasEmptyItem(imei)) {
                deviceId.append("m");
                deviceId.append(imei);
            } else {
                imei = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
                deviceId.append("m");
                deviceId.append(imei);
            }
            KLog.i(imei);

            //序列号（sn）
            String sn = tm.getSimSerialNumber();
            if (!hasEmptyItem(sn)) {
                deviceId.append("s");
                deviceId.append(sn);
                Log.e("geek : ", "序列号（sn）=" + deviceId.toString());
            }

        } catch (Exception e) {
            Log.d("geek", "getDeviceId: e");
            deviceId.append("e" + deviceId.toString());
        }
        Map<String, String> map = new HashMap<>(16);
        map.put("userName", mAccount);
        map.put("passWord", StringUitls.getMD5(mPassWord));
        map.put("macAddr", deviceId.toString());
        mPresenter.login(map);

    }

}