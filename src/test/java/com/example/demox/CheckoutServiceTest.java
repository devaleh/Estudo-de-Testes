package com.example.demox;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutServiceTest {

    @Test
    void testMockConstruction() {

        try (MockedConstruction<PaymentProcessor> mocked = mockConstruction(PaymentProcessor.class,
                (mock, context) -> {
                    when(mock.chargeCustomer(anyString(), any(BigDecimal.class))).thenReturn(BigDecimal.TEN);
                })) {

            CheckoutService service = new CheckoutService();
            BigDecimal resultado = service.purchaseProduct("TV", "42");

            assertEquals(BigDecimal.TEN, resultado);
            assertEquals(1, mocked.constructed().size());

        }
    }

}