package com.harneet.orderprocessor.controller;

import com.harneet.orderprocessor.model.CombinedOrderResponse;
import com.harneet.orderprocessor.model.Order;
import com.harneet.orderprocessor.service.OrderService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    // Constructor injection for OrderService
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Processes a list of customer orders and returns both individual order summaries
     * and a combined summary including total shipped orders and total revenue.
     *
     * @param orders the list of orders to be processed, received in the request body as JSON
     * @return a {@link CombinedOrderResponse} object containing processed order details and summary
     */
    @PostMapping("/process")
    public CombinedOrderResponse processOrders(@RequestBody List<Order> orders) {
        return orderService.processOrdersAndSummary(orders);
    }
}

