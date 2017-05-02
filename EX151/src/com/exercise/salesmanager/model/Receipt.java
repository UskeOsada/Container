/**
 *
 */
package com.exercise.salesmanager.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  Receipt.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public class Receipt {

    private Date date;
    private int pay;
    private List<Order> orderList;

    public Receipt() {
        date = new Date();
        pay = 0;
        orderList = new ArrayList<Order>();
    }

    public int getTotalCharge() {
        int charge = 0;

        for( Order order : orderList ) {
            charge += order.getSum();
        }

        return charge;
    }

    public void addOrder(int itemId, int count) {
        Order order = new Order(itemId, count);

        if( order != null ) {
            orderList.add( order );
        }
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getReturn() {

        return pay - getTotalCharge() ;
    }

    public void removeOrder(int orderId) {

        try {
            orderList.remove( orderId );
        } catch( IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public void getFormatReceipt() {
        System.out.println("--------------------------------------------------------");

        System.out.println("注文日   : " + date );
        System.out.println("品数     : " + orderList.size() );
        System.out.println("合計     : " + getTotalCharge() );
        System.out.println("お預かり : " + pay );
        System.out.println("お釣り   : " + getReturn() );
        System.out.println("");

        for( int i=0; i < orderList.size(); i++) {
            System.out.println( i+1 + ". " + orderList.get( i ));
        }

        System.out.println("--------------------------------------------------------");

    }

    public void printCart() {
        System.out.println("--------------------------------------------------------");
        for( int i=0; i < orderList.size(); i++) {
            System.out.println( i+1 + ". " + orderList.get( i ));
        }
        System.out.println("--------------------------------------------------------");
    }


}
