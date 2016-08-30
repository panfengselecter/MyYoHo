package com.example.administrator.myyoho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;

import com.example.administrator.myyoho.fragment.FenLeiFragment;
import com.example.administrator.myyoho.fragment.GuangFragment;
import com.example.administrator.myyoho.fragment.ShouYeFragment;
import com.example.administrator.myyoho.fragment.WoDeFragment;
import com.example.administrator.myyoho.view.MySlidingMenu;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton shouye;
    private RadioButton fenlei;
    private RadioButton guang;
    private RadioButton gouwuche;
    private RadioButton wode;
    HashMap<String, Fragment> fragmentlist = new HashMap<>();
    private FragmentManager fm;
    String fragementtag = "";
    private FrameLayout fragmentgroup;
    private ListView navigationlv;
    private MySlidingMenu sldingmeun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        infragment();
        initlistener();
    }
    public void open(View v){
        sldingmeun.openPane();
    }


    private void initreplecefragment(String tag) {
        Fragment fragment = fragmentlist.get(tag);
        if (!fragementtag.equals(tag)) {
            fm.beginTransaction().replace(R.id.fragmentgroup, fragment, tag).commit();

        }
        fragementtag = tag;
    }

    public void infragment() {
        fm = getSupportFragmentManager();
        fragmentlist.put(ShouYeFragment.class.getSimpleName(), new ShouYeFragment());
        fragmentlist.put(FenLeiFragment.class.getSimpleName(), new FenLeiFragment());
        fragmentlist.put(GuangFragment.class.getSimpleName(), new GuangFragment());
        fragmentlist.put(WoDeFragment.class.getSimpleName(), new WoDeFragment());
        initreplecefragment(ShouYeFragment.class.getSimpleName());
    }

    private void initlistener() {
        shouye.setOnClickListener(this);
        fenlei.setOnClickListener(this);
        guang.setOnClickListener(this);
        gouwuche.setOnClickListener(this);
        wode.setOnClickListener(this);
        navigationlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            sldingmeun.closePane();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.welcom_enter, R.anim.main_oiut);
    }
    private void initView() {
        shouye = (RadioButton) findViewById(R.id.shouye);
        fenlei = (RadioButton) findViewById(R.id.fenlei);
        guang = (RadioButton) findViewById(R.id.guang);
        gouwuche = (RadioButton) findViewById(R.id.gouwuche);
        wode = (RadioButton) findViewById(R.id.wode);
        fragmentgroup = (FrameLayout) findViewById(R.id.fragmentgroup);
        navigationlv = (ListView) findViewById(R.id.navigationlv);
        sldingmeun = (MySlidingMenu) findViewById(R.id.sldingmeun);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shouye:
                initreplecefragment(ShouYeFragment.class.getSimpleName());
                break;
            case R.id.fenlei:
                initreplecefragment(FenLeiFragment.class.getSimpleName());
                break;
            case R.id.guang:
                initreplecefragment(GuangFragment.class.getSimpleName());
                break;
            case R.id.gouwuche:
                initactivity();
                break;
            case R.id.wode:
                initreplecefragment(WoDeFragment.class.getSimpleName());
                break;
        }
    }

    private void initactivity() {

        startActivity(new Intent(this, GouWuCheActivity.class));
        finish();
    }



}
