package com.example.requisicaoemprestimo.domain.ports;

import com.example.requisicaoemprestimo.domain.models.Emprestimo;
import com.example.requisicaoemprestimo.domain.models.ResultadoAnalise;

public interface IAnaliseProxy {

    ResultadoAnalise solicitarAnaliseDeCredito(Emprestimo emprestimo);
}
