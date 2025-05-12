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

    @PostMapping("/process")
    public CombinedOrderResponse processOrders(@RequestBody List<Order> orders) {
        return orderService.processOrdersAndSummary(orders);
    }
}

