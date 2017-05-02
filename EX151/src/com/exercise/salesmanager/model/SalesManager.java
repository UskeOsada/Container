/**
 *
 */
package com.exercise.salesmanager.model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  SalesManager.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public class SalesManager {

    private static Scanner scan;
    private static ArrayList<Receipt> receiptList;
    private static String cmd;

    public static void main(String[] args) {

        boolean quit_flg = false;
        init();

        System.out.println("**** レジ管理システム ***");

        while( !quit_flg ) {
            System.out.println("[MENU] 1.新規注文  2.注文履歴  q.終了");
            System.out.print("処理番号 > ");
            cmd = scan.nextLine();

            switch( cmd.charAt( 0 ) ) {
                case '1':
                    createNewReceipt();
                    break;
                case '2':
                    break;
                case 'q':
                    quit_flg = true;
                    break;
                default:
            }
        }

    }

    public static void createNewReceipt() {

        boolean exit_flg = false;

        Receipt receipt = new Receipt();

        System.out.println("[1.新規注文] 商品と数量を指定してください");

        while( !exit_flg ) {
            System.out.print("商品ID(qで終了) > ");
            cmd = scan.nextLine();

            if( cmd.charAt( 0 ) == 'q' ) {
                exit_flg = true;
            } else {
                int itemId = Integer.parseInt( cmd );

                System.out.print("個数 > ");
                cmd = scan.nextLine();

                int count = 0;
                if( cmd.equals("") ) {
                    count = 1;
                } else {
                    count = Integer.parseInt( cmd );
                }

                receipt.addOrder( itemId, count );
            }

            System.out.println("[買い物かご]");
            receipt.printCart();
        }

        System.out.print("預かり金額 > ");
        cmd = scan.nextLine();

        int pay = Integer.parseInt( cmd );
        receipt.setPay( pay );
        System.out.println( "おつり:" + receipt.getReturn() );

        receipt.getFormatReceipt();

        System.out.print("修正しますか？ (y/n) > ");
        cmd = scan.nextLine();

    }

    public static void addItem(int receiptId, int orderId) {

    }

    public static void removeItem(int receiptId, int orderId) {

    }

    public static void changeItem(int receiptId, int orderId, int itemId, int count) {

    }

    public static void changeItem(int receiptId, int orderid, int count) {

    }

    public static int pay(int receiptId, int payment) {
        return 0;
    }

    public static void init() {

        scan = new Scanner( System.in );
        receiptList = new ArrayList<Receipt>();

    }



}
