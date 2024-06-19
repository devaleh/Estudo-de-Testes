package com.example.demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ListTest {

    @Test
    void testMockingList() {

        // Mocando uma lista
        List<?> list = mock(List.class);

        // Quando list.size() ser chamado, retornar 10
        when(list.size()).thenReturn(10);

        // assert de comparação
        assertEquals(10, list.size());
    }
}
