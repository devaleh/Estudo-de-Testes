package com.example.demox;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUUID = UUID.fromString("c370d474-eb44-42dd-926b-71c6f8f132a1");

    @Test
    void createOrder() {

        try(MockedStatic<UUID> mockedUUID = mockStatic(UUID.class)) {
            mockedUUID.when(UUID::randomUUID).thenReturn(defaultUUID);

            Order resultado = service.createOrder("Mack", 2L, null);

            assertEquals(defaultUUID.toString(), resultado.getId());
        }
    }
}