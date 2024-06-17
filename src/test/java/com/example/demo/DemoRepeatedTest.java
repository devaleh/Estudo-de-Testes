package com.example.demo;

import com.example.demo.exceptions.InvalidParamException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DemoRepeatedTest {

    Calculadora calculadora;

    @BeforeEach
    void instanciarCalculadora() {
        calculadora = new Calculadora();
    }

    @RepeatedTest(2)
    void subtrair() {

        var resultado = calculadora.subtrair(50, 10);

        assertEquals(40, resultado);
        assertNotEquals(50, resultado);

        assertThrows(InvalidParamException.class, () -> {
            calculadora.subtrair(0, 10);
        });
    }

    //@RepeatedTest(2)
    @RepeatedTest(value = 2, name = "{displayName}. Repetition "
            + "{currentRepetition} of {totalRepetitions}")
    @DisplayName("TESTE")
    void subtrairInfo(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo
    ) {

        System.out.println(repetitionInfo);
        System.out.println(repetitionInfo.getCurrentRepetition() + " / " + repetitionInfo.getTotalRepetitions());

        System.out.println(testInfo);

        var resultado = calculadora.subtrair(50, 10);

        assertEquals(40, resultado);
        assertNotEquals(50, resultado);

        assertThrows(InvalidParamException.class, () -> {
            calculadora.subtrair(0, 10);
        });
    }
}
