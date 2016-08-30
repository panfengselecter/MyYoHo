package com.example.administrator.myyoho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.administrator.myyoho.bean.ConfigBean;
import com.example.administrator.myyoho.utils.SpuUtils;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends BaseActivity {
    private ViewPager pager;
    private List<View> pagerlist;
    private ImageButton img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_pager);
        initView();
        init();
        initadapter();
        initpagerlistener();
    }
    private void initpagerlistener() {
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewPagerActivity.this,SuoFangActivity.class));
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });


        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if (position == pagerlist.size() - 1) {
                img.setVisibility(View.VISIBLE);
                }else {
                    img.setVisibility(View.GONE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    private void init() {
        pagerlist = new ArrayList<>();
        pagerlist.add(getView(R.drawable.guide_1));
        pagerlist.add(getView(R.drawable.guide_2));
        pagerlist.add(getView(R.drawable.guide_3));
        pagerlist.add(getView(R.drawable.guide_4));
        pagerlist.add(getView(R.drawable.guide_5));
    }
    private void initadapter() {
        pager.setAdapter(new MyAdapter());
    }

    public View getView(int resuld) {
        RelativeLayout relativeLayout=new RelativeLayout(this);
        ImageView iv = new ImageView(this);
        iv.setImageResource(resuld);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(screenweith,screenheight);
        iv.setLayoutParams(params);
        relativeLayout.addView(iv);
        return relativeLayout;
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager);
        img = (ImageButton) findViewById(R.id.img);
    }


    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return pagerlist.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View imageView = pagerlist.get(position);
            container.addView(imageView);
            return imageView;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
