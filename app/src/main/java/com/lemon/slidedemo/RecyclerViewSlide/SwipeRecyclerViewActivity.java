package com.lemon.slidedemo.RecyclerViewSlide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lemon.slidedemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lemon on 2018/4/4.
 */

public class SwipeRecyclerViewActivity extends AppCompatActivity {

    List mlist;
    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initData();
        rv = findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mlist,this);
        rv.setAdapter(adapter);
    }

    private void initData() {
        mlist = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            mlist.add("data:"+i);
        }
    }
}
