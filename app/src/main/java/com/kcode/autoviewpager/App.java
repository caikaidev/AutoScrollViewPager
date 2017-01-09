package com.kcode.autoviewpager;

import android.app.Application;
import android.os.StrictMode;

/**
 * Created by caik on 2017/1/3.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());


    }
}
