package com.billylu.android.utildemo.http;


import com.billylu.android.utildemo.app.MyApplication;
import com.billylu.android.utildemo.constant.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 获取网络框架类
 */
public class BuildApi {

    private static Retrofit retrofit;

    public static APIService getAPIService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASEURL) //设置Base的访问路径
                    .addConverterFactory(GsonConverterFactory.create()) //设置默认的解析库：Gson
                    .client(MyApplication.defaultOkHttpClient())
                    .build();
        }
        return retrofit.create(APIService.class);
    }

}
