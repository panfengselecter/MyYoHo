package com.example.administrator.myyoho.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class PinleiPagerAdapter extends FragmentPagerAdapter {


    List<Fragment> pinleifragmentlist;

    public PinleiPagerAdapter(FragmentManager fm, List<Fragment> fragment) {
        super(fm);
        this.pinleifragmentlist=fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return pinleifragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return pinleifragmentlist.size();
    }


}
