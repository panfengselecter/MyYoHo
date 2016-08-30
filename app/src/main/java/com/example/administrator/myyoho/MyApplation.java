package com.example.administrator.myyoho;

import android.app.Application;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class MyApplation extends Application {
    public static MyApplation app;
    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }
}
