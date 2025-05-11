package com.harneet.orderprocessor.controller;

import com.harneet.orderprocessor.model.CombinedOrderResponse;
import com.harneet.orderprocessor.model.Order;
import com.harneet.orderprocessor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/process")
    public CombinedOrderResponse processOrders(@RequestBody List<Order> orders) {
        return orderService.processOrdersAndSummary(orders);
    }
}

