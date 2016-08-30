package com.example.administrator.myyoho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }
    public void start(View v){
        startActivity(new Intent(ChooseActivity.this,MainActivity.class));
        overridePendingTransition(R.anim.main_enter,R.anim.welcom_out);
    }

}
