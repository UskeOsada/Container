package com.exercise.tester;

import com.exercise.salesmanager.model.Order;

public class OrderTester {

    public static void main(String[] args) {

        Order order1 = new Order(1,10);

        System.out.println( order1);
        System.out.println(order1.getSum());

        Order order2 = new Order( 999, 999);

        System.out.println(order2);
        System.out.println(order2.getSum());

    }

}
