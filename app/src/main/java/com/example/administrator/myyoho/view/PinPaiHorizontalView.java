package com.example.administrator.myyoho.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myyoho.R;
import com.example.administrator.myyoho.bean.PinPaiHotBean;
import com.example.administrator.myyoho.utils.HttpUtils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class PinPaiHorizontalView extends LinearLayout {
    private List<PinPaiHotBean.BrandBean> brand;
    private RecyclerView recycle;

    public PinPaiHorizontalView(Context context) {
        this(context,null);
    }

    public PinPaiHorizontalView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PinPaiHorizontalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = View.inflate(getContext(), R.layout.pin_pai_horinoent_view, null);
        recycle = (RecyclerView) view.findViewById(R.id.pin_pai_recycle);
        addView(view);
        initadapter();
        //这只布局管理器
        recycle.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

    }
    public void initadapter(){
        recycle.setAdapter(new MyAdapter());

    }
    public void  loaddata(String url,String body){

        new HttpUtils().loadData(url,body).setOnLoadDataListener(new HttpUtils.OnLoadDataListener() {
            @Override
            public void loadSuccess(String content) {
                boolean b = content.startsWith("{") || content.startsWith("[");
                if(b) {
                    PinPaiHotBean pinPaiHotBean = new Gson().fromJson(content, PinPaiHotBean.class);
                    brand = pinPaiHotBean.getBrand();
                }else {
                    Toast.makeText(getContext(),"数据出错",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void loadFailed(String msg) {

            }
        });
    }
    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            return new MyViewHolder(View.inflate(getContext(),R.layout.item_pin_pai_hot,null));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            PinPaiHotBean.BrandBean brandBean = brand.get(position);
            holder.hottv.setText(brandBean.getName());
            Picasso.with(getContext()).load(brandBean.getImgpath()).error(R.mipmap.ic_launcher).into(holder.hotimg);
        }

        @Override
        public int getItemCount() {
            return brand.size();
        }
    }
class MyViewHolder extends RecyclerView.ViewHolder{


    TextView hottv;
    ImageView hotimg;

    public MyViewHolder(View itemView) {
        super(itemView);
        hotimg = (ImageView) itemView.findViewById(R.id.hot_img);
        hottv = (TextView) itemView.findViewById(R.id.hot_tv);


    }
}

}
