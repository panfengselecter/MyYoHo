package com.example.administrator.myyoho.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.utils.DemoUtils;

/**
 * Created by Administrator on 2016/8/29 0029.
 */
public class MyListView extends RelativeLayout {

    private int measuredHeight;
    private int y;
    private ListView lv;
    private ImageView headiv;
    private ImageView bottmoiv;
    private LayoutParams lvparams;
    private LayoutParams bottomparams;
    private LayoutParams headparams;

    public MyListView(Context context) {
        this(context,null);
    }

    public MyListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        headiv = new ImageView(getContext());
        headparams = new LayoutParams(LayoutParams.MATCH_PARENT, DemoUtils.dp2px(30));
        headiv.setLayoutParams(headparams);
        headiv.setId(R.id.head);

        bottmoiv = new ImageView(getContext());
        bottomparams = new LayoutParams(LayoutParams.MATCH_PARENT, DemoUtils.dp2px(30));
        bottmoiv.setLayoutParams(bottomparams);
        bottmoiv.setId(R.id.bottom);

        lv = new ListView(getContext());
        lvparams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT );
        lv.setLayoutParams(lvparams);
        lvparams.addRule(BELOW,R.id.head);
        lvparams.addRule(ABOVE,R.id.bottom);
        measuredHeight = headiv.getMeasuredHeight();

        headiv.measure(0,0);
        headparams.topMargin=-measuredHeight;
        bottomparams.bottomMargin=-measuredHeight;
        addView(headiv);
        addView(bottmoiv);
        addView(lv);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                y = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int min = (int) (event.getRawY() - y);
                if(min>0&&lv.getFirstVisiblePosition()==0){
                    headparams.topMargin=-measuredHeight+min;
                    headiv.setLayoutParams(headparams);
                }



                break;
            case MotionEvent.ACTION_UP:

                break;


        }



        return super.onTouchEvent(event);
    }
}
