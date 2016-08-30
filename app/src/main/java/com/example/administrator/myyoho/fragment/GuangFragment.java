package com.example.administrator.myyoho.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/23 0023.
 */
public class GuangFragment extends BaseFragment {

    @Override
    protected void initdata() {

    }

    @Override
    protected void initadapter() {

    }

    @Override
    protected View initview(LayoutInflater inflater, ViewGroup container) {
        TextView tv=new TextView(a);
        tv.setText(GuangFragment.class.getSimpleName());
        return tv;
    }
}
