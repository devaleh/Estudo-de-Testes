package com.example.demo;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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

    @Test
    void testMockingListMultiple() {

        // Mocando uma lista
        List<?> list = mock(List.class);

        // Quando list.size() ser chamado, retornar 10/20/30
        when(list.size()).thenReturn(10).thenReturn(20).thenReturn(30);

        // assert de comparação
        // Primeiro valor mocado
        assertEquals(10, list.size());
        // Segundo valor mocado
        assertEquals(20, list.size());
        // Terceiro valor mocado
        assertEquals(30, list.size());
        // Se repete o ultimo valor mocado ...
        assertEquals(30, list.size());
    }

    @Test
    void testMockingListArgumentsMatcher() {

        // Mocando uma lista
        var list = mock(List.class);

        // Quando acessar qualquer posição de list retornara "Alexandre"
        when(list.get(anyInt())).thenReturn("Alexandre");

        // assert de comparação
        assertEquals("Alexandre", list.get(1));
        assertEquals("Alexandre", list.get(anyInt()));
    }

    @Test
    void testMockingListThrow() {

        // Mocando uma lista
        var list = mock(List.class);

        // Quando acessar qualquer posição de list retornara uma Exception
        when(list.get(anyInt())).thenThrow(new RuntimeException("Exception"));

        // assert
        assertThrows(RuntimeException.class, () -> {
            list.get(anyInt());
        }, "");
    }

    @Test
    void testMockingListBDD() {

        // Mocando uma lista
        var list = mock(List.class);

        // Quando list.size() ser chamado, retornar 10/20/30
        given(list.size()).willReturn(10).willReturn(20).willReturn(30);

        // assert de comparação
        // Primeiro valor mocado
        assertThat(list.size(), is(10));
        // Segundo valor mocado
        assertThat(list.size(), is(20));
        // Terceiro valor mocado
        assertThat(list.size(), is(30));
        // Se repete o ultimo valor mocado ...
        assertThat(list.size(), is(30));
    }
}
