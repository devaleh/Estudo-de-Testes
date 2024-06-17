package com.example.demo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Order(1)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DemoOrderedTest {

    @Test
    @Order(3)
    void testA() {
        System.out.println("TESTE A");
    }

    @Test
    @Order(1)
    void testB() {
        System.out.println("TESTE B");
    }

    @Test
    @Order(2)
    void testC() {
        System.out.println("TESTE C");
    }
}
