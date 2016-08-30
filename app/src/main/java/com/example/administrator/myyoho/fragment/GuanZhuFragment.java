package com.example.administrator.myyoho.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.adapter.GuanZhuAdapter;
import com.example.administrator.myyoho.bean.GuanZhuBean;
import com.example.administrator.myyoho.utils.HttpModel;
import com.example.administrator.myyoho.utils.HttpUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2016/8/28 0028.
 */
public class GuanZhuFragment extends BaseFragment {

    private ListView lv;
    @Override
    protected void initdata() {

    }

    @Override
    protected void initadapter() {

    }

    @Override
    protected View initview(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.guan_zhu_fragment, container, false);
        lv = (ListView) inflate.findViewById(R.id.guan_zhu_lv);
        init();
        return inflate;
    }

    private void init() {
contacts();
    }
    public void contacts(){
        new HttpUtils().loadData(HttpModel.FLLOW,"").setOnLoadDataListener(new HttpUtils.OnLoadDataListener() {
            @Override
            public void loadSuccess(String content) {
                GuanZhuBean guanZhuBean = new Gson().fromJson(content, GuanZhuBean.class);
                List<GuanZhuBean.FollowBean> follow = guanZhuBean.getFollow();
                lv.setAdapter(new GuanZhuAdapter(follow,a));

            }

            @Override
            public void loadFailed(String msg) {

            }
        });

    }

}
