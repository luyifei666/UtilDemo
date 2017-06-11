package com.billylu.android.utildemo.bean.mob;

/**
 * Created by maning on 2017/5/8.
 */

public class MobPhoneAddressEntity {


    /**
     * city : 南宁市
     * cityCode : 0771
     * mobileNumber : 1330000
     * operator : 电信CDMA卡
     * province : 广西
     * zipCode : 530000
     */

    private String city;
    private String cityCode;
    private String mobileNumber;
    private String operator;
    private String province;
    private String zipCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "MobPhoneAddressEntity{" +
                "city='" + city + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", operator='" + operator + '\'' +
                ", province='" + province + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
