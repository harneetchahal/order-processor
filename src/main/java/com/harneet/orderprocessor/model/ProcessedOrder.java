package com.harneet.orderprocessor.model;

public class ProcessedOrder extends Order {
    private int itemCount;
    private double totalCost;


    // Constructor to initialize ProcessedOrder using Order details
    public ProcessedOrder(Order order, int itemCount, double totalCost) {
        super(order.getOrderId(), order.getCustomer(), order.getItems(), order.getStatus());
        this.itemCount = itemCount;
        this.totalCost = totalCost;
    }

    public int getItemCount() { return itemCount; }
    public void setItemCount(int itemCount) { this.itemCount = itemCount; }
    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
}
