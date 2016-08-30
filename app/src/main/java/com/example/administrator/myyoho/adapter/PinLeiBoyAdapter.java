package com.example.administrator.myyoho.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.bean.PinLeiBoyBean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class PinLeiBoyAdapter extends BaseAdapter {
    List<PinLeiBoyBean> list;
    Context ctx;
    public PinLeiBoyAdapter(List<PinLeiBoyBean> list, Context ctx) {
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
            convertView=View.inflate(ctx, R.layout.item_pin_lei_boy,null);
           holder=new ViewHolder();
          holder.img= (ImageView) convertView.findViewById(R.id.pinlei_boy_img);
            holder.imgrigth= (ImageView) convertView.findViewById(R.id.pin_lei_rigth_img);
            holder.text= (TextView) convertView.findViewById(R.id.pinlei_boy_tv);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        PinLeiBoyBean pinLeiBoyBean = list.get(position);
        holder.img.setImageResource(pinLeiBoyBean.resid);
        holder.text.setText(pinLeiBoyBean.titles);
        holder.imgrigth.setImageResource(pinLeiBoyBean.resid);

        return convertView;
    }
    class ViewHolder{
        ImageView img;
        TextView text;
        ImageView imgrigth;


    }
}
