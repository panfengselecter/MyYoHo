package com.example.administrator.myyoho.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.bean.GuanZhuBean;
import com.example.administrator.myyoho.utils.HttpModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/8/29 0029.
 */
public class GuanZhuAdapter extends BaseAdapter {
    List<GuanZhuBean.FollowBean> list;

    public GuanZhuAdapter(List<GuanZhuBean.FollowBean> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
    }

    Context ctx ;
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
            convertView=View.inflate(ctx, R.layout.item_gaun_zhu,null);
            holder=new ViewHolder();
            holder.headimg= (ImageView) convertView.findViewById(R.id.head_img1);
            holder.headtv= (TextView) convertView.findViewById(R.id.head_tv);
            holder.centerimg1= (ImageView) convertView.findViewById(R.id.img1);
            holder.centerimg2= (ImageView) convertView.findViewById(R.id.img2);
            holder.centerimg3= (ImageView) convertView.findViewById(R.id.img3);
            holder.pricetv1= (TextView) convertView.findViewById(R.id.tv11);
            holder.pricetv2= (TextView) convertView.findViewById(R.id.tv12);
            holder.pricetv3= (TextView) convertView.findViewById(R.id.tv13);
            holder.distancetv3= (TextView) convertView.findViewById(R.id.tv3);
            holder.distancetv2= (TextView) convertView.findViewById(R.id.tv2);
            holder.distancetv1= (TextView) convertView.findViewById(R.id.tv1);
            convertView.setTag(holder);
        }else {
           holder= (ViewHolder) convertView.getTag();
        }
        GuanZhuBean.FollowBean followBean = list.get(position);
        holder.headtv.setText(followBean.getBrandname());
        Picasso.with(ctx).load(HttpModel.IMGHOST+followBean.getBrandimg()).into(holder.headimg);
        List<GuanZhuBean.FollowBean.GoodsBean> goods = followBean.getGoods();
        GuanZhuBean.FollowBean.GoodsBean goodsBean = goods.get(0);
        Picasso.with(ctx).load(HttpModel.IMGHOST+goodsBean.getGoodsimg()).into(holder.centerimg1);
        holder.pricetv1.setText(goodsBean.getPrice());
        holder.distancetv1.setText(goodsBean.getDistance());


        List<GuanZhuBean.FollowBean.GoodsBean> goods2 = followBean.getGoods();
        GuanZhuBean.FollowBean.GoodsBean goodsBean2 = goods.get(1);
        Picasso.with(ctx).load(HttpModel.IMGHOST+goodsBean.getGoodsimg()).into(holder.centerimg2);
        holder.pricetv2.setText(goodsBean.getPrice());
        holder.distancetv2.setText(goodsBean.getDistance());

        GuanZhuBean.FollowBean.GoodsBean goodsBean3 = goods.get(2);
        Picasso.with(ctx).load(HttpModel.IMGHOST+goodsBean.getGoodsimg()).into(holder.centerimg3);
        holder.pricetv3.setText(goodsBean.getPrice());
        holder.distancetv3.setText(goodsBean.getDistance());
        return convertView;
    }
    class ViewHolder{
        ImageView headimg;
        TextView headtv;
        ImageView centerimg1;
        ImageView centerimg2;
        ImageView centerimg3;
        TextView pricetv1;
        TextView pricetv2;
        TextView pricetv3;
        TextView distancetv1;
        TextView distancetv2;
        TextView distancetv3;

    }
}
