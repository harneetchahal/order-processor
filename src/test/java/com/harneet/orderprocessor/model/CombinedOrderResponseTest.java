package com.harneet.orderprocessor.model;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinedOrderResponseTest {

    @Test
    void testCombinedOrderResponse() {
        ProcessedOrder processedOrder = new ProcessedOrder(new Order("1", "John", Collections.emptyList(), "shipped"), 1, 100.0);
        OrderSummaryResponse summary = new OrderSummaryResponse(1, 100.0);

        CombinedOrderResponse response = new CombinedOrderResponse(Collections.singletonList(processedOrder), summary);

        assertEquals(1, response.getOrders().size());
        assertEquals(100.0, response.getSummary().getTotalRevenue());
    }
}

