package com.example.requisicaoemprestimo.unitarios;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

public class EmprestimoTests {
    @Test
    public void testParcelas(){
        // ARRANGE
        //TODO: FAÇA USO DO FIXTURE
        //TODO: Crie uma classe Emprestimo com valor 100 e quantidade de parcelas 12

        // ACT
        //TODO: Recupere as parcelas do emprestimo

        // ASSERTS
        //TODO: Validar se existe parcelas
        //TODO: Validar o valor total de empréstimo é 106.50
        //TODO: Validar se o número de parcelas é 12
    }

    @Test
    public void testeAnaliseDeCreditoInvalida(){
        // ARRANGE
        //TODO: FAÇA USO DO FIXTURE
        //TODO: Crie uma classe Emprestimo com valor 100 e quantidade de parcelas 12

        // ACT
        //TODO: Crie uma análise de crédito rejeitando a proposta
        //TODO: Associe or resulado ao emprestimo

        // ASSERTS
        //TODO: Validar que o  emprestimo NÃO está aprovado
    }

    @Test
    public void testeResultadoDaTesourariaInvalida(){
        // ARRANGE
        //TODO: FAÇA USO DO FIXTURE
        //TODO: Crie uma classe Emprestimo com valor 100 e quantidade de parcelas 12

        // ACT
        //TODO: Crie uma solicitação para tesouraria rejeitando a proposta
        //TODO: Associe o resultado ao emprestimo

        // ASSERTS
        //TODO: Validar que o  emprestimo NÃO está aprovado
    }

}
