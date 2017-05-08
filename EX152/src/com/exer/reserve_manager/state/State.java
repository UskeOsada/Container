/**
 *
 */
package com.exer.reserve_manager.state;

import java.util.Date;

/**
 *  State.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public interface State {

    void view();

    Date selectReserve();

    boolean reserve();

}
