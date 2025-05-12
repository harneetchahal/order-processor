package com.harneet.orderprocessor.constants;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class OrderConstantsTest {

    @Test
    void testShippedConstant() {
        assertEquals("shipped", OrderConstants.SHIPPED);
    }

    @Test
    void testPrivateConstructor() throws Exception {
        Constructor<OrderConstants> constructor = OrderConstants.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertInstanceOf(IllegalStateException.class, exception.getCause());
        assertEquals("Utility class", exception.getCause().getMessage());
    }
}
