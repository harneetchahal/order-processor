package com.pandell.orderprocessor.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderSummaryResponseTest {

    @Test
    void testOrderSummaryResponse() {
        OrderSummaryResponse summary = new OrderSummaryResponse(5, 500.0);

        assertEquals(5, summary.getTotalShippedOrders());
        assertEquals(500.0, summary.getTotalRevenue());

        summary.setTotalShippedOrders(10);
        summary.setTotalRevenue(1000.0);

        assertEquals(10, summary.getTotalShippedOrders());
        assertEquals(1000.0, summary.getTotalRevenue());
    }
}
