package com.harneet.orderprocessor.service;

import com.harneet.orderprocessor.model.*;
import com.harneet.orderprocessor.constants.OrderConstants;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class responsible for processing orders and generating summaries.
 */
@Service
public class OrderService {

    /**
     * Processes a list of orders to compute total item count and total cost per order,
     * and generates a summary of shipped orders and total revenue from shipped orders.
     *
     * @param orders the list of orders to be processed
     * @return a CombinedOrderResponse containing individual processed orders and summary statistics
     */
    public CombinedOrderResponse processOrdersAndSummary(List<Order> orders) {
        List<ProcessedOrder> processedOrderList = new ArrayList<>();

        // Calculate item count and total cost for each order
        for (Order order : orders) {
            int itemCount = 0;
            double totalCost = 0.0;

            // Sum quantity and price of each item in the order
            for (Item item : order.getItems()) {
                itemCount += item.getQuantity();
                totalCost += item.getQuantity() * item.getPrice();
            }

            // Create a processed order object with calculated values
            processedOrderList.add(new ProcessedOrder(order, itemCount, totalCost));
        }

        // Initialize counters for summary
        OrderSummaryResponse summary = getOrderSummaryResponse(processedOrderList);
        return new CombinedOrderResponse(processedOrderList, summary);
    }

    private static OrderSummaryResponse getOrderSummaryResponse(List<ProcessedOrder> processedOrderList) {
        long shippedCount = 0;
        double totalRevenue = 0.0;

        // Aggregate data for shipped orders only
        for (ProcessedOrder order : processedOrderList) {
            if (OrderConstants.SHIPPED.equalsIgnoreCase(order.getStatus())) {
                shippedCount++;
                totalRevenue += order.getTotalCost();
            }
        }

        // Create a summary response and return the combined result
        return new OrderSummaryResponse(shippedCount, totalRevenue);
    }
}
