package com.harneet.orderprocessor.service;

import com.harneet.orderprocessor.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final List<ProcessedOrder> processedOrders = new ArrayList<>();

    public CombinedOrderResponse processOrdersAndSummary(List<Order> orders) {
        processedOrders.clear();
        List<ProcessedOrder> processedList = new ArrayList<>();

        for (Order order : orders) {
            int itemCount = 0;
            double totalCost = 0.0;
            for (Item item : order.getItems()) {
                itemCount += item.getQuantity();
                totalCost += item.getQuantity() * item.getPrice();
            }
            processedList.add(new ProcessedOrder(order, itemCount, totalCost));
        }

        processedOrders.addAll(processedList);

        long shippedCount = 0;
        double totalRevenue = 0.0;

        for (ProcessedOrder order : processedList) {
            if ("shipped".equalsIgnoreCase(order.getStatus())) {
                shippedCount++;
                totalRevenue += order.getTotalCost();
            }
        }

        OrderSummaryResponse summary = new OrderSummaryResponse(shippedCount, totalRevenue);
        return new CombinedOrderResponse(processedList, summary);
    }
} 
