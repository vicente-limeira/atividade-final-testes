package com.example.requisicaoemprestimo.domain.models;

import java.util.Optional;
import java.util.UUID;

public class Emprestimo {
    private String codigo;
    private String usuario;
    private double valorSolicitado;
    private double valorTotalEmprestimo;
    private int quantidadeParcelasSolicitadas;
    private ResultadoAnalise resultadoAnalise;
    private ResultadoTesouraria resultadoTesouraria;
    private Optional<Parcela[]> parcelas;

    public Emprestimo(UUID usuarioUuid, double valor, int quantidadeParcelas){
        this.codigo = UUID.randomUUID().toString();
        this.usuario = usuarioUuid.toString();
        this.valorSolicitado = valor;
        this.quantidadeParcelasSolicitadas = quantidadeParcelas;
        this.resultadoAnalise = new ResultadoAnalise();
        this.resultadoTesouraria = new ResultadoTesouraria();
        this.parcelas = Optional.empty();
    }

    public void registrarResultadoDaAnaliseCredito(ResultadoAnalise analiseCredito){
        this.resultadoAnalise = analiseCredito;
    }

    public void registrarResultadoDaTesouraria(ResultadoTesouraria tesouraria){
        this.resultadoTesouraria = tesouraria;
        this.parcelas = calcularParcelas();
    }

    public boolean EmprestimoFoiAprovado(){
        return this.resultadoTesouraria.isAprovado() && this.resultadoAnalise.isAprovado();
    }

    private Optional<Parcela[]> calcularParcelas(){
        if (!EmprestimoFoiAprovado()) return Optional.empty();

        var parcelas = new Parcela[resultadoTesouraria.getQuantidadeParcelas()];
        var saldoAnterior = resultadoTesouraria.getValorAprovado();

        for (var i = 0; i < resultadoTesouraria.getQuantidadeParcelas(); i++){
            var parcela = new Parcela(saldoAnterior, resultadoTesouraria);

            this.valorTotalEmprestimo += parcela.getValorDaParcela();
            saldoAnterior = parcela.getSaldoResidual();
            parcelas[i] = parcela;
        }

        return Optional.of(parcelas);
    }

    public Optional<Parcela[]> getParcelas(){
        return this.parcelas;
    }

    public double getValorTotalEmprestimo() {
        return Parcela.round(this.valorTotalEmprestimo, 2);
    }

    public int getQuantidadeParcelasSolicitadas() {
        return quantidadeParcelasSolicitadas;
    }
}

