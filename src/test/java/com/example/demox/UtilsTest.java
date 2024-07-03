package com.example.demox;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void getWelcome() {

        try(MockedStatic<Utils> mockedWelcome = mockStatic(Utils.class)) {
            mockedWelcome.when(
                    () -> Utils.getWelcome(eq("Alexandre"),
                            anyBoolean())).thenReturn("Howdy Alexandre");

            String resultado = Utils.getWelcome("Alexandre", false);

            assertEquals("Howdy Alexandre", resultado);
        }
    }
}