package com.billylu.android.utildemo.iView;

import com.billylu.android.utildemo.bean.AppUpdateInfo;

/**
 * Created by maning on 16/6/21.
 */
public interface ISettingView extends IBaseView {

    void openPush();

    void closePush();

    void openNightMode();

    void closeNightMode();

    void recreateActivity();

    void setCacheSize(String cacheSize);

    void setFeedbackState(boolean flag);

    void setAppUpdateState(boolean flag);

    void showAppUpdateDialog(AppUpdateInfo appUpdateInfo);

    void showBasesProgressSuccess(String msg);

    void showToast(String msg);

    void updateHeadLine(String type);
}
