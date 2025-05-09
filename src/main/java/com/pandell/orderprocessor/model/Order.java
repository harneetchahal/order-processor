package com.pandell.orderprocessor.model;

import java.util.List;

public class Order {
    private String orderId;
    private String customer;
    private List<Item> items;
    private String status;

    // Constructor that accepts orderId, customer, items, and status
    public Order(String orderId, String customer, List<Item> items, String status) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.status = status;
    }

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getCustomer() { return customer; }
    public void setCustomer(String customer) { this.customer = customer; }
    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
