/**
 *
 */
package com.exer.reserve_manager.state;

import java.util.Date;

import com.exer.reserve_manager.DBManager.DBManager;

/**
 *  IvewOfConference.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public class ViewOfConference implements State {

    /* (非 Javadoc)
     * @see com.exer.reserve_manager.state.State#view()
     */
    @Override
    public void view() {

        String[] attr;
        int i = 1;

        System.out.println("--------------------------------");
        attr = DBManager.getRoomInfo( String.valueOf( i ) );
        while( attr != null ) {
            System.out.println(
                    String.format("会議室No:%s, %s (定員:%s名)", attr[0],attr[1],attr[2])
                    );
            i++;
            attr = DBManager.getRoomInfo( String.valueOf( i ) );
        }

        System.out.println("--------------------------------");

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
