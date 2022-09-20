package com.example.requisicaoemprestimo.application.controllers;

import com.example.requisicaoemprestimo.domain.models.Emprestimo;
import com.example.requisicaoemprestimo.domain.usecases.RequisicaoEmprestimoUseCase;
import com.example.requisicaoemprestimo.infrastructure.adapters.DefaultAnaliseProxy;
import com.example.requisicaoemprestimo.infrastructure.adapters.DefaultTesourariaProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmprestimoController {
    //TODO: vou implementar
    private final RequisicaoEmprestimoUseCase requisicaoEmprestimoUseCase;

    public EmprestimoController(){
        this.requisicaoEmprestimoUseCase = new RequisicaoEmprestimoUseCase(new DefaultAnaliseProxy(), new DefaultTesourariaProxy());
    }

    @PostMapping("/emprestimo/registro")
    public Emprestimo Post(@RequestBody RequisicaoEmprestimoRequest request){
        var resultado = this.requisicaoEmprestimoUseCase.executar(request.getUsuario(), request.getValor(), request.getParcelas());
        return resultado;
    }
}
