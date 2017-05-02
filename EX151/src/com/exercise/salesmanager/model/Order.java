/**
 *
 */
package com.exercise.salesmanager.model;

/**
 *  Order.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public class Order {

    private Item item;
    private int count;

    public Order(int itemId, int count) {

        item = DBManager.findItem( itemId );
        this.count = count;
    }

    public int getSum() {
        if( item == null ) return 0;

        return item.getPrice() * count;
    }

    /* (非 Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return item + ",数量:" + count + ",金額:" + getSum();
    }

}
