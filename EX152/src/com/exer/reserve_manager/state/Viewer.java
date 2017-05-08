/**
 *
 */
package com.exer.reserve_manager.state;

import java.util.Calendar;

/**
 *  Viewer.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public abstract class Viewer {

    final String getReservingTime( String startTime, String endTime) {
        String str = "|";

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        Calendar timer = Calendar.getInstance();
        Calendar last = Calendar.getInstance();

        start.set(Calendar.HOUR_OF_DAY, Integer.parseInt( startTime.substring( 0,2 ) ) );
        start.set(Calendar.MINUTE, Integer.parseInt( startTime.substring( 3, 5 ) ) );

        end.set(Calendar.HOUR_OF_DAY, Integer.parseInt( endTime.substring( 0,2 ) ) );
        end.set(Calendar.MINUTE, Integer.parseInt( endTime.substring( 3, 5 ) ) );

        timer.set(Calendar.HOUR_OF_DAY, Integer.parseInt( "9" ) );
        timer.set(Calendar.MINUTE, Integer.parseInt( "0" ) );

        while( timer.get( Calendar.HOUR_OF_DAY) <= 19 ) {

            if( !timer.before( start ) && !timer.after( end ) ) {
                str += " o |";
            } else {
                str += " x |";
            }

            timer.add( Calendar.MINUTE , 30 );
        }

        return str;
    }

}
