package com.billylu.android.utildemo.presenter.impl;

import android.content.Context;
import android.text.TextUtils;

import com.billylu.android.utildemo.bean.CalendarInfoEntity;
import com.billylu.android.utildemo.bean.WeatherBeseEntity;
import com.billylu.android.utildemo.http.GankApi;
import com.billylu.android.utildemo.http.MyCallBack;
import com.billylu.android.utildemo.iView.IWeatherView;
import com.billylu.android.utildemo.presenter.IWeatherPresenter;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by maning on 2017/4/10.
 */

public class WeatherPresenterImpl extends BasePresenterImpl<IWeatherView> implements IWeatherPresenter {

    private Context context;

    private MyCallBack httpCallBack = new MyCallBack() {
        @Override
        public void onSuccessList(int what, List results) {
            mView.overRefresh();
            if (mView == null) {
                return;
            }
            if (results == null) {
                return;
            }
            switch (what) {
                case 0x003:
                    List<WeatherBeseEntity.WeatherBean> weathers = results;
                    if (weathers.size() > 0) {
                        WeatherBeseEntity.WeatherBean resultBean = weathers.get(0);
                        if (resultBean != null) {
                            mView.initWeatherInfo(resultBean);
                        }
                    }
                    break;
            }
        }

        @Override
        public void onSuccess(int what, Object result) {
            if (mView == null) {
                return;
            }
            if (result == null) {
                return;
            }
            switch (what) {
                case 0x001:
                    CalendarInfoEntity calendarInfoEntity = (CalendarInfoEntity) result;
                    //刷新界面
                    mView.updateCalendarInfo(calendarInfoEntity);
                    break;
            }
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

    public WeatherPresenterImpl(Context context, IWeatherView iWeatherView) {
        this.context = context;
        attachView(iWeatherView);
    }

    @Override
    public void getCityWeather(String provinceName, String cityName) {
        GankApi.getCityWeather(cityName, provinceName, 0x003, httpCallBack);
    }

    @Override
    public void getCalendarInfo() {
        //获取当天日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new java.util.Date());
        GankApi.getCalendarInfo(date, 0x001, httpCallBack);
    }
}
