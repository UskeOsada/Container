/**
 *
 */
package com.exer.reserve_manager.state;

import java.util.Calendar;
import java.util.Date;

import com.exer.reserve_manager.DBManager.DBManager;
import com.exer.reserve_manager.util.DateFormat;

/**
 *  ViewFromDate.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public class ViewFromDate extends Viewer implements State {

    /* (非 Javadoc)
     * @see com.exer.reserve_manager.state.State#view()
     */

    DBManager dbManager = DBManager.getInstance();

    @Override
    public void view() {
        Calendar today = Calendar.getInstance();

        System.out.print( DateFormat.parse( today, DateFormat.YYYYMMDD ) + " " + DateFormat.getDayOfWeek( today ) );

        System.out.println("  |   09  |  10   |  11   |  12   |  13   |  14   |  15   |  16   |  17   |  18   |  19   |");
        System.out.println("   No.room    | 0  30 | 0  30 | 0  30 | 0  30 | 0  30 | 0  30 | 0  30 | 0  30 | 0  30 | 0  30 | 0  30 |");
        System.out.println("--------------+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");

        String[] attr = null;
        int i = 1;
        while( (attr = dbManager.getReserve( i )) != null ) {

//            String str = "";
//
//            str += attr[1] + "," + attr[2];
//            str += "      ";
//
//            str += getReservingTime( attr[4], attr[5] );
//
//            System.out.println( str );
            i++;
        }

        System.out.println("--------------+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
    }

    /* (非 Javadoc)
     * @see com.exer.reserve_manager.state.State#selectReserve()
     */
    @Override
    public Date selectReserve() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    /* (非 Javadoc)
     * @see com.exer.reserve_manager.state.State#reserve()
     */
    @Override
    public boolean reserve() {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

}
