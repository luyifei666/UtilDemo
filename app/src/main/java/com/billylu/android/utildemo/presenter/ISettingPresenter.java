package com.billylu.android.utildemo.presenter;

/**
 * Created by maning on 16/6/21.
 */
public interface ISettingPresenter {
    //初始化Push状态
    void initPushState();

    //改变Push状态
    void changePushState();

    //计算Cache大小
    void initCache();

    //清除缓存
    void cleanCache();

    //百川反馈
    void initFeedBack();

    //初始化版本更新的状态
    void initAppUpdateState();

    //检查更新
    void checkAppUpdate();

    //初始化夜间模式状态
    void initNightModeState();

    //初始化夜间模式状态
    void clickNightMode();

    //配置头条
    void configurationHeadLine();

    //初始化头条
    void initHeadLine();

}
