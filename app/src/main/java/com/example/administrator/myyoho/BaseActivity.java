package com.example.administrator.myyoho;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class BaseActivity extends AppCompatActivity{
    public int screenweith;
    public int screenheight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenweith=this.getWindowManager().getDefaultDisplay().getWidth();
        screenheight=this.getWindowManager().getDefaultDisplay().getHeight();
    }
}