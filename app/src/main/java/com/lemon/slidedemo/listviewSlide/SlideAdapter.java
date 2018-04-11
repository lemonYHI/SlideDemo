package com.lemon.slidedemo.listviewSlide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by lemon on 2018/4/4.
 * listview 和 data 的适配器
 */

public abstract class SlideAdapter<T> extends BaseAdapter {
    private List<T> mDatas;
    private Context mContext;
    private LayoutInflater mInflater;
    private int layoutId;

    public SlideAdapter(List<T> mDatas, Context mContext,  int layoutId) {
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.mInflater =LayoutInflater.from(mContext);
        this.layoutId = layoutId;
    }




    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(this.mContext, convertView, parent, this.layoutId, position);
        this.convert(holder,this.getItem(position),position);
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder var1,T var2,int var3);
}
