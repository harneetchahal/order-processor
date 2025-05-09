package com.pandell.orderprocessor.model;

public class OrderSummaryResponse {
    private long totalShippedOrders;
    private double totalRevenue;

    public OrderSummaryResponse(long totalShippedOrders, double totalRevenue) {
        this.totalShippedOrders = totalShippedOrders;
        this.totalRevenue = totalRevenue;
    }

    public long getTotalShippedOrders() { return totalShippedOrders; }
    public void setTotalShippedOrders(long totalShippedOrders) { this.totalShippedOrders = totalShippedOrders; }
    public double getTotalRevenue() { return totalRevenue; }
    public void setTotalRevenue(double totalRevenue) { this.totalRevenue = totalRevenue; }
}
