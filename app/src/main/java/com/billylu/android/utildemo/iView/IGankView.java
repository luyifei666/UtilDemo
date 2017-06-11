package com.billylu.android.utildemo.iView;


import com.billylu.android.utildemo.bean.GankEntity;

import java.util.List;

/**
 * Created by maning on 16/6/21.
 */
public interface IGankView extends IBaseView{

    void showToast(String msg);

    void showImageView(String url);

    void setGankList(List<GankEntity> gankList);

    void setProgressBarVisility(int visility);

}
