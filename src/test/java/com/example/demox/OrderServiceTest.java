package com.example.demox;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUUID = UUID.fromString("c370d474-eb44-42dd-926b-71c6f8f132a1");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2024, 3, 7, 15, 30);

    @Test
    void testCreateOrderUUID() {

        try(MockedStatic<UUID> mockedUUID = mockStatic(UUID.class)) {
            mockedUUID.when(UUID::randomUUID).thenReturn(defaultUUID);

            Order resultado = service.createOrder("Mack", 2L, null);

            assertEquals(defaultUUID.toString(), resultado.getId());
        }
    }

    @Test
    void testCreateOrderLocalDateTime() {

        try(MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {
            mockedLocalDateTime.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            Order resultado = service.createOrder("Mack", 2L, null);

            assertEquals(defaultLocalDateTime, resultado.getCreationDate());
        }
    }
}