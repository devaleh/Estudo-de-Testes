package com.example.demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ListTest {

    @Test
    void testMockingList() {

        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10);

        assertEquals(10, list.size());
    }
}
