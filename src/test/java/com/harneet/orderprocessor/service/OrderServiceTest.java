package com.harneet.orderprocessor.service;

import com.harneet.orderprocessor.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
    }

    @Test
    void testProcessOrdersAndSummary() {
        // Prepare test data
        Item item1 = new Item("Widget", 2, 10.0);
        Item item2 = new Item("Gadget", 1, 15.0);
        List<Item> items1 = Arrays.asList(item1, item2);

        Item item3 = new Item("Widget", 1, 10.0);
        List<Item> items2 = Arrays.asList(item3);

        Order order1 = new Order("1001", "Alice", items1, "shipped");
        Order order2 = new Order("1002", "Bob", items2, "pending");

        List<Order> orders = Arrays.asList(order1, order2);

        // Call service method
        CombinedOrderResponse response = orderService.processOrdersAndSummary(orders);

        // Assert the orders' details
        assertNotNull(response);
        assertEquals(2, response.getOrders().size());

        // First order (Alice) with item count 3 and total cost 35.0
        assertEquals(3, response.getOrders().get(0).getItemCount());
        assertEquals(35.0, response.getOrders().get(0).getTotalCost());

        // Second order (Bob) with item count 1 and total cost 10.0
        assertEquals(1, response.getOrders().get(1).getItemCount());
        assertEquals(10.0, response.getOrders().get(1).getTotalCost());

        // Assert the summary
        assertEquals(1, response.getSummary().getTotalShippedOrders());
        assertEquals(35.0, response.getSummary().getTotalRevenue());
    }
}
