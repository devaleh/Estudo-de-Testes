package com.example.demo;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HamcrestMatchesTest {

    @Test
    void testHamcrestMatches() {

        // Criando uma lista de inteiros
        List<Integer> scores = Arrays.asList(100, 200, 300, 400);

        // Verificar se o tamanho da lista e igual a 4
        assertThat(scores, hasSize(4));

        // Verificar se contem Items na lista
        assertThat(scores, hasItems(100, 300));

        // Verificar se todos items da lista sao maior que 99
        assertThat(scores, everyItem(greaterThan(99)));

        // Verificar se todos items da lista sao menor que 401
        assertThat(scores, everyItem(lessThan(401)));

        // Verificar se String esta vazia
        assertThat("", is(emptyString()));

        // Verificar se String e igual a null
        assertThat(null, is(emptyOrNullString()));

        // Criando array de inteiros
        Integer[] myArray = {1, 2, 3, 4};

        // Verificar se tamanho do array e igual a 4
        assertThat(myArray, arrayWithSize(4));

        // verificar se array e igual
        assertThat(myArray, arrayContaining(1, 2, 3, 4));

        // Verificar se array e igual, mesmo fora de ordem
        assertThat(myArray, arrayContainingInAnyOrder(3, 1, 4, 2));
    }
}
