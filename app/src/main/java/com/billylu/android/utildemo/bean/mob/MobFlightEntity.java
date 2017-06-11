package com.billylu.android.utildemo.bean.mob;

import java.io.Serializable;

/**
 * Created by maning on 2017/5/15.
 * 飞机航班信息查询
 */

public class MobFlightEntity implements Serializable{


    private static final long serialVersionUID = 3082987474699713209L;
    /**
     * airLines : 中国南方航空公司
     * flightNo : CZ6606
     * flightRate : 98%
     * flightTime : 1h37m
     * from : 首都国际机场
     * fromAirportCode : PEK
     * fromCityCode : BJS
     * fromCityName : 北京
     * fromTerminal : T2
     * planArriveTime : 09:05
     * planTime : 06:50
     * to : 天河国际机场
     * toAirportCode : WUH
     * toCityCode : WUH
     * toCityName : 武汉
     * toTerminal : T2
     * week : 三,五,日
     */

    private String airLines;            //航空公司
    private String flightNo;            //航班号
    private String flightRate;          //航班准点率
    private String flightTime;          //航行时间
    private String from;                //出发机场
    private String fromAirportCode;     //出发机场代码
    private String fromCityCode;        //出发城市代码
    private String fromCityName;        //出发城市名称
    private String fromTerminal;        //出发航站楼
    private String planArriveTime;      //计划起飞时间
    private String planTime;            //计划到达时间
    private String to;                  //到达机场
    private String toAirportCode;       //到达机场代码
    private String toCityCode;          //到达城市代码
    private String toCityName;          //到达城市名称
    private String toTerminal;          //到达城市航站楼
    private String week;                //航班周期

    public String getAirLines() {
        return airLines;
    }

    public void setAirLines(String airLines) {
        this.airLines = airLines;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getFlightRate() {
        return flightRate;
    }

    public void setFlightRate(String flightRate) {
        this.flightRate = flightRate;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromAirportCode() {
        return fromAirportCode;
    }

    public void setFromAirportCode(String fromAirportCode) {
        this.fromAirportCode = fromAirportCode;
    }

    public String getFromCityCode() {
        return fromCityCode;
    }

    public void setFromCityCode(String fromCityCode) {
        this.fromCityCode = fromCityCode;
    }

    public String getFromCityName() {
        return fromCityName;
    }

    public void setFromCityName(String fromCityName) {
        this.fromCityName = fromCityName;
    }

    public String getFromTerminal() {
        return fromTerminal;
    }

    public void setFromTerminal(String fromTerminal) {
        this.fromTerminal = fromTerminal;
    }

    public String getPlanArriveTime() {
        return planArriveTime;
    }

    public void setPlanArriveTime(String planArriveTime) {
        this.planArriveTime = planArriveTime;
    }

    public String getPlanTime() {
        return planTime;
    }

    public void setPlanTime(String planTime) {
        this.planTime = planTime;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToAirportCode() {
        return toAirportCode;
    }

    public void setToAirportCode(String toAirportCode) {
        this.toAirportCode = toAirportCode;
    }

    public String getToCityCode() {
        return toCityCode;
    }

    public void setToCityCode(String toCityCode) {
        this.toCityCode = toCityCode;
    }

    public String getToCityName() {
        return toCityName;
    }

    public void setToCityName(String toCityName) {
        this.toCityName = toCityName;
    }

    public String getToTerminal() {
        return toTerminal;
    }

    public void setToTerminal(String toTerminal) {
        this.toTerminal = toTerminal;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "MobFlightEntity{" +
                "airLines='" + airLines + '\'' +
                ", flightNo='" + flightNo + '\'' +
                ", flightRate='" + flightRate + '\'' +
                ", flightTime='" + flightTime + '\'' +
                ", from='" + from + '\'' +
                ", fromAirportCode='" + fromAirportCode + '\'' +
                ", fromCityCode='" + fromCityCode + '\'' +
                ", fromCityName='" + fromCityName + '\'' +
                ", fromTerminal='" + fromTerminal + '\'' +
                ", planArriveTime='" + planArriveTime + '\'' +
                ", planTime='" + planTime + '\'' +
                ", to='" + to + '\'' +
                ", toAirportCode='" + toAirportCode + '\'' +
                ", toCityCode='" + toCityCode + '\'' +
                ", toCityName='" + toCityName + '\'' +
                ", toTerminal='" + toTerminal + '\'' +
                ", week='" + week + '\'' +
                '}';
    }
}
