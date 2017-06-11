package com.billylu.android.utildemo.http;

import com.billylu.android.utildemo.R;
import com.billylu.android.utildemo.app.MyApplication;
import com.billylu.android.utildemo.bean.MobBaseEntity;
import com.billylu.android.utildemo.bean.mob.MobBankCard;
import com.billylu.android.utildemo.bean.mob.MobDictEntity;
import com.billylu.android.utildemo.bean.mob.MobFlightEntity;
import com.billylu.android.utildemo.bean.mob.MobHealthEntity;
import com.billylu.android.utildemo.bean.mob.MobHistoryTodayEntity;
import com.billylu.android.utildemo.bean.mob.MobIdCardEntity;
import com.billylu.android.utildemo.bean.mob.MobIdiomEntity;
import com.billylu.android.utildemo.bean.mob.MobIpEntity;
import com.billylu.android.utildemo.bean.mob.MobOilPriceEntity;
import com.billylu.android.utildemo.bean.mob.MobPhoneAddressEntity;
import com.billylu.android.utildemo.bean.mob.MobPostCodeEntity;
import com.billylu.android.utildemo.bean.mob.MobTrainEntity;
import com.billylu.android.utildemo.bean.mob.MobTrainNoEntity;
import com.billylu.android.utildemo.bean.mob.MobWxArticleListEntity;
import com.billylu.android.utildemo.bean.mob.MobWxCategoryEntity;
import com.billylu.android.utildemo.constant.Constants;
import com.socks.library.KLog;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by maning on 2017/5/9.
 * Mob SDK 相关的API
 */

public class MobApi {

//    public final static String GET_DATA_FAIL = MyApplication.getIntstance().getString(R.string.gank_get_data_fail);
//    public final static String NET_FAIL = MyApplication.getIntstance().getString(R.string.gank_net_fail);

    public final static String GET_DATA_FAIL = "获取数据失败";
    public final static String NET_FAIL = "网络出问题啦";


    public static Call<MobBaseEntity<ArrayList<MobWxCategoryEntity>>> queryWxArticleCategory(final int what, final MyCallBack myCallBack) {
        Call<MobBaseEntity<ArrayList<MobWxCategoryEntity>>> wxArticleCategoryCall = BuildApi.getAPIService().queryWxArticleCategory(Constants.URL_APP_Key);
        wxArticleCategoryCall.enqueue(new Callback<MobBaseEntity<ArrayList<MobWxCategoryEntity>>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<ArrayList<MobWxCategoryEntity>>> call, Response<MobBaseEntity<ArrayList<MobWxCategoryEntity>>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<ArrayList<MobWxCategoryEntity>> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryWxArticleCategory---success：" + body.toString());
                            myCallBack.onSuccessList(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<ArrayList<MobWxCategoryEntity>>> call, Throwable t) {
                KLog.e("queryWxArticleCategory-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return wxArticleCategoryCall;
    }

    public static Call<MobBaseEntity<MobWxArticleListEntity>> queryWxArticleList(String cid, int pageIndex, int pageSize, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<MobWxArticleListEntity>> queryWxArticleListCall = BuildApi.getAPIService().queryWxArticleList(Constants.URL_APP_Key, cid, pageIndex, pageSize);
        queryWxArticleListCall.enqueue(new Callback<MobBaseEntity<MobWxArticleListEntity>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<MobWxArticleListEntity>> call, Response<MobBaseEntity<MobWxArticleListEntity>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<MobWxArticleListEntity> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryWxArticleList---success：" + body.toString());
                            myCallBack.onSuccess(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<MobWxArticleListEntity>> call, Throwable t) {
                KLog.e("queryWxArticleList-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return queryWxArticleListCall;

    }


    public static Call<MobBaseEntity<MobIpEntity>> queryIp(String ip, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<MobIpEntity>> call = BuildApi.getAPIService().queryIp(Constants.URL_APP_Key, ip);
        call.enqueue(new Callback<MobBaseEntity<MobIpEntity>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<MobIpEntity>> call, Response<MobBaseEntity<MobIpEntity>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<MobIpEntity> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryIp---success：" + body.toString());
                            myCallBack.onSuccess(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<MobIpEntity>> call, Throwable t) {
                KLog.e("queryIp-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }


    public static Call<MobBaseEntity<MobIdCardEntity>> queryIDCard(String idcardNum, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<MobIdCardEntity>> call = BuildApi.getAPIService().queryIdcard(Constants.URL_APP_Key, idcardNum);
        call.enqueue(new Callback<MobBaseEntity<MobIdCardEntity>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<MobIdCardEntity>> call, Response<MobBaseEntity<MobIdCardEntity>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<MobIdCardEntity> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryIdcard---success：" + body.toString());
                            myCallBack.onSuccess(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<MobIdCardEntity>> call, Throwable t) {
                KLog.e("queryIdcard-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }


    public static Call<MobBaseEntity<MobPostCodeEntity>> queryPostCode(String postCode, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<MobPostCodeEntity>> call = BuildApi.getAPIService().queryPostCode(Constants.URL_APP_Key, postCode);
        call.enqueue(new Callback<MobBaseEntity<MobPostCodeEntity>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<MobPostCodeEntity>> call, Response<MobBaseEntity<MobPostCodeEntity>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<MobPostCodeEntity> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryPostCode---success：" + body.toString());
                            myCallBack.onSuccess(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<MobPostCodeEntity>> call, Throwable t) {
                KLog.e("queryPostCode-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }


    public static Call<MobBaseEntity<MobPhoneAddressEntity>> queryPhoneAddress(String phoneNum, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<MobPhoneAddressEntity>> call = BuildApi.getAPIService().queryMobileAddress(Constants.URL_APP_Key, phoneNum);
        call.enqueue(new Callback<MobBaseEntity<MobPhoneAddressEntity>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<MobPhoneAddressEntity>> call, Response<MobBaseEntity<MobPhoneAddressEntity>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<MobPhoneAddressEntity> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryPhoneAddress---success：" + body.toString());
                            myCallBack.onSuccess(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<MobPhoneAddressEntity>> call, Throwable t) {
                KLog.e("queryPhoneAddress-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }


    public static Call<MobBaseEntity<MobBankCard>> queryBankCard(String content, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<MobBankCard>> call = BuildApi.getAPIService().queryBankCradInfo(Constants.URL_APP_Key, content);
        call.enqueue(new Callback<MobBaseEntity<MobBankCard>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<MobBankCard>> call, Response<MobBaseEntity<MobBankCard>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<MobBankCard> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryBankCard---success：" + body.toString());
                            myCallBack.onSuccess(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<MobBankCard>> call, Throwable t) {
                KLog.e("queryBankCard-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }


    public static Call<MobBaseEntity<MobOilPriceEntity>> queryOilPrice(final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<MobOilPriceEntity>> call = BuildApi.getAPIService().queryOilPrice(Constants.URL_APP_Key);
        call.enqueue(new Callback<MobBaseEntity<MobOilPriceEntity>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<MobOilPriceEntity>> call, Response<MobBaseEntity<MobOilPriceEntity>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<MobOilPriceEntity> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryOilPrice---success：" + body.toString());
                            myCallBack.onSuccess(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<MobOilPriceEntity>> call, Throwable t) {
                KLog.e("queryOilPrice-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }

    public static Call<MobBaseEntity<MobDictEntity>> queryDict(String content, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<MobDictEntity>> call = BuildApi.getAPIService().queryDict(Constants.URL_APP_Key, content);
        call.enqueue(new Callback<MobBaseEntity<MobDictEntity>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<MobDictEntity>> call, Response<MobBaseEntity<MobDictEntity>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<MobDictEntity> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryDict---success：" + body.toString());
                            myCallBack.onSuccess(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<MobDictEntity>> call, Throwable t) {
                KLog.e("queryDict-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }

    public static Call<MobBaseEntity<MobIdiomEntity>> queryIdiom(String content, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<MobIdiomEntity>> call = BuildApi.getAPIService().queryIdiom(Constants.URL_APP_Key, content);
        call.enqueue(new Callback<MobBaseEntity<MobIdiomEntity>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<MobIdiomEntity>> call, Response<MobBaseEntity<MobIdiomEntity>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<MobIdiomEntity> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryIdiom---success：" + body.toString());
                            myCallBack.onSuccess(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<MobIdiomEntity>> call, Throwable t) {
                KLog.e("queryIdiom-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }


    public static Call<MobBaseEntity<ArrayList<MobHistoryTodayEntity>>> queryHistory(String content, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<ArrayList<MobHistoryTodayEntity>>> call = BuildApi.getAPIService().queryHistory(Constants.URL_APP_Key, content);
        call.enqueue(new Callback<MobBaseEntity<ArrayList<MobHistoryTodayEntity>>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<ArrayList<MobHistoryTodayEntity>>> call, Response<MobBaseEntity<ArrayList<MobHistoryTodayEntity>>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<ArrayList<MobHistoryTodayEntity>> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryHistory---success：" + body.toString());
                            myCallBack.onSuccessList(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<ArrayList<MobHistoryTodayEntity>>> call, Throwable t) {
                KLog.e("queryHistory-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }


    public static Call<MobBaseEntity<MobHealthEntity>> queryHealth(String content, int pageIndex, int pageSize, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<MobHealthEntity>> call = BuildApi.getAPIService().queryHealth(Constants.URL_APP_Key, content, pageIndex, pageSize);
        call.enqueue(new Callback<MobBaseEntity<MobHealthEntity>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<MobHealthEntity>> call, Response<MobBaseEntity<MobHealthEntity>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<MobHealthEntity> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryHealth---success：" + body.toString());
                            myCallBack.onSuccess(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<MobHealthEntity>> call, Throwable t) {
                KLog.e("queryHealth-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }

    public static Call<MobBaseEntity<ArrayList<MobTrainNoEntity>>> queryByTrainNo(String trainNum, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<ArrayList<MobTrainNoEntity>>> call = BuildApi.getAPIService().queryByTrainNo(Constants.URL_APP_Key, trainNum);
        call.enqueue(new Callback<MobBaseEntity<ArrayList<MobTrainNoEntity>>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<ArrayList<MobTrainNoEntity>>> call, Response<MobBaseEntity<ArrayList<MobTrainNoEntity>>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<ArrayList<MobTrainNoEntity>> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryByTrainNo---success：" + body.toString());
                            myCallBack.onSuccessList(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<ArrayList<MobTrainNoEntity>>> call, Throwable t) {
                KLog.e("queryByTrainNo-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }

    public static Call<MobBaseEntity<ArrayList<MobTrainEntity>>> queryByStationToStation(String start, String end, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<ArrayList<MobTrainEntity>>> call = BuildApi.getAPIService().queryByStationToStation(Constants.URL_APP_Key, start, end);
        call.enqueue(new Callback<MobBaseEntity<ArrayList<MobTrainEntity>>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<ArrayList<MobTrainEntity>>> call, Response<MobBaseEntity<ArrayList<MobTrainEntity>>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<ArrayList<MobTrainEntity>> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryByStationToStation---success：" + body.toString());
                            myCallBack.onSuccessList(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<ArrayList<MobTrainEntity>>> call, Throwable t) {
                KLog.e("queryByStationToStation-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }

    public static Call<MobBaseEntity<ArrayList<MobFlightEntity>>> queryFlightLineList(String start, String end, final int what, final MyCallBack myCallBack) {

        Call<MobBaseEntity<ArrayList<MobFlightEntity>>> call = BuildApi.getAPIService().queryFlightLineList(Constants.URL_APP_Key, start, end);
        call.enqueue(new Callback<MobBaseEntity<ArrayList<MobFlightEntity>>>() {
            @Override
            public void onResponse(Call<MobBaseEntity<ArrayList<MobFlightEntity>>> call, Response<MobBaseEntity<ArrayList<MobFlightEntity>>> response) {
                if (response.isSuccessful()) {
                    MobBaseEntity<ArrayList<MobFlightEntity>> body = response.body();
                    if (body != null) {
                        if (body.getMsg().equals("success")) {
                            KLog.i("queryFlightLineList---success：" + body.toString());
                            myCallBack.onSuccessList(what, body.getResult());
                        } else {
                            myCallBack.onFail(what, body.getMsg());
                        }
                    } else {
                        myCallBack.onFail(what, GET_DATA_FAIL);
                    }
                } else {
                    myCallBack.onFail(what, GET_DATA_FAIL);
                }
            }

            @Override
            public void onFailure(Call<MobBaseEntity<ArrayList<MobFlightEntity>>> call, Throwable t) {
                KLog.e("queryFlightLineList-----onFailure：" + t.toString());
                //数据错误
                myCallBack.onFail(what, NET_FAIL);
            }
        });

        return call;

    }

}
