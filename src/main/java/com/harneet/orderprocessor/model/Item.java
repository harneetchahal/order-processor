package com.harneet.orderprocessor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private String product;
    private int quantity;
    private double price;
}
