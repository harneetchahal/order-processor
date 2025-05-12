package com.harneet.orderprocessor.constants;

public class OrderConstants {

    //added for fixing sonar issue java:S1118
    private OrderConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String SHIPPED = "shipped";
}
