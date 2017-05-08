/**
 *
 */
package com.exer.reserve_manager;

import com.exer.reserve_manager.DBManager.DBManager;
import com.exer.reserve_manager.state.State;

/**
 *  ReserveManager.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public class ReserveManager {

    State state;

    public static void main(String[] args) {

        System.out.println("*** Reserve System Start ***");

        System.out.println("---- init Datebase ----");
            if( !DBManager.init() ) {
                System.out.println(" ERROR: Database init faild.");
                return;
            }
        System.out.println("---- database has already ----");
    }

}
