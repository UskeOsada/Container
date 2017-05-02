/**
 *
 */
package com.exercise.salesmanager.model;

import java.util.ArrayList;
import java.util.List;

/**
 *  Item.java
 *
 * @author Y.Osada
 * @version 1.0
 */
public class Item {

    private int id;
    private String name;
    private int price;
    private List<String[]> attributes;

    /**
     * constractor
     * @param id item's id
     * @param name item's name
     * @param price item's price
     */
    public Item(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price =price;

        attributes = new ArrayList<String[]>();
    }

    /**
     * set item's attribute
     * @param name attribute name
     * @param value attribute value
     */
    public void setAttribute( String name, String value ) {

        String[] attr = { name, value };

        attributes.add( attr );
    }

    /**
     * get item's attribute on String.
     * @param num attribute number
     * @return attribute String
     */
    public String getAttribute(int num) {

        if( attributes.isEmpty() ) {
            return "";
        }

        String[] attr = attributes.get( 2 + num );

        return attr[0] + "," + attr[1];
    }

    /**
     * get id
     * @return id
     */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    /* (非 Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String str = id + "," + name + "," + price;

        for( String attr[] : attributes ) {
            str += "," + attr[0] + "," + attr[1];
        }

        return str;
    }

}
