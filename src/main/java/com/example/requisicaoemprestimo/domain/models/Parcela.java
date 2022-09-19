package com.example.requisicaoemprestimo.domain.models;

public class Parcela {
    private double saldoAnterior;
    private double valorPrestacao;
    private double valorTaxaDeJuros;
    private double valorDaParcela;
    private double saldoResidual;

    public Parcela(double saldoAnterior, ResultadoTesouraria tesouraria){
        this.saldoAnterior =  round(saldoAnterior, 3);
        this.valorPrestacao = round((tesouraria.getValorAprovado()/tesouraria.getQuantidadeParcelas()), 3);
        this.valorTaxaDeJuros = round(saldoAnterior * (tesouraria.getTaxaJurosMensal()/100), 3);
        this.valorDaParcela = round(this.valorPrestacao + this.valorTaxaDeJuros, 3);
        this.saldoResidual = round(this.saldoAnterior - this.valorPrestacao, 3);
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public double getValorPrestacao() {
        return valorPrestacao;
    }

    public double getValorTaxaDeJuros() {
        return valorTaxaDeJuros;
    }

    public double getValorDaParcela() {
        return valorDaParcela;
    }

    public double getSaldoResidual() {
        return saldoResidual;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
