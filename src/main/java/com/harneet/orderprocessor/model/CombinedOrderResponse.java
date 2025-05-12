package com.harneet.orderprocessor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CombinedOrderResponse {
    private List<ProcessedOrder> orders;
    private OrderSummaryResponse summary;
}

