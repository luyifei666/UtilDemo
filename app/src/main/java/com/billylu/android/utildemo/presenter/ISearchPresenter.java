package com.billylu.android.utildemo.presenter;

/**
 * Created by maning on 2017/3/1.
 * 搜索
 */

public interface ISearchPresenter {

    void searchDatas(String keyWords);

    void loadMoreDatas();

    void itemClick(int position);

}
