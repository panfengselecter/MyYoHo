package com.example.administrator.myyoho.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/8/23 0023.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private final List<String> titles;
    private final List<Fragment> fragemntlist;

    public MainPagerAdapter(FragmentManager fm, List<Fragment> fragmentlist, List<String> titles) {
        super(fm);
        this.titles=titles;
        this.fragemntlist=fragmentlist;
    }

    @Override
    public Fragment getItem(int position) {
        return fragemntlist.get(position);
    }

    @Override
    public int getCount() {
        return fragemntlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
