package com.billylu.android.utildemo.bean.mob;

import java.io.Serializable;

/**
 * Created by maning on 2017/5/15.
 * 火车车次查询
 */

public class MobTrainNoEntity implements Serializable{


    private static final long serialVersionUID = 3315111492180766207L;
    /**
     * arriveTime : ----
     * endStationName : 北京南
     * startStationName : 上海虹桥
     * startTime : 09:00
     * stationName : 上海虹桥
     * stationNo : 01
     * stationTrainCode : G2
     * stopoverTime : ----
     * trainClassName : 高速
     */

    private String arriveTime;              //到达时间
    private String endStationName;          //终点站名
    private String startStationName;        //起始站名
    private String startTime;               //出发时间
    private String stationName;             //站点名
    private String stationNo;               //站点序号
    private String stationTrainCode;        //车次号
    private String stopoverTime;            //停留时间
    private String trainClassName;          //类型

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

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationNo() {
        return stationNo;
    }

    public void setStationNo(String stationNo) {
        this.stationNo = stationNo;
    }

    public String getStationTrainCode() {
        return stationTrainCode;
    }

    public void setStationTrainCode(String stationTrainCode) {
        this.stationTrainCode = stationTrainCode;
    }

    public String getStopoverTime() {
        return stopoverTime;
    }

    public void setStopoverTime(String stopoverTime) {
        this.stopoverTime = stopoverTime;
    }

    public String getTrainClassName() {
        return trainClassName;
    }

    public void setTrainClassName(String trainClassName) {
        this.trainClassName = trainClassName;
    }

    @Override
    public String toString() {
        return "MobTrainNoEntity{" +
                "arriveTime='" + arriveTime + '\'' +
                ", endStationName='" + endStationName + '\'' +
                ", startStationName='" + startStationName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", stationName='" + stationName + '\'' +
                ", stationNo='" + stationNo + '\'' +
                ", stationTrainCode='" + stationTrainCode + '\'' +
                ", stopoverTime='" + stopoverTime + '\'' +
                ", trainClassName='" + trainClassName + '\'' +
                '}';
    }
}
