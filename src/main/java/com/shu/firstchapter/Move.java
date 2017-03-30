package com.shu.firstchapter;

import java.io.Serializable;

/**
 * 影片基类
 * Created by 123 on 2017/3/26.
 */
public class Move implements Serializable {
    //静态属性
    public static final int CHILDRENS = 2; //儿童片类型
    public static final int REGULAR = 0; //普通片类型
    public static final int NEW_RELEASE = 1;//新发行片类型

    //属性
    private String _title;
    private int _priceCode;

    /**
     * 无参数构造方法
     */
    private Move() {
    }

    /**
     * 有参数构造方法
     *
     * @param _title     影片类型
     * @param _priceCode 影片价格
     */
    public Move(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }


    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public int get_priceCode() {
        return _priceCode;
    }

    public void set_priceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

    /**
     * 租金
     * @param daysRented 租天数
     * @return
     */
    public double getCharge(int daysRented) {
        double thisAmount = 0;
        switch (get_priceCode()) {
            case Move.CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3) {
                    thisAmount += (daysRented - 3) * 1.5;
                }
                break;
            case Move.REGULAR:
                thisAmount += 2;
                if (daysRented > 2) {
                    thisAmount += (daysRented- 2) * 1.5;
                }
                break;
            case Move.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
        }
        return thisAmount;
    }

    /**
     * 积分
     * @return
     */
    public int getFrequentRenterPonits(int daysRented) {
        if ((get_priceCode() == Move.NEW_RELEASE)
                && daysRented >= 1) {
            return 2;
        }
        return 1;
    }
}
