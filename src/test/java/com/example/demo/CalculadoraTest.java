package com.example.demo;

import com.example.demo.exceptions.InvalidParamException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    @DisplayName("Testando subtrair da calculadora - Param")
    @ParameterizedTest
    @MethodSource // ("subtrairParam")
    void subtrairParam(double paramUm, double paramDois, double esperado) {

        var resultado = calculadora.subtrair(paramUm, paramDois);

        // Com delta, garantindo 2 casas decimais
        assertEquals(esperado, resultado, 2D);
        assertNotEquals(200, resultado, 2D);
    }

    // Mesmo nome garantindo que vai ser chamado em @MethodSource [subtrairParam]
    public static Stream<Arguments> subtrairParam() {
        return Stream.of(
                Arguments.of(50, 20, 30),
                Arguments.of(100, 50, 50),
                Arguments.of(10, 10, 0),
                Arguments.of(100.5, 50.25, 50.25)
        );
    }

    @DisplayName("Testando subtrair da calculadora - Csv")
    @ParameterizedTest
    @CsvSource({
            "50, 20, 30",
            "100, 50, 50",
            "10, 10, 0",
            "100.5, 50.25, 50.25"
    })
    void subtrairCsv(double paramUm, double paramDois, double esperado) {

        var resultado = calculadora.subtrair(paramUm, paramDois);

        // Com delta, garantindo 2 casas decimais
        assertEquals(esperado, resultado, 2D);
        assertNotEquals(200, resultado, 2D);
    }

    @DisplayName("Testando subtrair da calculadora - Csv File")
    @ParameterizedTest
    @CsvFileSource(resources = "/testSubtrair.csv")
    void subtrairCsvFile(double paramUm, double paramDois, double esperado) {

        var resultado = calculadora.subtrair(paramUm, paramDois);

        // Com delta, garantindo 2 casas decimais
        assertEquals(esperado, resultado, 2D);
        assertNotEquals(200, resultado, 2D);
    }
}