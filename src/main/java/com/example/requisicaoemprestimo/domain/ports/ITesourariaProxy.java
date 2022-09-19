package com.example.requisicaoemprestimo.domain.ports;

import com.example.requisicaoemprestimo.domain.models.Emprestimo;
import com.example.requisicaoemprestimo.domain.models.ResultadoTesouraria;

public interface ITesourariaProxy {
    ResultadoTesouraria solicitarLiberacaoDaTesouraria(Emprestimo emprestimo);
}
