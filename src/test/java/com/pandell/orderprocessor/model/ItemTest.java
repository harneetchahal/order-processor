package com.pandell.orderprocessor.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @Test
    void testItem() {
        Item item = new Item("Product A", 2, 20.0);

        assertEquals("Product A", item.getProduct());
        assertEquals(2, item.getQuantity());
        assertEquals(20.0, item.getPrice());

        item.setProduct("Product B");
        item.setQuantity(3);
        item.setPrice(25.0);

        assertEquals("Product B", item.getProduct());
        assertEquals(3, item.getQuantity());
        assertEquals(25.0, item.getPrice());
    }
}
