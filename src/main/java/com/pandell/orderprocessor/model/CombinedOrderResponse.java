package com.pandell.orderprocessor.model;

import java.util.List;

public class CombinedOrderResponse {
    private List<ProcessedOrder> orders;
    private OrderSummaryResponse summary;

    // Constructor
    public CombinedOrderResponse(List<ProcessedOrder> orders, OrderSummaryResponse summary) {
        this.orders = orders;
        this.summary = summary;
    }

    // Getters and Setters
    public List<ProcessedOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ProcessedOrder> orders) {
        this.orders = orders;
    }

    public OrderSummaryResponse getSummary() {
        return summary;
    }

    public void setSummary(OrderSummaryResponse summary) {
        this.summary = summary;
    }
}

