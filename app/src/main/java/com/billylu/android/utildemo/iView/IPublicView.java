package com.billylu.android.utildemo.iView;


import com.billylu.android.utildemo.bean.GankEntity;

import java.util.List;

/**
 * Created by maning on 16/6/21.
 */
public interface IPublicView {

    void setPublicList(List<GankEntity> publicList);

    void showToast(String msg);

    void overRefresh();

    void setLoadMoreEnabled(boolean flag);

    void setRefreshing(boolean flag);

}
