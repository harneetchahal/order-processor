package com.harneet.orderprocessor.service;

import com.harneet.orderprocessor.model.*;
import com.harneet.orderprocessor.constants.OrderConstants;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    public CombinedOrderResponse processOrdersAndSummary(List<Order> orders) {
        List<ProcessedOrder> processedOrderList = new ArrayList<>();

        for (Order order : orders) {
            int itemCount = 0;
            double totalCost = 0.0;
            for (Item item : order.getItems()) {
                itemCount += item.getQuantity();
                totalCost += item.getQuantity() * item.getPrice();
            }
            processedOrderList.add(new ProcessedOrder(order, itemCount, totalCost));
        }

        long shippedCount = 0;
        double totalRevenue = 0.0;

        for (ProcessedOrder order : processedOrderList) {
            if (OrderConstants.SHIPPED.equalsIgnoreCase(order.getStatus())) {
                shippedCount++;
                totalRevenue += order.getTotalCost();
            }
        }

        OrderSummaryResponse summary = new OrderSummaryResponse(shippedCount, totalRevenue);
        return new CombinedOrderResponse(processedOrderList, summary);
    }
} 
