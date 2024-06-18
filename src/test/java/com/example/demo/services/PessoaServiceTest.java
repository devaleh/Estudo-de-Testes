package com.example.demo.services;

import com.example.demo.model.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaServiceTest {

    IPessoaService service;
    Pessoa pessoa;

    @BeforeEach
    void setup() {
        service = new PessoaService();

        pessoa = new Pessoa("Alexandre",
                "Cestari",
                "alexandre@gmail.com",
                "Iconha - ES",
                "Masculino");
    }

    @Test
    @DisplayName("Criar pessoa")
    void testeCriarPessoa() {

        Pessoa newPessoa = service.criarPessoa(pessoa);

        assertNotNull(newPessoa, "Retorno null");
    }

    @Test
    @DisplayName("Comparar nome")
    void testeCompararNome() {

        Pessoa newPessoa = service.criarPessoa(pessoa);

        assertEquals(pessoa.getNome(), newPessoa.getNome(), "Nome nao compatível");
        assertEquals(pessoa.getSobrenome(), newPessoa.getSobrenome(), "Sobrenome nao compatível");
        assertEquals(pessoa.getEmail(), newPessoa.getEmail(), "Email nao compatível");
        assertEquals(pessoa.getEndereco(), newPessoa.getEndereco(), "Endereco nao compatível");
        assertEquals(pessoa.getSexo(), newPessoa.getSexo(), "Sexo nao compatível");
    }
}
