package com.harneet.orderprocessor.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harneet.orderprocessor.model.*;
import com.harneet.orderprocessor.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Autowired
    private ObjectMapper objectMapper;
    private List<Order> orders;

    @BeforeEach
    void setUp() {
        try (AutoCloseable ignored = MockitoAnnotations.openMocks(this)) {
            this.orders = loadOrdersFromFile();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize mocks", e);
        }
    }

    @Test
    void testProcessOrders() throws Exception {
        // Construct expected response
        CombinedOrderResponse expectedResponse = getCombinedOrderResponse();

        // Mock service response
        when(orderService.processOrdersAndSummary(Mockito.anyList())).thenReturn(expectedResponse);

        // Perform the test
        mockMvc.perform(post("/api/orders/process")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orders)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.orders.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.orders[0].orderId").value("1001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.orders[0].totalCost").value(35.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.orders[0].itemCount").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.orders[1].orderId").value("1002"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.orders[1].totalCost").value(10.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.orders[1].itemCount").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.summary.totalShippedOrders").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.summary.totalRevenue").value(35.0));
    }

    private static CombinedOrderResponse getCombinedOrderResponse() {
        ProcessedOrder processedOrder1 = new ProcessedOrder(
                new Order("1001", "Alice", Arrays.asList(
                        new Item("Widget", 2, 10.0),
                        new Item("Gadget", 1, 15.0)
                ), "shipped"), 3, 35.0
        );

        ProcessedOrder processedOrder2 = new ProcessedOrder(
                new Order("1002", "Bob", Arrays.asList(
                        new Item("Widget", 1, 10.0)
                ), "pending"), 1, 10.0
        );

        return new CombinedOrderResponse(
                Arrays.asList(processedOrder1, processedOrder2),
                new OrderSummaryResponse(1, 35.0)
        );
    }

    private List<Order> loadOrdersFromFile() throws IOException {
        String filePath = "order.json";
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(filePath)).getFile());
        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Order.class));
    }
}
