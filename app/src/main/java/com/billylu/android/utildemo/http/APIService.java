package com.billylu.android.utildemo.http;

import com.billylu.android.utildemo.bean.AppUpdateInfo;
import com.billylu.android.utildemo.bean.CalendarInfoEntity;
import com.billylu.android.utildemo.bean.CitysEntity;
import com.billylu.android.utildemo.bean.DayEntity;
import com.billylu.android.utildemo.bean.GankEntity;
import com.billylu.android.utildemo.bean.HttpResult;
import com.billylu.android.utildemo.bean.RandomEntity;
import com.billylu.android.utildemo.bean.SearchBean;
import com.billylu.android.utildemo.bean.WeatherBeseEntity;
import com.billylu.android.utildemo.bean.mob.MobBankCard;
import com.billylu.android.utildemo.bean.mob.MobBaseEntity;
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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * 接口调用的工具类
 */
public interface APIService {

    //这里填写全部路径就会覆盖掉Build得BaseUrl
    @Headers("Cache-Control: public, max-age=3600")
    @GET(Constants.URL_HistoryDate)
    Call<HttpResult<List<String>>> getGankHistoryDate();

    //http://gank.io/api/data/Android/10/1
    @Headers("Cache-Control: public, max-age=120")
    @GET("data/{type}/{count}/{pageIndex}")
    Call<HttpResult<List<GankEntity>>> getCommonDateNew(@Path("type") String type,
                                                        @Path("count") int count,
                                                        @Path("pageIndex") int pageIndex
    );

    //http://gank.io/api/day/2015/08/06 --- 每日数据
    @Headers("Cache-Control: public, max-age=300")
    @GET("day/{year}/{month}/{day}")
    Call<DayEntity> getOneDayData(@Path("year") String year,
                                  @Path("month") String month,
                                  @Path("day") String day
    );

    //http://gank.io/api/random/data/Android/5 --- 随机数据
    @Headers("Cache-Control: public, max-age=300")
    @GET("random/data/{type}/{count}")
    Call<RandomEntity> getRandomDatas(@Path("type") String type,
                                      @Path("count") int count
    );

    //获取fir.im中的GankMM的最新版本
    @Headers("Cache-Control: public, max-age=3600")
    @GET(Constants.URL_AppUpdateInfo)
    Call<AppUpdateInfo> getTheLastAppInfo();


    //搜索
    //http://gank.io/api/search/query/listview/category/Android/count/10/page/1
    @Headers("Cache-Control: public, max-age=120")
    @GET("search/query/{keyword}/category/{type}/count/{count}/page/{pageIndex}")
    Call<HttpResult<List<SearchBean>>> getSearchData(@Path("keyword") String keyword,
                                                     @Path("type") String type,
                                                     @Path("count") int count,
                                                     @Path("pageIndex") int pageIndex
    );

    //获取天气信息
    @Headers("Cache-Control: public, max-age=300")
    @GET(Constants.URL_Mob + "v1/weather/query")
    Call<WeatherBeseEntity> getCityWeather(@Query("key") String appkey,
                                           @Query("city") String city,
                                           @Query("province") String province
    );

    //城市列表查询接口
    //http://apicloud.mob.com/v1/weather/citys?key=appkey
    @Headers("Cache-Control: public, max-age=300")
    @GET(Constants.URL_Mob + "v1/weather/citys")
    Call<CitysEntity> getCitys(@Query("key") String appkey
    );

    //万年历查询
    //http://apicloud.mob.com/appstore/calendar/day?key=appkey&date=2015-05-01
    @Headers("Cache-Control: public, max-age=300")
    @GET(Constants.URL_Mob + "appstore/calendar/day")
    Call<MobBaseEntity<CalendarInfoEntity>> getCalendarInfo(@Query("key") String appkey,
                                                            @Query("date") String date
    );

    //手机号码归属地查询
    //http://apicloud.mob.com/v1/mobile/address/query?phone=xxxx&key=1c9dccb9a2434
    @GET(Constants.URL_Mob + "v1/mobile/address/query")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<MobPhoneAddressEntity>> queryMobileAddress(@Query("key") String appkey,
                                                                  @Query("phone") String phone
    );

    //邮编查询
    //http://apicloud.mob.com/v1/postcode/query?code=102629&key=1c9dccb9a2434
    @GET(Constants.URL_Mob + "v1/postcode/query")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<MobPostCodeEntity>> queryPostCode(@Query("key") String appkey,
                                                         @Query("code") String code
    );

    //身份证查询
    //http://apicloud.mob.com/idcard/query?cardno=xxx&key=1c9dccb9a2434
    @GET(Constants.URL_Mob + "idcard/query")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<MobIdCardEntity>> queryIdcard(@Query("key") String appkey,
                                                     @Query("cardno") String cardno
    );

    //IP查询
    //http://apicloud.mob.com/ip/query?key=1c9dccb9a2434&ip=123.123.123.123
    @GET(Constants.URL_Mob + "ip/query")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<MobIpEntity>> queryIp(@Query("key") String appkey,
                                             @Query("ip") String ip
    );

    //微信精选分类查询
    //http://apicloud.mob.com/wx/article/category/query?key=123456
    @GET(Constants.URL_Mob + "wx/article/category/query")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<ArrayList<MobWxCategoryEntity>>> queryWxArticleCategory(@Query("key") String appkey
    );

    //微信精选列表查询
    //http://apicloud.mob.com/wx/article/search?key=123456&cid=1
    @GET(Constants.URL_Mob + "wx/article/search")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<MobWxArticleListEntity>> queryWxArticleList(@Query("key") String appkey,
                                                                   @Query("cid") String cid,
                                                                   @Query("page") int page,
                                                                   @Query("size") int size
    );

    /*金融基金*/

    //银行卡信息查询
    //http://apicloud.mob.com/appstore/bank/card/query?card=6228482898203884775&key=1c9dccb9a2434
    @GET(Constants.URL_Mob + "appstore/bank/card/query")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<MobBankCard>> queryBankCradInfo(@Query("key") String appkey,
                                                       @Query("card") String card
    );


    /*便民服务*/

    //健康知识
    //http://apicloud.mob.com/appstore/health/search?key=123456&name=巴豆
    @GET(Constants.URL_Mob + "appstore/health/search")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<MobHealthEntity>> queryHealth(@Query("key") String appkey,
                                                     @Query("name") String name,
                                                     @Query("page") int page,
                                                     @Query("size") int size
    );

    //历史上今天
    //http://apicloud.mob.com/appstore/history/query?day=0401&key=1c9dccb9a2434
    @GET(Constants.URL_Mob + "appstore/history/query")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<ArrayList<MobHistoryTodayEntity>>> queryHistory(@Query("key") String appkey,
                                                                       @Query("day") String day
    );

    //成语大全
    //http://apicloud.mob.com/appstore/idiom/query?name=%E4%B8%A2%E4%B8%89%E8%90%BD%E5%9B%9B&key=1c9dccb9a2434
    @GET(Constants.URL_Mob + "appstore/idiom/query")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<MobIdiomEntity>> queryIdiom(@Query("key") String appkey,
                                                   @Query("name") String name
    );

    //新华字典查询
    //http://apicloud.mob.com/appstore/dictionary/query?key=123456&name=赵
    @GET(Constants.URL_Mob + "appstore/dictionary/query")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<MobDictEntity>> queryDict(@Query("key") String appkey,
                                                 @Query("name") String name
    );

    //全国今日油价查询
    //http://apicloud.mob.com/oil/price/province/query?key=appkey
    @GET(Constants.URL_Mob + "oil/price/province/query")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<MobOilPriceEntity>> queryOilPrice(@Query("key") String appkey
    );

    //火车车次查询
    //http://apicloud.mob.com/train/tickets/queryByTrainNo?key=123456&trainno=G2
    @GET(Constants.URL_Mob + "train/tickets/queryByTrainNo")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<ArrayList<MobTrainNoEntity>>> queryByTrainNo(@Query("key") String appkey,
                                                                    @Query("trainno") String trainno
    );

    //火车站站查询
    //http://apicloud.mob.com/train/tickets/queryByStationToStation?key=123456&start=北京&end=上海
    @GET(Constants.URL_Mob + "train/tickets/queryByStationToStation")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<ArrayList<MobTrainEntity>>> queryByStationToStation(@Query("key") String appkey,
                                                                           @Query("start") String start,
                                                                           @Query("end") String end
    );

    //航线查询航班信息
    //http://apicloud.mob.com/flight/line/query?key=appkey&start=上海&end=海口
    @GET(Constants.URL_Mob + "flight/line/query")
    Call<com.billylu.android.utildemo.bean.MobBaseEntity<ArrayList<MobFlightEntity>>> queryFlightLineList(@Query("key") String appkey,
                                                                        @Query("start") String start,
                                                                        @Query("end") String end
    );

}
