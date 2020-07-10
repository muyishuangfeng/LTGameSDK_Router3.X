package com.gnetop.ltgame.router;

import android.app.Application;
import android.content.res.Configuration;

public abstract class YApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        registerAction();
    }

    /**
     * 注册动作
     */
    public abstract void registerAction();

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
