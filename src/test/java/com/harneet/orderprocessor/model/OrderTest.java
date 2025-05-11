package com.harneet.orderprocessor.model;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test
    void testOrder() {
        Item item = new Item("Product A", 2, 20.0);
        Order order = new Order("1", "John", Collections.singletonList(item), "shipped");

        assertEquals("1", order.getOrderId());
        assertEquals("John", order.getCustomer());
        assertEquals(1, order.getItems().size());
        assertEquals("shipped", order.getStatus());

        order.setOrderId("2");
        order.setCustomer("Jane");
        order.setStatus("pending");

        assertEquals("2", order.getOrderId());
        assertEquals("Jane", order.getCustomer());
        assertEquals("pending", order.getStatus());
    }
}
