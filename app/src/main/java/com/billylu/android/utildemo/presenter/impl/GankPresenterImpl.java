package com.billylu.android.utildemo.presenter.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.billylu.android.utildemo.app.MyApplication;
import com.billylu.android.utildemo.bean.DayEntity;
import com.billylu.android.utildemo.bean.GankEntity;
import com.billylu.android.utildemo.http.GankApi;
import com.billylu.android.utildemo.http.MyCallBack;
import com.billylu.android.utildemo.iView.IGankView;
import com.billylu.android.utildemo.presenter.IGankPresenter;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maning on 16/6/21.
 */
public class GankPresenterImpl extends BasePresenterImpl<IGankView> implements IGankPresenter {

    private MyCallBack httpCallBack = new MyCallBack() {
        @Override
        public void onSuccessList(int what, List results) {

        }

        @Override
        public void onSuccess(int what, Object result) {
            if (mView == null) {
                return;
            }
            final DayEntity dayEntity = (DayEntity) result;
            if (dayEntity != null) {
                DayEntity.ResultsEntity results = dayEntity.getResults();
                if (results != null) {

                    List<GankEntity> 福利 = dayEntity.getResults().get福利();
                    if (福利 != null && 福利.size() > 0) {
                        String url = dayEntity.getResults().get福利().get(0).getUrl();
                        mView.setProgressBarVisility(View.GONE);
                        mView.showImageView(url);
                    } else {
                        mView.setProgressBarVisility(View.GONE);
                        mView.showToast("糟糕，图片没找到");
                    }
                    try {
                        //初始化数据
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                initDatas(dayEntity);
                            }
                        }).start();
                    } catch (Exception e) {
                        mView.showToast("抱歉，出错了...");
                    }
                } else {
                    mView.showToast("抱歉，当天数据没有...");
                }
            } else {
                mView.showToast("抱歉，当天数据没有...");
            }
        }

        @Override
        public void onFail(int what, String result) {
            if (mView == null) {
                return;
            }
            mView.hideBaseProgressDialog();
            if (!TextUtils.isEmpty(result)) {
                mView.showToast(result);
            }
        }
    };

    private Context context;

    public GankPresenterImpl(Context context, IGankView iGankView) {
        this.context = context;
        attachView(iGankView);
    }

    @Override
    public void getOneDayDatas(String timeStr) {
        if (TextUtils.isEmpty(timeStr)) {
            return;
        }
        //切割
        String[] dayArray = timeStr.split("-");
        if (dayArray.length > 2) {
            GankApi.getOneDayData(dayArray[0], dayArray[1], dayArray[2], 0x001, httpCallBack);
        }
    }


    private List<GankEntity> dayEntityArrayList = new ArrayList<>();

    private void initDatas(DayEntity dayEntity) {
        dayEntityArrayList.clear();

        List<GankEntity> androidEntityList = dayEntity.getResults().getAndroid();
        if (androidEntityList != null && androidEntityList.size() > 0) {
            GankEntity gankEntity_title = new GankEntity();
            gankEntity_title.setType("title");
            gankEntity_title.setDesc("Android");
            dayEntityArrayList.add(gankEntity_title);
            dayEntityArrayList.addAll(androidEntityList);
        }


        List<GankEntity> iosEntityList = dayEntity.getResults().getIOS();
        if (iosEntityList != null && iosEntityList.size() > 0) {
            GankEntity gankEntity_title = new GankEntity();
            gankEntity_title.setType("title");
            gankEntity_title.setDesc("iOS");
            dayEntityArrayList.add(gankEntity_title);
            dayEntityArrayList.addAll(iosEntityList);
        }


        List<GankEntity> 休息视频EntityList = dayEntity.getResults().get休息视频();
        if (休息视频EntityList != null && 休息视频EntityList.size() > 0) {
            GankEntity gankEntity_title = new GankEntity();
            gankEntity_title.setType("title");
            gankEntity_title.setDesc("休息视频");
            dayEntityArrayList.add(gankEntity_title);
            dayEntityArrayList.addAll(休息视频EntityList);
        }


        List<GankEntity> 拓展资源EntityList = dayEntity.getResults().get拓展资源();
        if (拓展资源EntityList != null && 拓展资源EntityList.size() > 0) {
            GankEntity gankEntity_title = new GankEntity();
            gankEntity_title.setType("title");
            gankEntity_title.setDesc("拓展资源");
            dayEntityArrayList.add(gankEntity_title);
            dayEntityArrayList.addAll(拓展资源EntityList);
        }

        KLog.i("dayEntityArrayList---" + dayEntityArrayList.size());
        MyApplication.getHandler().post(new Runnable() {
            @Override
            public void run() {
                if (mView != null) {
                    mView.setGankList(dayEntityArrayList);
                }
            }
        });
    }

}
