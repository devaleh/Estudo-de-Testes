package com.example.demo;

import com.example.demo.exceptions.InvalidParamException;

public class Calculadora {

    public double subtrair(double paramUm, double paramDois) {
        // O primeiro parâmetro não pode ser menor que o segundo.
        if (paramUm < paramDois) throw new InvalidParamException("O primeiro parâmetro não pode ser menor que o segundo.");
        // Retornar valor.
        return paramUm - paramDois;
    }
}
