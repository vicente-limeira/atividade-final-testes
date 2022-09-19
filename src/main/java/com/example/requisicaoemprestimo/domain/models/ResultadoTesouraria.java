package com.example.requisicaoemprestimo.domain.models;

public class ResultadoTesouraria {
    private boolean aprovado;
    private double valorAprovado;
    private double taxaJurosMensal;
    private int quantidadeParcelas;
    private String motivo;

    public boolean isAprovado() {
        return aprovado;
    }

    public double getValorAprovado() {
        return valorAprovado;
    }

    public double getTaxaJurosMensal() {
        return taxaJurosMensal;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public void setValorAprovado(double valorAprovado) {
        this.valorAprovado = valorAprovado;
    }

    /**
     * Taxa de juros informada em BPS (basis points)
     One basis point is equal to 1/100th of 1%, or 0.01%.
     eg. 100bps = 0.01
     **/
    public void setTaxaJurosMensal(int taxaJurosMensal) {
        this.taxaJurosMensal = taxaJurosMensal/100;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }
}
