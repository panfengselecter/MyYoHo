package com.example.administrator.myyoho.fragment;

import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.adapter.PinLeiBoyAdapter;
import com.example.administrator.myyoho.adapter.PinLeiChaldBoyAdapter;
import com.example.administrator.myyoho.bean.PinLeiBoyBean;
import com.example.administrator.myyoho.bean.PinLeiBoyChaldBean;
import com.example.administrator.myyoho.utils.HttpModel;
import com.example.administrator.myyoho.utils.HttpUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class PinLeiBoyFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    private List<PinLeiBoyBean> pinleibeanlist;
    private ListView pinleiboylv;
    private RelativeLayout pinleiboy;
    private RelativeLayout pinleichaldboy;
    private ListView pinleichaboylv;
    private ObjectAnimator animator;
    private int with;
    private RelativeLayout.LayoutParams params;
    private List<String> chaldboylist;
    private List<PinLeiBoyChaldBean> pinLeiChaldBeanList;
    private PinLeiChaldBoyAdapter adapter;
    @Override
    protected void initdata() {
        chaldboylist=new ArrayList<>();
        pinleibeanlist=new ArrayList<>();
        pinLeiChaldBeanList=new ArrayList<PinLeiBoyChaldBean>();
        pinleibeanlist.add(new PinLeiBoyBean(R.mipmap.ic_launcher,"上衣"));
        pinleibeanlist.add(new PinLeiBoyBean(R.mipmap.ic_launcher,"上衣"));
        pinleibeanlist.add(new PinLeiBoyBean(R.mipmap.ic_launcher,"上衣"));
        pinleibeanlist.add(new PinLeiBoyBean(R.mipmap.ic_launcher,"上衣"));
        pinleibeanlist.add(new PinLeiBoyBean(R.mipmap.ic_launcher,"上衣"));
        pinleibeanlist.add(new PinLeiBoyBean(R.mipmap.ic_launcher,"上衣"));
        pinleibeanlist.add(new PinLeiBoyBean(R.mipmap.ic_launcher,"上衣"));

        new HttpUtils().loadData(HttpModel.PEILEIBOY,"").setOnLoadDataListener(new HttpUtils.OnLoadDataListener() {
            @Override
            public void loadSuccess(String content) {
                PinLeiBoyChaldBean pinLeiBoyChaldBean =  new Gson().fromJson(content, PinLeiBoyChaldBean.class);
                pinLeiChaldBeanList.add(pinLeiBoyChaldBean);

                adapter.notifyDataSetChanged();
            }

            @Override
            public void loadFailed(String msg) {

            }
        });

    }
    @Override
    protected void initadapter() {
        pinleiboylv.setAdapter(new PinLeiBoyAdapter(pinleibeanlist,a));
        adapter= new PinLeiChaldBoyAdapter(pinLeiChaldBeanList,a);
        pinleichaboylv.setAdapter(adapter);

    }

    @Override
    protected View initview(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.pinlei_boy_fragment, container, false);
        pinleichaboylv = (ListView) view.findViewById(R.id.pinlei_chaldboy_lv);
        pinleichaldboy = (RelativeLayout) view.findViewById(R.id.pinlei_chaldboy);
        pinleiboy = (RelativeLayout) view.findViewById(R.id.pinlei_boy);
        pinleiboylv = (ListView) view.findViewById(R.id.pinlei_boy_lv);
        initanimation();
        with=a.getWindowManager().getDefaultDisplay().getWidth()/2;
        RelativeLayout.LayoutParams params =  (RelativeLayout.LayoutParams) pinleichaldboy.getLayoutParams();
        params.width=with;
        pinleichaldboy.setLayoutParams(params);
        pinleichaldboy.setTranslationX(with);
        initlistener();
        return view;
    }

    private void initlistener() {
       pinleiboylv.setOnItemClickListener(this);
    }

    private void initanimation() {
        animator = ObjectAnimator.ofFloat(pinleichaldboy,"TransitionX",0,0);
        animator.setDuration(300);
    }
    public void open(){
        animator.cancel();
        animator.setFloatValues(with,0);
        animator.start();
    }
    public void close(){
        animator.cancel();
        animator.setFloatValues(0,with);
        animator.start();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       close();

    }
}
