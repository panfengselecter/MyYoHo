package com.example.administrator.myyoho.utils;

import com.example.administrator.myyoho.MyApplation;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class DemoUtils  {

    public static  int dp2px(int value){
       return (int) (MyApplation.app.getResources().getDisplayMetrics().density*value+0.5f);
    }
}
