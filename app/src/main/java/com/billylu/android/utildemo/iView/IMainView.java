package com.billylu.android.utildemo.iView;


import com.billylu.android.utildemo.bean.AppUpdateInfo;
import com.billylu.android.utildemo.bean.WeatherBeseEntity;

/**
 * Created by maning on 16/6/21.
 */
public interface IMainView {

    void showToast(String msg);

    void showFeedBackDialog();

    void showAppUpdateDialog(AppUpdateInfo appUpdateInfo);

    void initWeatherInfo(WeatherBeseEntity.WeatherBean weatherEntity);

    void updateLocationInfo(String provinceName, String cityName);

}
