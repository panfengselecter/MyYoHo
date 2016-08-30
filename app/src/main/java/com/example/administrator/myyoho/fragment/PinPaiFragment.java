package com.example.administrator.myyoho.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.adapter.PinPaiLetterAdapter;
import com.example.administrator.myyoho.bean.LetterBean;
import com.example.administrator.myyoho.bean.PinPaiAllHotBean;
import com.example.administrator.myyoho.utils.DemoUtils;
import com.example.administrator.myyoho.utils.HttpModel;
import com.example.administrator.myyoho.utils.HttpUtils;
import com.example.administrator.myyoho.view.MyBanner;
import com.example.administrator.myyoho.view.PinPaiHorizontalView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class PinPaiFragment extends BaseFragment {
    private List<String> letterlist;
    private List<LetterBean> listBeen;
    private ExpandableListView lv;
    private TextView tv;
    private View pb;
    private ListView rightlv;

    @Override
    protected void initdata() {

    }
    @Override
    protected void initadapter() {
    }
    @Override
    protected View initview(LayoutInflater inflater, ViewGroup container) {
        View view =  inflater.inflate(R.layout.pin_pai_fragment, container, false);
        rightlv = (ListView) view.findViewById(R.id.rigth_lv);
        lv = (ExpandableListView) view.findViewById(R.id.pin_pai_lv);
        View emptyview = view.findViewById(R.id.pin_pai_empty_view);
        tv = (TextView) emptyview.findViewById(R.id.pin_pai_tv);
        pb = emptyview.findViewById(R.id.pin_pai_pb);


        lv.setEmptyView(emptyview);//设置一个空的View在加载失败的时候显示
        lv.setGroupIndicator(null);//设置指示器
        lv.setHeaderDividersEnabled(false);//设置头部的间距
        lv.setVerticalScrollBarEnabled(false);//设置去掉滚动条
        //设置父节点不可点击
        lv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setVisibility(View.GONE);
                pb.setVisibility(View.VISIBLE);
                initcontent();
            }
        });
        initheader();
        initcontent();

        return view;
    }

    private void initrightlav() {
        rightlv.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.item_pin_pai_right_lv,R.id.tv,letterlist));
    }
    public LetterBean getBRandBean(String content, List<PinPaiAllHotBean.BrandBean> list){
        String title=content;
        List<PinPaiAllHotBean.BrandBean> temp=new ArrayList<>();
        for(PinPaiAllHotBean.BrandBean bean:temp){
            if(title.equals(bean.getLetter()));
            temp.add(bean);
        }
        if(temp.size()>0){
            return new LetterBean(content,temp);
        }
        return null;
    }

    private void initcontent() {
        new HttpUtils().loadData(HttpModel.ALLHOTPINPAI,"parames={\\\"page\\\":\\\"10\\\"}").setOnLoadDataListener(new HttpUtils.OnLoadDataListener() {
            @Override
            public void loadSuccess(String content) {
                PinPaiAllHotBean pinPaiAllHotBean = new Gson().fromJson(content, PinPaiAllHotBean.class);
                List<PinPaiAllHotBean.BrandBean> brand = pinPaiAllHotBean.getBrand();

                letterlist = new ArrayList<String>();
                listBeen=new ArrayList<LetterBean>();
               for(int i=0;i<brand.size();i++) {
                   PinPaiAllHotBean.BrandBean brandBean = brand.get(i);
                   String name = brandBean.getName();
                   String letter = brandBean.getLetter();
                   listBeen.add(getBRandBean(letter,brand));
                   letterlist.add(letter);
               }
                Collections.sort(letterlist);
                 Log.e("agg",letterlist.toString());
                initrightlav();

                lv.setAdapter(new PinPaiLetterAdapter(listBeen,a));
                tv.setVisibility(View.GONE);
                pb.setVisibility(View.GONE);
                toast("chenggong");
            }

            @Override
            public void loadFailed(String msg) {
                tv.setVisibility(View.VISIBLE);
                pb.setVisibility(View.GONE);
            }
        });
    }

    private void initheader() {
        View serachview = View.inflate(a, R.layout.pin_pai_serach_view, null);
        AbsListView.LayoutParams serchParams=new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, DemoUtils.dp2px(50));
        serachview.setLayoutParams(serchParams);
        lv.addHeaderView(serachview);

        MyBanner bannerpager=new MyBanner(a);
        AbsListView.LayoutParams bannerParams=new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, DemoUtils.dp2px(150));
        bannerpager.setLayoutParams(bannerParams);
        bannerpager.loadData(HttpModel.BANNER,"");
        lv.addHeaderView(bannerpager);

        PinPaiHorizontalView horizontalView=new PinPaiHorizontalView(a);
        AbsListView.LayoutParams horizontalParams=new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, DemoUtils.dp2px(150));
        horizontalView.setLayoutParams(horizontalParams);
        horizontalView.loaddata(HttpModel.HOTPINPAI,"");
        lv.addHeaderView(horizontalView);

        View lastview = View.inflate(getContext(), R.layout.pin_pai_last, null);
        AbsListView.LayoutParams lastParams=new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, DemoUtils.dp2px(60));
        lastview.setLayoutParams(lastParams);
        lv.addHeaderView(lastview);
    }


}


