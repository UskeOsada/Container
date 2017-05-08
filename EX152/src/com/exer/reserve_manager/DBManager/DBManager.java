/**
 *
 */
package com.exer.reserve_manager.DBManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  DBManager.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public final class DBManager {

    private static BufferedReader reserve;
    private static BufferedReader employee;
    private static BufferedReader room;

    private static DBManager singleton = new DBManager();

    public static DBManager getInstance() {
        return singleton;
    }

    private DBManager() {
        init();
    }

    public static String[] getReserve( String id ) {

        if( !init() ) {
            System.err.println( "ERROR : DB error");
            return null;
        }

        String[] attr = null;

        try {
            do{
                String line = reserve.readLine();

                if( line == null ) {
                    return null;
                }

                attr = line.split(",");

            }while( !id.equals( attr[0] ) );

        } catch( IOException e) {
            e.printStackTrace();
        }

        return attr;
    }

    public static String[] getReserve( int id ) {
        return getReserve( String.valueOf( id ) );
    }

    public static boolean findEmployee( String id ) {

        if( !init() ) {
            System.err.println( "ERROR : DB error");
            return false;
        }

        try {
            String emp = "";
            while( !id.equals( emp )) {
                emp = employee.readLine();

                if( emp == null ) {
                    return false;
                }
            }
        } catch( IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean findEmployee( int id ) {
        return findEmployee( String.valueOf( id ) );
    }

    public static String[] getRoomInfo( String id ) {

        if( !init() ) {
            System.err.println( "ERROR : DB error");
            return null;
        }

        String[] attr = null;

        try {
            do{
                String line = room.readLine();

                if( line == null ) {
                    return null;
                }

                attr = line.split(",");

            }while( !id.equals( attr[0] ) );

        } catch( IOException e) {
            e.printStackTrace();
            return null;
        }

        return attr;
    }

    public static String[] getRoomInfo( int id ) {
        return getRoomInfo( String.valueOf( id ) );
    }

    public static boolean init() {

        if( reserve != null && employee != null ) return true;

        try {
            reserve = new BufferedReader( new InputStreamReader (new FileInputStream("reserve.csv"), "SHIFT-JIS" ) );
            employee = new BufferedReader( new InputStreamReader (new FileInputStream("employee.csv"), "SHIFT-JIS" ) );
            room = new BufferedReader( new InputStreamReader (new FileInputStream("room.csv"), "SHIFT-JIS" ) );
        } catch (Exception e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
