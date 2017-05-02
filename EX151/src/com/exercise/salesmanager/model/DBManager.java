/**
 *
 */
package com.exercise.salesmanager.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  DBManager.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public class DBManager {

    private static File file;
    private static BufferedReader scan;

    public static Item findItem(int itemId) {

        if( scan == null ) {
            if( !init() ) {
                System.out.println("ERROR: scanner is broeken!");
                return null;
            }
        }

        String itemRow = "";

        try {
            for(int i=0; i<itemId; i++) {
                itemRow = scan.readLine();

                if( itemRow == null ) {
                    System.out.println("ERROR: item not found");
                    return null;
                }
            }
        } catch( IOException e) {
            e.printStackTrace();
        }

        String[] attr = itemRow.split(",");

        Item item = new Item( Integer.parseInt( attr[0]), attr[1], Integer.parseInt( attr[2] ) );

        for( int i=3; i < attr.length; i+=2 ) {

            item.setAttribute( attr[ i ], attr[ i+1 ] );
        }

        return item;
    }

    private static boolean init() {
        try {
            scan = new BufferedReader( new InputStreamReader (new FileInputStream("itemList.csv"), "SHIFT-JIS" ) );
        } catch (Exception e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        return true;
    }
}