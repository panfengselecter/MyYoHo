package com.example.administrator.myyoho.utils;

import com.example.administrator.myyoho.MyApplation;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class SpuUtils {

    public static void save(String key,String value){

    MyApplation.app.getSharedPreferences("content",0).edit().putString(key,value).commit();

    }

    public static String get(String key){
        return MyApplation.app.getSharedPreferences("content",0).getString(key,"");

    }

}
