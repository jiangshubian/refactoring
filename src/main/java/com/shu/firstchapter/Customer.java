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
        double totalAmount = 0; //总价格
        int frequentRenterPonits = 0;//总积分

        Enumeration rentals = _rentals.elements();

        String result = "Rental Record for " + getName() + "\n";//打印结果内容

        while (rentals.hasMoreElements()) {//遍历顾客购买影片清单
            double thisAmount = 0;
            int thisScore = 0;
            Rental each = (Rental) rentals.nextElement();

            //check move type for each
            switch (each.get_move().get_priceCode()) {
                case Move.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
                case Move.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Move.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
            }
            //add frenquent renter points
            frequentRenterPonits++;

            //add bonusfor a tow day new release rental
            if ((each.get_move().get_priceCode() == Move.NEW_RELEASE) && each.getDaysRented() >= 2) {
                frequentRenterPonits++;
            }

            //show figures for this rental
            result += "\t" + each.get_move().get_title() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;

        }
        //show figures for this rental
        result += "Amount ownd is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPonits) + " frequent renter ponits.";
        return result;
    }
}
