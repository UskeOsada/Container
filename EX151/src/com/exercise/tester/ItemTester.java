package com.exercise.tester;

import com.exercise.salesmanager.model.Item;

public class ItemTester {

    public static void main(String[] args) {

        Item item = new Item( 1, "testItem1", 100 );

        item.setAttribute( "attr1", "value1");
        item.setAttribute( "attr2", "value2");
        item.setAttribute( "attr3", "value3");

        Item item2 = new Item(2,"testItem2", 50);

        System.out.println(item);

        System.out.println(item2);

    }

}
