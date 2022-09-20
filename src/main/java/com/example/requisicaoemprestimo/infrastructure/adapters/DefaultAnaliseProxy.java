package com.example.requisicaoemprestimo.infrastructure.adapters;

import com.example.requisicaoemprestimo.domain.models.Emprestimo;
import com.example.requisicaoemprestimo.domain.models.ResultadoAnalise;
import com.example.requisicaoemprestimo.domain.ports.IAnaliseProxy;

public class DefaultAnaliseProxy implements IAnaliseProxy {
    @Override
    public ResultadoAnalise solicitarAnaliseDeCredito(Emprestimo emprestimo) {
        return new ResultadoAnalise(true, new String[]{"OK"});
    }
}
