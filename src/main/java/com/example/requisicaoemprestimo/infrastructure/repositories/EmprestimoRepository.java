package com.example.requisicaoemprestimo.infrastructure.repositories;

import com.example.requisicaoemprestimo.domain.models.Emprestimo;
import com.example.requisicaoemprestimo.domain.ports.IEmprestimoRepository;

import java.util.Hashtable;

public class EmprestimoRepository implements IEmprestimoRepository {
    private Hashtable<String, Emprestimo> storage;

    public EmprestimoRepository() {
        this.storage = new Hashtable<String, Emprestimo>();
    }

    @Override
    public Emprestimo get(String codigo) {
        return this.storage.get(codigo);
    }

    @Override
    public void add(Emprestimo emprestimo) {
        this.storage.put(emprestimo.getCodigo(), emprestimo);
    }

    @Override
    public void update(Emprestimo emprestimo) {
        this.storage.replace(emprestimo.getCodigo(), emprestimo);
    }
}
