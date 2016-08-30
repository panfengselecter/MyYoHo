package com.example.administrator.myyoho.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.bean.LetterBean;
import com.example.administrator.myyoho.bean.PinPaiAllHotBean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27 0027.
 */
public class PinPaiLetterAdapter extends BaseExpanAdapter<LetterBean> {



    public PinPaiLetterAdapter(List<LetterBean> listbean, Context ctx) {
        super(listbean, ctx);
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        return listbean.get(groupPosition).list.size();
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
      GroupHolder holder=null;
        if(convertView==null){
            View inflate = View.inflate(ctx, R.layout.item_pin_pai_letter_group, null);
            holder=new GroupHolder();
             holder.grouptv = (TextView) inflate.findViewById(R.id.pin_pai_group_tv);
             convertView.setTag(holder);
        }else {

         holder = (GroupHolder) convertView.getTag();
        }
        LetterBean lettergroup = listbean.get(groupPosition);
        holder.grouptv.setText(lettergroup.title);
        return convertView;
    }
    class GroupHolder{
        TextView grouptv;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChaldHolder holder=null;
        if(convertView==null){
            View chaldview = View.inflate(ctx, R.layout.item_pin_pai_chald, null);
            holder=new ChaldHolder();
            holder.Chaldtv= (TextView) chaldview.findViewById(R.id.pin_pai_chald_tv);
            convertView.setTag(holder);
        }else {
         holder= (ChaldHolder) convertView.getTag();
        }
        PinPaiAllHotBean.BrandBean chaldlist = listbean.get(groupPosition).list.get(childPosition);
        holder.Chaldtv.setText(chaldlist.getName());
        return convertView;
    }
class ChaldHolder{
    TextView Chaldtv;

}

}
