package com.example.administrator.myyoho.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.utils.DemoUtils;

/**
 * Created by admin on 2016/8/29.
 */
public class PullToRelashListview extends RelativeLayout {

    private LinearLayout headGroup;
    private LinearLayout footerGroup;
    private ListView gv;
    private LayoutParams footerparams;
    private ImageView headIv;
    private ImageView footerIv;
    private LayoutParams headParams;
    private int measuredHeight;
    private int y;
    private PullToRelashListener pullToRelashListener;
    private boolean isPull;
    private LayoutParams params;
    private boolean isLoad;

    public PullToRelashListview(Context context) {
        this(context, null);
    }

    public PullToRelashListview(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PullToRelashListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void addHeadView(View headView) {
        gv.addHeaderView(headView);
    }

    public void addFooterView(View footerView) {
        gv.addFooterView(footerView);
    }


    private void init() {
        headIv = new ImageView(getContext());
        headIv.setImageResource(R.drawable.icon_loaing_frame_1);
        headParams = new LayoutParams(LayoutParams.WRAP_CONTENT, DemoUtils.dp2px(20));
        headParams.addRule(CENTER_HORIZONTAL);
        headIv.setLayoutParams(headParams);
        headIv.setId(R.id.head);

        footerIv = new ImageView(getContext());
        footerIv.setImageResource(R.drawable.icon_loaing_frame_1);
        footerparams = new LayoutParams(LayoutParams.MATCH_PARENT, DemoUtils.dp2px(20));
        footerparams.addRule(ALIGN_PARENT_BOTTOM);
        footerIv.setId(R.id.bottom);
        footerIv.setLayoutParams(footerparams);
        gv = new ListView(getContext());
        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        params.addRule(BELOW, R.id.head);
        params.addRule(ABOVE, R.id.bottom);
        gv.setLayoutParams(params);
        headIv.measure(0, 0);
        measuredHeight = headIv.getMeasuredHeight();
        Log.e("tag", measuredHeight + "");
//        headIv.setPadding(0, -measuredHeight, 0, 0);
        headParams.topMargin = -measuredHeight;
        headIv.setLayoutParams(headParams);
        footerparams.bottomMargin=-measuredHeight;
        addView(headIv);
        addView(footerIv);
        addView(gv);


    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
//         Log.e("tag", "measureHeight-->"+measuredHeight);
//        footerparams.
    }

    public void setAdapter(BaseAdapter adapter) {
        gv.setAdapter(adapter);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                y = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                if(isPull)break;
                int minY = (int) (event.getRawY() - y) / 2;
                pull(minY);
                load(minY);
                break;
            case MotionEvent.ACTION_UP:
                loadPull();
                loadMore();
                break;
        }
        return true;
    }

    private void loadMore() {
        if(isLoad)return;
        if(footerparams.bottomMargin>-measuredHeight){
            if(footerparams.bottomMargin<=0){
                footerparams.bottomMargin=-measuredHeight;
                footerIv.setLayoutParams(footerparams);
                params.topMargin=0;
                gv.setLayoutParams(params);
            }else{
                footerparams.bottomMargin=0;
                footerIv.setLayoutParams(footerparams);
                params.topMargin=-measuredHeight;
                gv.setLayoutParams(params);
                footerIv.setImageResource(R.drawable.load);
                isLoad = true;
                if(pullToRelashListener!=null){
                    pullToRelashListener.load();
                }
            }
        }
    }

    private void load(int minY) {
        if(isLoad)return;
        if(minY<0&&gv.getLastVisiblePosition()==(gv.getAdapter().getCount()-1)){
            footerparams.bottomMargin=-measuredHeight-minY;
            footerIv.setLayoutParams(footerparams);
            params.topMargin=minY;
            gv.setLayoutParams(params);
        }
    }
    public int getFirstVisiablePosition(){
//        int childCount = gv.getChildCount();
//        if(childCount==0)return 0;
//        int i =gv.getAdapter().getCount()- gv.getFirstVisiblePosition()-1;
//        Log.e("tag",i+"");
//        View childAt = gv.getChildAt(i);
//        if(childAt.getTop()>0)
//            return gv.getFirstVisiblePosition()+1;
        return  gv.getFirstVisiblePosition();
    }
    public void setSelection(int position){
        gv.setSelection(position);
    }

    private void loadPull() {
        if(isPull)return;
        if (headParams.topMargin > -measuredHeight) if (headParams.topMargin <= 0) {
            headParams.topMargin = -measuredHeight;
            headIv.setLayoutParams(headParams);
        } else {
            headParams.topMargin = 0;
            headIv.setLayoutParams(headParams);
            headIv.setImageResource(R.drawable.load);
            if(pullToRelashListener!=null){
                isPull = true;
                pullToRelashListener.pull();
            }
        }
    }
    public interface PullToRelashListener {
        void pull();

        void load();
    }

    public void setOnPullToRelashListener(PullToRelashListener listener) {
        pullToRelashListener = listener;
    }
// 当adapter中的数据为0的时候怎么班
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                y = (int) event.getRawY();
                if(isPull||isLoad){
                    return  true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int minY = (int) (event.getRawY() - y) / 2;
                if (minY > 0 && gv.getFirstVisiblePosition() == 0||minY<0&&gv.getLastVisiblePosition()==(gv.getAdapter().getCount()-1)) {
                  if(minY<0){
                      int i = gv.getCount() - gv.getFirstVisiblePosition()-1;
                      View childAt = gv.getChildAt(i);
                      int bottom = childAt.getBottom();
                     if(bottom<=gv.getHeight()) {
                         Log.e("sda","进入了");
                         return true;
                     }else{
                         return false;
                     }

                  }
                    if(minY>0){
                        if(gv.getChildCount()==0)return false;
                        View childAt = gv.getChildAt(0);
                        if(childAt.getTop()==0) {
                            y = (int) event.getRawY();
                            return true;
                        }else
                            return false;
                    }

                }
                break;
        }
        return super.onInterceptTouchEvent(event);
    }
    public void setLoadSuccess(){
        footerIv.setImageResource(R.drawable.icon_loaing_frame_1);
        footerparams.bottomMargin=-measuredHeight;
        params.topMargin=0;
        footerIv.setLayoutParams(footerparams);
        gv.setLayoutParams(params);
        isLoad=false;
    }
    public void setPullSuccess(){
        headIv.setImageResource(R.drawable.icon_loaing_frame_1);
        headParams.topMargin=-measuredHeight;
        isPull=false;
        headIv.setLayoutParams(headParams);
    }
    private void pull(int minY) {
        if (minY > 0 && gv.getFirstVisiblePosition() == 0) {
            headParams.topMargin = -measuredHeight + minY;
            headIv.setLayoutParams(headParams);


        }
    }
}
