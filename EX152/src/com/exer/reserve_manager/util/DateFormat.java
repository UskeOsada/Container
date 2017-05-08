/**
 *
 */
package com.exer.reserve_manager.util;

import java.util.Calendar;

/**
 * @author Y.Osada
 * @version 1.0
 */
public final class DateFormat {

    private static final String yyyymmdd = "%s/%s/%s";
    private static final String yymmdd  = "%s/%s/%s";
    private static final String hhmm = "%s:%s";

    public static final String YYYYMMDD = "yyyymmdd";
    public static final String YYMMDD = "yymmdd";
    public static final String HHMM = "hhmm";

    public static final String[] day = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

    public static String parse( String date, String mode ) {

        String[] attr;

        switch ( mode ) {
            case YYYYMMDD:
                if( date.length() != 8 ) {
                    System.out.println("ERROR[DateFormat]: invalid date");
                    break;
                }

                attr = new String[3];
                attr[0] = date.substring(0, 4);
                attr[1] = date.substring(4, 6);
                attr[2] = date.substring(6, 8);

                return String.format( yyyymmdd, attr[0], attr[1], attr[2]);

            case YYMMDD:
                if( date.length() != 6 ) {
                    System.out.println("ERROR[DateFormat]: invalid date");
                    break;
                }

                attr = new String[3];
                attr[0] = date.substring(0, 2);
                attr[1] = date.substring(2, 4);
                attr[2] = date.substring(4, 6);

                return String.format( yymmdd, attr[0], attr[1], attr[2]);

            case HHMM:
                if( date.length() != 4 ) {
                    System.out.println("ERROR[DateFormat]: invalid date");
                    break;
                }

                attr = new String[2];
                attr[0] = date.substring(0, 2);
                attr[1] = date.substring(2, 4);

                return String.format( hhmm, attr[0], attr[1]);

            default:
                return null;
        }

        return null;

    }

    public static String parse( Calendar date, String mode ) {

        String[] attr;

        switch ( mode ) {
            case YYYYMMDD:

                attr = new String[3];
                attr[0] = String.valueOf( date.get(Calendar.YEAR) );
                attr[1] = String.valueOf( date.get( Calendar.MONTH) );
                attr[2] = String.valueOf( date.get( Calendar.DATE) );

                return String.format( yyyymmdd, attr[0], attr[1], attr[2]);

            case YYMMDD:

                attr = new String[3];
                attr[0] = String.valueOf( date.get(Calendar.YEAR) ).substring(2);
                attr[1] = String.valueOf( date.get( Calendar.MONTH) );
                attr[2] = String.valueOf( date.get( Calendar.DATE) );

                return String.format( yymmdd, attr[0], attr[1], attr[2]);

            case HHMM:

                attr = new String[2];
                attr[0] = String.valueOf( date.get( Calendar.HOUR_OF_DAY ) );
                attr[1] = String.valueOf( date.get( Calendar.MINUTE ) );

                return String.format( hhmm, attr[0], attr[1]);

            default:
                return null;
        }

    }

    public static String getDayOfWeek( Calendar date) {
        int dow = date.get( Calendar.DAY_OF_WEEK );

        return day[ dow - 1 ];
    }

}
