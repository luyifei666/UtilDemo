package com.billylu.android.utildemo.utils;

import com.billylu.android.utildemo.app.MyApplication;
import com.billylu.android.utildemo.bean.CitysEntity;

/**
 * Created by maning on 2017/4/1.
 */

public class UserUtils {

    private static final String cache_citys = "Cache_Citys";

    public static void saveCitysCache(CitysEntity citysEntity) {
        if (citysEntity != null) {
            MyApplication.getACache().put(cache_citys, citysEntity);
        }
    }

    public static CitysEntity getCitysCache() {
        CitysEntity citysEntity = (CitysEntity) MyApplication.getACache().getAsObject(cache_citys);
        return citysEntity;
    }

}
