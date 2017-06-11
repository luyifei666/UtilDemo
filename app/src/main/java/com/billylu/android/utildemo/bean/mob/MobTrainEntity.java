package com.billylu.android.utildemo.bean.mob;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by maning on 2017/5/15.
 */

public class MobTrainEntity implements Serializable {


    private static final long serialVersionUID = 9168401286875037155L;

    /**
     * arriveTime : 13:05
     * endStationName : 武汉
     * lishi : 05:25
     * priceed : ¥520.5
     * pricesw : ¥1642.5
     * pricewz : ¥520.5
     * priceyd : ¥832.5
     * startStationName : 北京西
     * startTime : 07:40
     * stationTrainCode : G71
     * trainClassName : 高速
     */

    private String arriveTime;              //到达时间
    private String endStationName;          //到达站名
    private String lishi;                   //历时
    private String startStationName;        //出发站名
    private String startTime;               //出发时间
    private String stationTrainCode;        //车次号
    private String trainClassName;          //类型
    private String pricesw;                 //商务座票价
    private String pricetd;                 //特等座票价
    private String pricegrw;                //高级软卧票价
    private String pricerw;                 //软卧票价
    private String priceyw;                 //硬卧票价
    private String priceyd;                 //一等座票价
    private String priceed;                 //二等座票价
    private String pricerz;                 //硬座票价
    private String priceyz;                 //一等座票价
    private String pricewz;                 //无座票价


    //额外
    private ArrayList<MobTrainNoEntity> trainDetails;    //车次详情信息
    private boolean showDetails = false;                 //是否显示车次详细信息


    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getEndStationName() {
        return endStationName;
    }

    public void setEndStationName(String endStationName) {
        this.endStationName = endStationName;
    }

    public String getLishi() {
        return lishi;
    }

    public void setLishi(String lishi) {
        this.lishi = lishi;
    }

    public String getStartStationName() {
        return startStationName;
    }

    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStationTrainCode() {
        return stationTrainCode;
    }

    public void setStationTrainCode(String stationTrainCode) {
        this.stationTrainCode = stationTrainCode;
    }

    public String getTrainClassName() {
        return trainClassName;
    }

    public void setTrainClassName(String trainClassName) {
        this.trainClassName = trainClassName;
    }

    public String getPricesw() {
        return pricesw;
    }

    public void setPricesw(String pricesw) {
        this.pricesw = pricesw;
    }

    public String getPricetd() {
        return pricetd;
    }

    public void setPricetd(String pricetd) {
        this.pricetd = pricetd;
    }

    public String getPricegrw() {
        return pricegrw;
    }

    public void setPricegrw(String pricegrw) {
        this.pricegrw = pricegrw;
    }

    public String getPricerw() {
        return pricerw;
    }

    public void setPricerw(String pricerw) {
        this.pricerw = pricerw;
    }

    public String getPriceyw() {
        return priceyw;
    }

    public void setPriceyw(String priceyw) {
        this.priceyw = priceyw;
    }

    public String getPriceyd() {
        return priceyd;
    }

    public void setPriceyd(String priceyd) {
        this.priceyd = priceyd;
    }

    public String getPriceed() {
        return priceed;
    }

    public void setPriceed(String priceed) {
        this.priceed = priceed;
    }

    public String getPricerz() {
        return pricerz;
    }

    public void setPricerz(String pricerz) {
        this.pricerz = pricerz;
    }

    public String getPriceyz() {
        return priceyz;
    }

    public void setPriceyz(String priceyz) {
        this.priceyz = priceyz;
    }

    public String getPricewz() {
        return pricewz;
    }

    public void setPricewz(String pricewz) {
        this.pricewz = pricewz;
    }

    public boolean isShowDetails() {
        return showDetails;
    }

    public void setShowDetails(boolean showDetails) {
        this.showDetails = showDetails;
    }

    public ArrayList<MobTrainNoEntity> getTrainDetails() {
        return trainDetails;
    }

    public void setTrainDetails(ArrayList<MobTrainNoEntity> trainDetails) {
        this.trainDetails = trainDetails;
    }

    @Override
    public String toString() {
        return "MobTrainEntity{" +
                "arriveTime='" + arriveTime + '\'' +
                ", endStationName='" + endStationName + '\'' +
                ", lishi='" + lishi + '\'' +
                ", startStationName='" + startStationName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", stationTrainCode='" + stationTrainCode + '\'' +
                ", trainClassName='" + trainClassName + '\'' +
                ", pricesw='" + pricesw + '\'' +
                ", pricetd='" + pricetd + '\'' +
                ", pricegrw='" + pricegrw + '\'' +
                ", pricerw='" + pricerw + '\'' +
                ", priceyw='" + priceyw + '\'' +
                ", priceyd='" + priceyd + '\'' +
                ", priceed='" + priceed + '\'' +
                ", pricerz='" + pricerz + '\'' +
                ", priceyz='" + priceyz + '\'' +
                ", pricewz='" + pricewz + '\'' +
                '}';
    }
}
