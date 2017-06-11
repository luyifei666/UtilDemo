package com.billylu.android.utildemo.bean.mob;

/**
 * Created by maning on 2017/5/11.
 */

public class MobBankCard {


    /**
     * bank : 农业银行
     * bin : 622848
     * binNumber : 6
     * cardName : 金穗通宝卡(银联卡)
     * cardNumber : 19
     * cardType : 借记卡
     */

    private String bank;
    private String bin;
    private int binNumber;
    private String cardName;
    private int cardNumber;
    private String cardType;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public int getBinNumber() {
        return binNumber;
    }

    public void setBinNumber(int binNumber) {
        this.binNumber = binNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
