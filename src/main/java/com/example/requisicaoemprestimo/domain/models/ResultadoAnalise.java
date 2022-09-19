package com.example.requisicaoemprestimo.domain.models;

public class ResultadoAnalise {
    private boolean aprovado;
    private String[] resultado;


    public boolean isAprovado() {
        return aprovado;
    }

    public String[] getResultado() {
        return resultado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public void setResultado(String[] resultado) {
        this.resultado = resultado;
    }
}
