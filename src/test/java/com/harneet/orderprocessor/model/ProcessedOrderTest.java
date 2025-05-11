package com.harneet.orderprocessor.model;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessedOrderTest {

    @Test
    void testProcessedOrder() {
        Item item = new Item("Product A", 2, 20.0);
        Order order = new Order("1", "John", Collections.singletonList(item), "shipped");

        ProcessedOrder processedOrder = new ProcessedOrder(order, 2, 40.0);

        assertEquals(2, processedOrder.getItemCount());
        assertEquals(40.0, processedOrder.getTotalCost());
    }
}
