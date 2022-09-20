package com.example.requisicaoemprestimo.infrastructure.adapters;

import com.example.requisicaoemprestimo.domain.models.Emprestimo;
import com.example.requisicaoemprestimo.domain.models.ResultadoTesouraria;
import com.example.requisicaoemprestimo.domain.ports.ITesourariaProxy;

public class DefaultTesourariaProxy implements ITesourariaProxy {
    @Override
    public ResultadoTesouraria solicitarLiberacaoDaTesouraria(Emprestimo emprestimo) {
        var tesouraria = new ResultadoTesouraria(true, "OK");
        tesouraria.setTaxaJurosMensal(100);
        tesouraria.setQuantidadeParcelas(emprestimo.getQuantidadeParcelasSolicitadas());
        tesouraria.setValorAprovado(emprestimo.getValorSolicitado());
        return tesouraria;
    }
    //NÃO IMPLEMENTAR
}
