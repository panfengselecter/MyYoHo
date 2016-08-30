package com.example.administrator.myyoho;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.myyoho.bean.ConfigBean;
import com.example.administrator.myyoho.utils.SpuUtils;

public class SuoFangActivity extends AppCompatActivity {

    private ImageView suofang_img;
    private ImageView suofang_shadow_img;
    private Button suo_fang_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SpuUtils.save(ConfigBean.isfirst,"true");
        setContentView(R.layout.activity_suo_fang);
        initView();
        initanmatior();
    }
    private void initanmatior() {
        ValueAnimator animator=ValueAnimator.ofFloat(1.5f,1);

    }

    private void initView() {
        suofang_img = (ImageView) findViewById(R.id.suofang_img);
        suofang_shadow_img = (ImageView) findViewById(R.id.suofang_shadow_img);
        suo_fang_btn = (Button) findViewById(R.id.suo_fang_btn);
    }
    public void click(View v){
        startActivity(new Intent(SuoFangActivity.this,ChooseActivity.class));
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}

