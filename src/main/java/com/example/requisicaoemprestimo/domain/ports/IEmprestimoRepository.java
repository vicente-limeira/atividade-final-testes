package com.example.requisicaoemprestimo.domain.ports;


import com.example.requisicaoemprestimo.domain.models.Emprestimo;

public interface IEmprestimoRepository {
    Emprestimo get(String codigo);
    void add(Emprestimo emprestimo);
    void update(Emprestimo emprestimo);

}
