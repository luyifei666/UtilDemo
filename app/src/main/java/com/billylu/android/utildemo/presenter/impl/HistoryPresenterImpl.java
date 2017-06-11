package com.billylu.android.utildemo.presenter.impl;

import android.content.Context;
import android.text.TextUtils;

import com.billylu.android.utildemo.http.GankApi;
import com.billylu.android.utildemo.http.MyCallBack;
import com.billylu.android.utildemo.iView.IHistoryView;
import com.billylu.android.utildemo.presenter.IHistoryPresenter;

import java.util.List;

/**
 * Created by maning on 16/6/21.
 */
public class HistoryPresenterImpl extends BasePresenterImpl<IHistoryView> implements IHistoryPresenter {

    private Context context;

    public HistoryPresenterImpl(Context context, IHistoryView iHistoryView) {
        this.context = context;
        attachView(iHistoryView);
    }

    private MyCallBack httpCallBack = new MyCallBack() {
        @Override
        public void onSuccessList(int what, List results) {
            if(mView == null){
                return;
            }
            mView.overRefresh();
            mView.setHistoryList(results);
        }

        @Override
        public void onSuccess(int what, Object result) {

        }

        @Override
        public void onFail(int what, String result) {
            if(mView == null){
                return;
            }
            mView.overRefresh();
            if (!TextUtils.isEmpty(result)) {
                mView.showToast(result);
            }
        }
    };

    @Override
    public void getHistoryDatas() {
        GankApi.getHistoryData(0x001, httpCallBack);
    }

}
