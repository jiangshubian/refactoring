package com.shu.firstchapter;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客类
 * Created by 123 on 2017/3/26.
 */
public class Customer {

    //属性
    private String name; //顾客名称
    private Vector _rentals = new Vector(); //包含所以租赁

    public Customer(String name) {
        this.name = name;
    }

    /**
     * 该客户租借的影片
     *
     * @param _rental
     */
    public void addRental(Rental _rental) {
        _rentals.addElement(_rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";//打印结果内容

        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {//遍历顾客购买影片清单
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.get_move().get_title() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        //show figures for this rental
        result += "Amount ownd is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPonits()) + " frequent renter ponits.";
        return result;
    }

    private int getFrequentRenterPonits() {
        int frequentRenterPonits = 0;//总积分

        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {//遍历顾客购买影片清单
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPonits += each.getFrequentRenterPonits();//积分项
        }

        return frequentRenterPonits;
    }

    private double getTotalAmount() {
        double totalAmount = 0; //总价格

        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {//遍历顾客购买影片清单
            Rental each = (Rental) rentals.nextElement();
            totalAmount += each.getCharge();
        }

        return totalAmount;
    }


}
