package com.billylu.android.utildemo.mob;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.billylu.android.utildemo.R;
import com.billylu.android.utildemo.adapter.OilPriceAdapter;
import com.billylu.android.utildemo.base.BaseActivity;
import com.billylu.android.utildemo.bean.mob.MobOilPriceEntity;
import com.billylu.android.utildemo.http.MobApi;
import com.billylu.android.utildemo.http.MyCallBack;
import com.billylu.android.utildemo.skin.SkinManager;
import com.kelin.scrollablepanel.library.ScrollablePanel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 全国油价信息
 */
public class OilPriceActivity extends BaseActivity {

    private static final String TAG = "OilPriceActivity";
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.scrollable_panel)
    ScrollablePanel scrollablePanel;

    private MobOilPriceEntity mobOilPriceEntity;
    private HashMap<String, MobOilPriceEntity.OilBean> modelAttributeAndValueMap;
    private ArrayList<String> proviceNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil_price);
        ButterKnife.bind(this);

        initMyToolBar();

        //查询数据
        queryData();

    }

    @SuppressLint("LongLogTag")
    private void queryData() {
        showProgressDialog("查询中...");
        MobApi.queryOilPrice(0x001, new MyCallBack() {
            @Override
            public void onSuccess(int what, Object result) {
                dissmissProgressDialog();
                mobOilPriceEntity = (MobOilPriceEntity) result;
                Log.i(TAG, mobOilPriceEntity.toString());
                modelAttributeAndValueMap = getModelAttributeAndValue(mobOilPriceEntity);
                initAdapter();
            }

            @Override
            public void onSuccessList(int what, List results) {

            }

            @Override
            public void onFail(int what, String result) {
                dissmissProgressDialog();
            }
        });

    }


    private void initMyToolBar() {
        int currentSkinType = SkinManager.getCurrentSkinType(this);
        if (SkinManager.THEME_DAY == currentSkinType) {
            initToolBar(toolbar, "全国油价信息", R.drawable.gank_ic_back_white);
        } else {
            initToolBar(toolbar, "全国油价信息", R.drawable.gank_ic_back_night);
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


    private void initAdapter() {
        OilPriceAdapter oilPriceAdapter = new OilPriceAdapter(this, modelAttributeAndValueMap, proviceNames);
        scrollablePanel.setPanelAdapter(oilPriceAdapter);
    }


    /**
     * java读取文件中的属性类型
     *
     * @param model
     * @return
     */
    public HashMap<String, MobOilPriceEntity.OilBean> getModelAttributeAndValue(Object model) {
        HashMap<String, MobOilPriceEntity.OilBean> map = new HashMap<>();
        try {
            Class cls = model.getClass();
            Field[] fields = cls.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
//                Log.i(TAG, "属性名:" + f.getName() + " 属性值:" + f.get(model).toString());
                map.put(f.getName(), (MobOilPriceEntity.OilBean) f.get(model));
                proviceNames.add(f.getName());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }

}
