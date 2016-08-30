package com.example.administrator.myyoho.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.bean.PinLeiBoyChaldBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class PinLeiChaldBoyAdapter extends BaseAdapter {
    public PinLeiChaldBoyAdapter(List<PinLeiBoyChaldBean> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
    }

    List<PinLeiBoyChaldBean> list;
    Context ctx;
    List<String> stringList=new ArrayList<>();
    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=View.inflate(ctx, R.layout.item_pinleichaldboy,null);
            holder=new ViewHolder();
            holder.tv= (TextView) convertView.findViewById(R.id.pinlei_chaldboy_item_tv);

            convertView.setTag(holder);
        }else {

            holder= (ViewHolder) convertView.getTag();
        }
        PinLeiBoyChaldBean pinLeiBoyChaldBean = list.get(position);
        for(PinLeiBoyChaldBean.BoyBean  chaldboybean: pinLeiBoyChaldBean.getBoy()){
            stringList.add(chaldboybean.getName());
        }
        Log.e("tag",stringList+"");
        holder.tv.setText(stringList+"");
        return convertView;
    }
    class ViewHolder{
        TextView tv;

    }

}
