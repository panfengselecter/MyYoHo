package com.example.administrator.myyoho.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/8/23 0023.
 */
public abstract class BaseFragment extends Fragment{
    public View rootview;
    public Activity a;
    public void toast(String content){
        Toast.makeText(a,content,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.a=activity;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if(rootview==null){
           rootview=initview(inflater,container);
           initdata();
           initadapter();
       }

        return rootview;
    }

    protected abstract void initdata();

    protected abstract void initadapter();

    protected abstract View initview(LayoutInflater inflater, ViewGroup container);


}
