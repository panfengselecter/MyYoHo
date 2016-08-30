package com.example.administrator.myyoho.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.bean.BannerBean;
import com.example.administrator.myyoho.utils.DemoUtils;
import com.example.administrator.myyoho.utils.HttpModel;
import com.example.administrator.myyoho.utils.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/25.
 */
public class MyBanner extends RelativeLayout {

    private ViewPager pager;
    private LinearLayout dotsGroup;
    private List<BannerBean> list = new ArrayList<>();
    private List<View> bannerList = new ArrayList<>();
Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if(bannerList.size()>0){
            int i = pager.getCurrentItem() + 1;
            pager.setCurrentItem(i);
        }
        handler.sendEmptyMessageDelayed(0,3500);
    }
};
    private boolean isDrag;

    public MyBanner(Context context) {
        this(context, null);
    }

    public MyBanner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
//    postDelayed() 就可以类比成handler
    }

    public MyBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        pager = new ViewPager(getContext());
        addView(pager);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            Log.e("tag",position+"");
                if(bannerList.size()>0){
                    selectedDotChild(position%bannerList.size());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            Log.e("tag",state+"");
            if(state== ViewPager.SCROLL_STATE_DRAGGING){
                stopLoop();
                isDrag = true;
            }else {
                if(isDrag){
                    isDrag=false;
                    startLoop();
                }
            }
            }
        });
        dotsGroup = new LinearLayout(getContext());
        dotsGroup.setOrientation(LinearLayout.HORIZONTAL);
        dotsGroup.setGravity(Gravity.CENTER_VERTICAL);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, DemoUtils.dp2px(20));
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.bottomMargin = DemoUtils.dp2px(20);
        dotsGroup.setLayoutParams(params);
        addView(dotsGroup);
    }

    public void loadData(String url, String body) {

        new HttpUtils().loadData(url,body).setOnLoadDataListener(new HttpUtils.OnLoadDataListener() {
            @Override
            public void loadSuccess(String content) {
                List<BannerBean> temp = new Gson().fromJson(content, new TypeToken<List<BannerBean>>() {
                }.getType());
                list.clear();
                bannerList.clear();
                list.addAll(temp);
                for(int i=0;i<list.size();i++){
                    ImageView iv = getIv();
                    Picasso.with(getContext()).load(HttpModel.IMGHOST+list.get(i).getImgpath()).fit().error(R.mipmap.ic_launcher).into(iv);
                    bannerList.add(iv);
                }
                for(int i=0;i<list.size();i++){
                    dotsGroup.addView(getDot(i==0));
                }
                pager.setAdapter(new MyAdapter());
                pager.setCurrentItem(100*bannerList.size());
                startLoop();
            }

            @Override
            public void loadFailed(String msg) {

            }
        });
    }
    public void startLoop(){
        handler.sendEmptyMessageDelayed(0,5000);
    }
    public void stopLoop(){
        handler.removeCallbacksAndMessages(null);
    }


    private void selectedDotChild(int position){
        if(position<dotsGroup.getChildCount()){
            int childCount = dotsGroup.getChildCount();
            for(int i=0;i<childCount;i++){
                dotsGroup.getChildAt(i).setSelected(position==i);
            }
        }
    }

    private ImageView getIv(){
        ImageView iv=new ImageView(getContext());
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return iv;
    }

    private View getDot(boolean isWhite) {
        View view = new View(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DemoUtils.dp2px(10), DemoUtils.dp2px(10));
       params.leftMargin=DemoUtils.dp2px(10);
        view.setLayoutParams(params);
        view.setBackgroundResource(R.drawable.selector_banner_dot);
        if (isWhite) {
            view.setSelected(true);
        }
        return view;
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = bannerList.get(position%bannerList.size());
            ViewParent parent = view.getParent();
            if(parent!=null){
                ((ViewGroup)(parent)).removeView(view);
            }
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

//            container.removeView((View) object);
        }
    }

}
