package com.shu.firstchapter;

/**
 * 租赁类
 * Created by 123 on 2017/3/26.
 */
public class Rental {
    //属性
    private Move _move; //影片类
    private int daysRented;//租赁天数

    private Rental() {
    }

    /**
     * 有参数构造方法
     *
     * @param _move      影片类
     * @param daysRented 租赁天数
     */
    public Rental(Move _move, int daysRented) {
        this._move = _move;
        this.daysRented = daysRented;
    }

    public Move get_move() {
        return _move;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
