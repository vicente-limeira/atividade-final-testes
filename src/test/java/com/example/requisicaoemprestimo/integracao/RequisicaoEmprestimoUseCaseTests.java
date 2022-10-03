package com.example.requisicaoemprestimo.integracao;

import com.example.requisicaoemprestimo.domain.models.Emprestimo;
import com.example.requisicaoemprestimo.domain.models.ResultadoAnalise;
import com.example.requisicaoemprestimo.domain.models.ResultadoTesouraria;
import com.example.requisicaoemprestimo.domain.ports.IAnaliseProxy;
import com.example.requisicaoemprestimo.domain.ports.ITesourariaProxy;
import com.example.requisicaoemprestimo.domain.usecases.RequisicaoEmprestimoUseCase;
import org.junit.jupiter.api.Test;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//TODO: Use o mokito para realizar testes TOP-DOWN para criar dublês das interfaces IAnaliseProxy e ITesourariaProxy
public class RequisicaoEmprestimoUseCaseTests {

    //TODO: Setup das classes Mocks e Instância real da classe RequisicaoEmprestimoUseCase
    IAnaliseProxy iAnaliseProxy = mock(IAnaliseProxy.class);
    ITesourariaProxy iTesourariaProxy = mock(ITesourariaProxy.class);
    RequisicaoEmprestimoUseCase requisicaoEmprestimoUseCase = new RequisicaoEmprestimoUseCase(iAnaliseProxy, iTesourariaProxy);

    final String approved = "APROVADO", disapproved = "REPROVADO";

    @Test
    public void test_aprovado(){
        //TODO Fazer um teste caminho Feliz (TUDO FUNCIONA BEM)
        Emprestimo emprestimo;

        ResultadoAnalise resultadoAnalise = new ResultadoAnalise(true, new String[] {approved});
        when(iAnaliseProxy.solicitarAnaliseDeCredito(any())).thenReturn(resultadoAnalise);

        ResultadoTesouraria resultadoTesouraria = new ResultadoTesouraria(true, approved);
        when(iTesourariaProxy.solicitarLiberacaoDaTesouraria(any())).thenReturn(resultadoTesouraria);

        assertAll(() -> requisicaoEmprestimoUseCase.executar(UUID.randomUUID(), 100.00, 2));
        emprestimo = requisicaoEmprestimoUseCase.executar(UUID.randomUUID(), 100.00, 2);
        assertEquals(true, emprestimo.isEmprestimoFoiAprovado());
    }

    @Test
    public void test_analise_reprovado(){
        //TODO Fazer um teste caminho INFELIZ IAnaliseProxy retornando uma Análise reprovada
        Emprestimo emprestimo;

        ResultadoAnalise analise = new ResultadoAnalise(false, new String[] {disapproved});
        when(iAnaliseProxy.solicitarAnaliseDeCredito(any())).thenReturn(analise);

        ResultadoTesouraria tesouraria = new ResultadoTesouraria(true, disapproved);
        when(iTesourariaProxy.solicitarLiberacaoDaTesouraria(any())).thenReturn(tesouraria);

        assertAll(() -> requisicaoEmprestimoUseCase.executar(UUID.randomUUID(), 1000.00, 10));
        emprestimo = requisicaoEmprestimoUseCase.executar(UUID.randomUUID(), 1000.00, 10);

        assertEquals(analise, emprestimo.getResultadoAnalise());
        assertEquals(false, emprestimo.isEmprestimoFoiAprovado());
    }

    @Test
    public void test_tesouraria_reprovado(){
        //TODO Fazer um teste caminho INFELIZ ITesourariaProxy retornando resultado reprovado
        Emprestimo emprestimo;

        ResultadoAnalise resultadoAnalise = new ResultadoAnalise(true, new String[] {approved});
        when(iAnaliseProxy.solicitarAnaliseDeCredito(any())).thenReturn(resultadoAnalise);

        ResultadoTesouraria resultadoTesouraria = new ResultadoTesouraria(false, disapproved);
        when(iTesourariaProxy.solicitarLiberacaoDaTesouraria(any())).thenReturn(resultadoTesouraria);

        assertAll(() -> requisicaoEmprestimoUseCase.executar(UUID.randomUUID(), 1000.00, 10));
        emprestimo = requisicaoEmprestimoUseCase.executar(UUID.randomUUID(), 1000.00, 10);

        assertEquals(resultadoTesouraria, emprestimo.getResultadoTesouraria());
        assertEquals(false, emprestimo.isEmprestimoFoiAprovado());
    }
}
