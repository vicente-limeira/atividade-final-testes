package com.example.requisicaoemprestimo.infrastructure.repositories;

import com.example.requisicaoemprestimo.domain.ports.IEmprestimoRepository;

public class RepositoryFactory {
    private static EmprestimoRepository instance;

    private RepositoryFactory() {}

    public static IEmprestimoRepository getInstance(){
        if (instance == null)
        {
            instance = new EmprestimoRepository();
        }
        return instance;
    }
}
