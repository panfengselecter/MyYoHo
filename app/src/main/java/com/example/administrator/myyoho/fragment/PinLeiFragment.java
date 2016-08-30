package com.example.administrator.myyoho.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.adapter.PinleiPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class PinLeiFragment extends BaseFragment implements View.OnClickListener {

    List<Fragment> list;
    private RadioButton pinleiBoys;
    private RadioButton pinleiGirls;
    private RadioButton pinleiKids;
    private RadioButton pinleiLisfestyle;
    private ViewPager pinleipager;

    @Override
    protected void initdata() {
        list = new ArrayList<>();
        list.add(new PinLeiBoyFragment());
        list.add(new ShouYeFragment());
        list.add(new GuangFragment());
        list.add(new PinLeiBoyFragment());
    }
    @Override
    protected void initadapter() {
        pinleipager.setAdapter(new PinleiPagerAdapter(getFragmentManager(),list));
    }

    @Override
    protected View initview(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.pinlei_fragment, container, false);
        pinleiBoys= (RadioButton) view.findViewById(R.id.pinlei_boys);
        pinleiGirls= (RadioButton) view.findViewById(R.id.pinlei_girls);
        pinleiKids= (RadioButton) view.findViewById(R.id.pinlei_kids);
        pinleiLisfestyle= (RadioButton) view.findViewById(R.id.pinlei_lisfestyle);
        pinleipager = (ViewPager) view.findViewById(R.id.pinlei_pager);
        initlisntenre();
        return view;
    }

    private void initlisntenre() {
        pinleiBoys.setOnClickListener(this);
        pinleiGirls.setOnClickListener(this);
        pinleiKids.setOnClickListener(this);
        pinleiLisfestyle.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pinlei_boys:
                pinleipager.setCurrentItem(0,false);
                break;
            case R.id.pinlei_girls:
                pinleipager.setCurrentItem(1,false);
                break;
            case R.id.pinlei_kids:
                pinleipager.setCurrentItem(2,false);
                break;
            case R.id.pinlei_lisfestyle:
                pinleipager.setCurrentItem(3,false);
                break;

        }
    }
}
