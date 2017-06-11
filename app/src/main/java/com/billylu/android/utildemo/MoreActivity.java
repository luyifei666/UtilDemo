package com.billylu.android.utildemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.billylu.android.utildemo.adapter.RecycleMoreAdapter;
import com.billylu.android.utildemo.base.BaseActivity;
import com.billylu.android.utildemo.skin.SkinManager;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 更多功能的界面
 */
public class MoreActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private RecycleMoreAdapter recycleMoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        ButterKnife.bind(this);

        initMyToolBar();

        initRecyclerView();


        initAdapter();

    }

    private void initMyToolBar() {
        int currentSkinType = SkinManager.getCurrentSkinType(this);
        if (SkinManager.THEME_DAY == currentSkinType) {
            initToolBar(toolbar, "工具合集", R.drawable.gank_ic_back_white);
        } else {
            initToolBar(toolbar, "工具合集", R.drawable.gank_ic_back_night);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).color(Color.LTGRAY).build());
    }
    
    private void initAdapter() {
        ArrayList<String> mDatas = new ArrayList<>();
        mDatas.add("生活常用");
        mDatas.add("金融基金");
        mDatas.add("休闲旅游");
        mDatas.add("便民服务");
        recycleMoreAdapter = new RecycleMoreAdapter(this, mDatas);
        recyclerView.setAdapter(recycleMoreAdapter);

    }

}
