package com.harneet.orderprocessor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderSummaryResponse {
    private long totalShippedOrders;
    private double totalRevenue;
}
