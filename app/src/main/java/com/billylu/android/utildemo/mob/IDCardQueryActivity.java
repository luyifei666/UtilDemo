package com.billylu.android.utildemo.mob;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;


import com.billylu.android.utildemo.R;
import com.billylu.android.utildemo.adapter.RecycleMobQueryAdapter;
import com.billylu.android.utildemo.base.BaseActivity;
import com.billylu.android.utildemo.bean.mob.MobIdCardEntity;
import com.billylu.android.utildemo.bean.mob.MobItemEntity;
import com.billylu.android.utildemo.http.MobApi;
import com.billylu.android.utildemo.http.MyCallBack;
import com.billylu.android.utildemo.skin.SkinManager;
import com.billylu.android.utildemo.utils.KeyboardUtils;
import com.billylu.android.utildemo.utils.MySnackbar;
import com.billylu.android.utildemo.view.MClearEditText;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 身份证查询
 */
public class IDCardQueryActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.editTextPhone)
    MClearEditText editTextPhone;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private RecycleMobQueryAdapter recycleMobQueryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idcard_query);
        ButterKnife.bind(this);

        initMyToolBar();

        initRecyclerView();

    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initMyToolBar() {
        int currentSkinType = SkinManager.getCurrentSkinType(this);
        if (SkinManager.THEME_DAY == currentSkinType) {
            initToolBar(toolbar, "身份证查询", R.drawable.gank_ic_back_white);
        } else {
            initToolBar(toolbar, "身份证查询", R.drawable.gank_ic_back_night);
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


    @OnClick(R.id.btn_query)
    public void btnQuery() {

        KeyboardUtils.hideSoftInput(this);

        //获取输入
        String number = editTextPhone.getText().toString();

        if (TextUtils.isEmpty(number)) {
            MySnackbar.makeSnackBarRed(toolbar, "身份证号码不能为空");
            return;
        }

        showProgressDialog("正在查询...");
        MobApi.queryIDCard(number, 0x001, new MyCallBack() {
            @Override
            public void onSuccess(int what, Object object) {
                dissmissProgressDialog();
                if (object != null) {
                    MobIdCardEntity result = (MobIdCardEntity) object;
                    initAdapter(result);
                }
            }

            @Override
            public void onSuccessList(int what, List results) {

            }

            @Override
            public void onFail(int what, String result) {
                dissmissProgressDialog();
                MySnackbar.makeSnackBarRed(toolbar,result);
            }
        });

    }

    private void initAdapter(MobIdCardEntity result) {

        HashMap<String, Object> mDatas = new HashMap<>();
        mDatas.put("0", new MobItemEntity("地区:", result.getArea()));
        mDatas.put("1", new MobItemEntity("生日:", result.getBirthday()));
        mDatas.put("2", new MobItemEntity("性别:", result.getSex()));

        if (recycleMobQueryAdapter == null) {
            recycleMobQueryAdapter = new RecycleMobQueryAdapter(this, mDatas);
            recyclerView.setAdapter(recycleMobQueryAdapter);
        } else {
            recycleMobQueryAdapter.updateDatas(mDatas);
        }

    }

}
