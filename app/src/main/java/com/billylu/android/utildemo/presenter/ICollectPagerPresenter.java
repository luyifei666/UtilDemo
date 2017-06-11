package com.billylu.android.utildemo.presenter;

import android.view.View;

/**
 * Created by maning on 16/6/21.
 */
public interface ICollectPagerPresenter {

    void getCollectLists(String flag);

    void itemClick(View view, int position);

}
