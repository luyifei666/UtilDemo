package com.billylu.android.utildemo.iView;

import com.billylu.android.utildemo.bean.GankEntity;

import java.util.List;

/**
 * Created by maning on 16/6/21.
 */
public interface IWelFareView {

    void setWelFareList(List<GankEntity> welFareList);

    void setRandomList(List<GankEntity> randomList);

    void showToast(String msg);

    void overRefresh();

    void setLoadMoreEnabled(boolean flag);

}
