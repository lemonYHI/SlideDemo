package com.lemon.slidedemo.listviewSlide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.lemon.slidedemo.R;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 主要填充listview的数据
 */
public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private List<SlideBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        initData();
        lv.setAdapter(new SlideAdapter<SlideBean>(mDatas,this,R.layout.item){

            @Override
            public void convert(final ViewHolder holder, SlideBean slideBean, final int position) {
                holder.setText(R.id.content,slideBean.name);
                holder.setOnClickListener(R.id.content, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"poisition:"+position,Toast.LENGTH_SHORT).show();
                    }
                });
                holder.setOnClickListener(R.id.btnDelete, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"删除:"+position,Toast.LENGTH_SHORT).show();
                        ((SwipeMenuLayout) holder.getConvertView()).quickClose();
                        mDatas.remove(position);
                        notifyDataSetChanged();
                    }
                });


            }
        });

    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDatas.add(new SlideBean("数据：" + i));
        }
    }
}
