package com.example.demo;

import com.example.demo.exceptions.InvalidParamException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculadora")
class CalculadoraTest {

    Calculadora calculadora;

    @BeforeEach
    void instanciarCalculadora() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Testando subtrair da calculadora")
    void subtrair() {

        var resultado = calculadora.subtrair(50, 10);

        assertEquals(40, resultado);
        assertNotEquals(50, resultado);

        assertThrows(InvalidParamException.class, () -> {
            calculadora.subtrair(0, 10);
        });
    }
}