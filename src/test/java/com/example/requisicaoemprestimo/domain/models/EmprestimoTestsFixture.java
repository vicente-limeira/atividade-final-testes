package com.example.requisicaoemprestimo.domain.models;

import java.util.UUID;

public class EmprestimoTestsFixture {
    public static Emprestimo emprestimoAprovado(double valor, int quantidadeParcelas) {
        var emprestimo = new Emprestimo(UUID.randomUUID(), valor, quantidadeParcelas);

        var analiseCredito = new ResultadoAnalise();
        analiseCredito.setAprovado(true);
        analiseCredito.setResultado(new String[]{"OK"});

        var tesouraria = new ResultadoTesouraria();
        tesouraria.setAprovado(true);
        tesouraria.setMotivo("OK");
        tesouraria.setTaxaJurosMensal(100);
        tesouraria.setQuantidadeParcelas(quantidadeParcelas);
        tesouraria.setValorAprovado(valor);

        emprestimo.registrarResultadoDaAnaliseCredito(analiseCredito);
        emprestimo.registrarResultadoDaTesouraria(tesouraria);
        return emprestimo;
    }
}
