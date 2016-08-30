package com.example.administrator.myyoho.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.bean.ShouYeBean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/29 0029.
 */
public class ShouYeAdapter extends BaseAdapter {

   List<ShouYeBean> list;
    Context ctx;

    public ShouYeAdapter(List<ShouYeBean> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
    }

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
            convertView=View.inflate(ctx, R.layout.item_shou_ye,null);
            holder=new ViewHolder();
            holder.tv= (TextView) convertView.findViewById(R.id.tv_shou_ye);
            convertView.setTag(holder);

        }else {
         holder= (ViewHolder) convertView.getTag();
        }

        ShouYeBean shouYeBean = list.get(position);
        holder.tv.setText(shouYeBean.title);

        return convertView;
    }
    class ViewHolder{
        TextView tv;

    }
}
