package com.example.administrator.myyoho.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.adapter.ShouGvAdapter;
import com.example.administrator.myyoho.adapter.ShouYeAdapter;
import com.example.administrator.myyoho.bean.ShouYeBean;
import com.example.administrator.myyoho.bean.ShouYeGvBean;
import com.example.administrator.myyoho.utils.DemoUtils;
import com.example.administrator.myyoho.utils.HttpModel;
import com.example.administrator.myyoho.view.MyBanner;
import com.example.administrator.myyoho.view.MyGridView;
import com.example.administrator.myyoho.view.PullToRelashListview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23 0023.
 */
public class ShouYeFragment extends BaseFragment {

    private PullToRelashListview lv;
    private MyBanner banner;
    private MyGridView gv;
    private List<ShouYeGvBean> gvBeen;
    private List<ShouYeBean> shouyelist;

    @Override
    protected void initdata() {
    }
    @Override
    protected void initadapter() {
    }
    @Override
    protected View initview(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.shou_ye_fragment, container, false);
        lv = (PullToRelashListview) view.findViewById(R.id.lv);
        initgvdata();

        banner = new MyBanner(a);
        banner.loadData(HttpModel.BANNER,"");
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, DemoUtils.dp2px(200));
        banner.setLayoutParams(params);
        lv.addHeadView(banner);

        gv = new MyGridView(a);
        gv.setNumColumns(4);
        gv.setAdapter(new ShouGvAdapter(gvBeen,a));

        lv.addHeadView(gv);
        initlvadapter();


        return view;
    }

    private void initlvadapter() {
        lv.setAdapter(new ShouYeAdapter(shouyelist,a));
    }

    private void initgvdata() {
        gvBeen = new ArrayList<>();
        gvBeen.add(new ShouYeGvBean("hha",R.drawable.btn_cptj));
        gvBeen.add(new ShouYeGvBean("hha",R.drawable.btn_dpzn_n));
        gvBeen.add(new ShouYeGvBean("hha",R.drawable.btn_mxcp_n));
        gvBeen.add(new ShouYeGvBean("hha",R.drawable.btn_qbpl_n));
        gvBeen.add(new ShouYeGvBean("hha",R.drawable.btn_zkjx_n));
        gvBeen.add(new ShouYeGvBean("hha",R.drawable.btn_xpdz_n));
        gvBeen.add(new ShouYeGvBean("hha",R.drawable.btn_zkjx_n));
        gvBeen.add(new ShouYeGvBean("hha",R.drawable.btn_zkjx_n));
        shouyelist = new ArrayList<>();
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
        shouyelist.add(new ShouYeBean("FDF"));
    }



}
