package com.billylu.android.utildemo.iView;


import com.billylu.android.utildemo.bean.CalendarInfoEntity;
import com.billylu.android.utildemo.bean.WeatherBeseEntity;

/**
 * Created by maning on 16/6/21.
 */
public interface IWeatherView {

    void showToast(String msg);

    void initWeatherInfo(WeatherBeseEntity.WeatherBean weatherEntity);

    void overRefresh();

    void updateCalendarInfo(CalendarInfoEntity calendarInfoEntity);

}
