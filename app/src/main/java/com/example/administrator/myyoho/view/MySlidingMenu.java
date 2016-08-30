package com.example.administrator.myyoho.view;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/8/23 0023.
 */
public class MySlidingMenu extends SlidingPaneLayout {

    private int x;

    public MySlidingMenu(Context context) {
        super(context);
    }

    public MySlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySlidingMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = (int) ev.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                int min = (int) (ev.getRawX() - x);
                if(min>0&&!isOpen()){

                    return false;
                }
                break;
        }

        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = (int) ev.getRawX();
                break;
            case MotionEvent.ACTION_MOVE:
                int min = (int) (ev.getRawX() - x);
                if(min>0&&!isOpen()){

                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
