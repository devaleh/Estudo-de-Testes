package com.example.demo;

import org.junit.jupiter.api.*;

//(TestInstance.Lifecycle.PER_CLASS)
//@Order(1)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoOrderedTest {

    StringBuilder atual = new StringBuilder();

    @AfterEach
    void after() {
        System.out.println("Valor " + atual);
    }

    @Test
    @Order(3)
    void testA() {
        System.out.println("TESTE A");
        atual.append("1");
    }

    @Test
    @Order(1)
    void testB() {
        System.out.println("TESTE B");
        atual.append("2");
    }

    @Test
    @Order(2)
    void testC() {
        System.out.println("TESTE C");
        atual.append("3");
    }
}
