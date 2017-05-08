/**
 *
 */
package com.exer.reserve_manager.tester;

import com.exer.reserve_manager.DBManager.DBManager;

/**
 *  DBManagerTester.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public class DBManagerTester {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String[] reserve = DBManager.getReserve( "3" );

        for( String data : reserve ) {
            System.out.print(data + ",");
        }

        System.out.println("");

        if( DBManager.findEmployee( "1001" ) ) {
            System.out.println("find");
        } else {
            System.out.println("notFound");
        }

        if( DBManager.findEmployee( "1002" ) ) {
            System.out.println("find");
        } else {
            System.out.println("notFound");
        }

    }

}
