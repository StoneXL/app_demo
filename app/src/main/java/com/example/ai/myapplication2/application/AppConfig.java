package com.example.ai.myapplication2.application;

import android.app.Application;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;


/**
 * @author wwx
 * @ClassName: AppConfig
 * @Description: Application 对象
 * @date 2015�?1�?6�?下午1:36:10
 */

public class AppConfig extends Application {
    private AppComponent mAppComponent;
    /**
     * 为了实现每次使用该类时不创建新的对象而创建的静�?对象
     */
    public static AppConfig instance;
    public AppConfig() {

    }


    @Override
    public void onCreate() {
        super.onCreate();
        setupApplicationComponent();
        instance=this;
       // TinkerInstaller.install(this);

    }

    public static synchronized AppConfig getInstance() {
        if (null == instance) {
            instance = new AppConfig();
        }
        return instance;
    }


//	public Thread.UncaughtExceptionHandler restartHandler = new Thread.UncaughtExceptionHandler() {
//		@Override
//		public void uncaughtException(Thread thread, Throwable ex) {
//			Log.d("geek","异常异常异常");
//			AlarmManager mgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//			mgr.set(AlarmManager.RTC, System.currentTimeMillis()+5000,
//					restartIntent); //重启应用
//			AppConfig.getInstance().exit();
//			android.os.Process.killProcess(android.os.Process.myPid());
//		}
//	};

    protected void setupApplicationComponent() {
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .aPIModule(new APIModule(this))
                .build();
        mAppComponent.inject(this);

    }

    public AppComponent getApplicationComponent() {
        return mAppComponent;
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();


    }

}
