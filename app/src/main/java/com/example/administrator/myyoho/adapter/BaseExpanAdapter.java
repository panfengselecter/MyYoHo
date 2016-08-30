package com.example.administrator.myyoho.adapter;

import android.content.Context;
import android.widget.BaseExpandableListAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27 0027.
 */
public  abstract class BaseExpanAdapter<T> extends BaseExpandableListAdapter {
List<T> listbean;
Context ctx;

    public BaseExpanAdapter(List<T> list, Context ctx) {
        this.listbean = list;
        this.ctx = ctx;
    }

    @Override
    public int getGroupCount() {
        return 0;
    }


    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }





    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
