package com.example.administrator.myyoho.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.adapter.MainPagerAdapter;
import com.example.administrator.myyoho.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23 0023.
 */
public class FenLeiFragment extends BaseFragment {

    List<String> titleslist;
    List<Fragment> fragmentList;
    private MyViewPager pager;
    private TabLayout tablayout;

    @Override
    protected void initdata() {
        titleslist = new ArrayList<>();
        titleslist.add("商品");
        titleslist.add("商品");
        titleslist.add("商品");
        fragmentList = new ArrayList<>();
        fragmentList.add(new PinLeiFragment());
        fragmentList.add(new PinPaiFragment());
        fragmentList.add(new GuanZhuFragment());
    }

    @Override
    protected void initadapter() {
        MainPagerAdapter pagerAdapter = new MainPagerAdapter(getFragmentManager(), fragmentList, titleslist);
        pager.setAdapter(pagerAdapter);
        tablayout.setupWithViewPager(pager);
    }
    @Override
    protected View initview(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fenlei_fragment, container, false);
        pager = (MyViewPager) view.findViewById(R.id.pager);
        tablayout= (TabLayout) view.findViewById(R.id.tablayout);
        return view;
    }



}
