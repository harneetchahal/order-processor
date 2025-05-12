package com.harneet.orderprocessor.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProcessedOrder extends Order {
    private int itemCount;
    private double totalCost;

    // Constructor to initialize ProcessedOrder using Order details
    public ProcessedOrder(Order order, int itemCount, double totalCost) {
        super(order.getOrderId(), order.getCustomer(), order.getItems(), order.getStatus());
        this.itemCount = itemCount;
        this.totalCost = totalCost;
    }

}
