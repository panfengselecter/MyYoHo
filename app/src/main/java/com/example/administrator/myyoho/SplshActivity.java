package com.example.administrator.myyoho;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.BounceInterpolator;
import android.widget.RelativeLayout;

import com.example.administrator.myyoho.animator.BaseAnimatorListener;
import com.example.administrator.myyoho.bean.ConfigBean;
import com.example.administrator.myyoho.utils.SpuUtils;

public class SplshActivity extends AppCompatActivity {

    private RelativeLayout SplashView;
    private int height;
    private ObjectAnimator objectAnimator;
    private boolean isfirst =true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        initView();
        height = getWindowManager().getDefaultDisplay().getHeight();
        init();

    }

    private void init() {
        SplashView.setTranslationY(-height);
        objectAnimator = ObjectAnimator.ofFloat(SplashView,"translationY",-height,0);
        objectAnimator.setDuration(1500);
        objectAnimator.setInterpolator(new BounceInterpolator());
        objectAnimator.addListener(new BaseAnimatorListener(){
            @Override
            public void onAnimationEnd(Animator animation) {
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String s = SpuUtils.get(ConfigBean.isfirst);
                if(!s.equals("true")){
                    startActivity(new Intent(SplshActivity.this,ViewPagerActivity.class));

                }else {
                    startActivity(new Intent(SplshActivity.this,SuoFangActivity.class));
                }
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        },500);
            }
        });
    }

    private void initView() {
        SplashView = (RelativeLayout) findViewById(R.id.SplashView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isfirst) {
            isfirst=false;
            objectAnimator.start();

        }
    }

}
