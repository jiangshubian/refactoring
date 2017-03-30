package com.shu.firstchaptertest;

import com.shu.firstchapter.Customer;
import com.shu.firstchapter.Move;
import com.shu.firstchapter.Rental;
import org.junit.Test;

/**
 * Created by 123 on 2017/3/26.
 */
public class CustomerTest {

    @Test
    public void statemetTest() {
        Customer customer = new Customer("shu");

        Move move1 = new Move("abc", 1);
        Rental rental_1 = new Rental(move1, 4);

        Move move2 = new Move("亚麻跌", 0);
        Rental rental_2 = new Rental(move2, 4);

        customer.addRental(rental_1);
        customer.addRental(rental_2);

        System.out.println(customer.statement());

    }

}
