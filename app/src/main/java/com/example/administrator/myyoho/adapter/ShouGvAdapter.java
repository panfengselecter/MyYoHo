package com.example.administrator.myyoho.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.bean.ShouYeGvBean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/29 0029.
 */
public class ShouGvAdapter extends BaseAdapter {
    public ShouGvAdapter(List<ShouYeGvBean> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
    }

    List<ShouYeGvBean> list;
    Context ctx;
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=View.inflate(ctx, R.layout.item_shou_ye_gv,null);
            holder=new ViewHolder();
            holder.img= (ImageView) convertView.findViewById(R.id.img_gv);
            holder.tv= (TextView) convertView.findViewById(R.id.tv_gv);

            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        ShouYeGvBean shouYeGvBean = list.get(position);
        holder.img.setImageResource(shouYeGvBean.resld);
        holder.tv.setText(shouYeGvBean.title);
        return convertView;
    }
    class ViewHolder{
        TextView tv;
        ImageView img;

    }

}
