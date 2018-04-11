package com.lemon.slidedemo.RecyclerViewSlide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lemon.slidedemo.R;

import java.util.List;

/**
 * Created by lemon on 2018/4/4.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<String> mlist;
    private Context mcxt;


    public RecyclerViewAdapter(List mlist, Context mcxt) {
        this.mlist = mlist;
        this.mcxt = mcxt;
    }

    /**
     * 加载子item布局
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcxt).inflate(R.layout.item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * 对子item 进行赋值
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String value = mlist.get(position);
        holder.tv_content.setText(value);
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlist.remove(position);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_content;
        Button btn_top,btn_unread,btn_delete;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_content = itemView.findViewById(R.id.content);
            btn_top = itemView.findViewById(R.id.btnTop);
            btn_unread = itemView.findViewById(R.id.btnUnRead);
            btn_delete = itemView.findViewById(R.id.btnDelete);
        }
    }


}
