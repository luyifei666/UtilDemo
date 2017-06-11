package com.billylu.android.utildemo.iView;


import com.billylu.android.utildemo.bean.GankEntity;

import java.util.ArrayList;

/**
 * Created by maning on 16/6/21.
 */
public interface ICollectPagerView {

    void setCollectList(ArrayList<GankEntity> collectList);

    void overRefresh();

}
