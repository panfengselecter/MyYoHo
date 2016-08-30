package com.example.administrator.myyoho.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27 0027.
 */
public class LetterBean {
    public String title;
    public List<PinPaiAllHotBean.BrandBean> list;

    public LetterBean(String title, List<PinPaiAllHotBean.BrandBean> list) {
        this.title = title;
        this.list = list;
    }

    @Override
    public String toString() {
        return "LetterBean{" +
                "title='" + title + '\'' +
                ", list=" + list +
                '}';
    }
}
