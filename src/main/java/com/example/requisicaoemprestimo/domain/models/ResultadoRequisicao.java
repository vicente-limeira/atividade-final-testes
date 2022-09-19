package com.example.requisicaoemprestimo.domain.models;

public class ResultadoRequisicao {
    private boolean aprovado;
    private String[] resultado;

    public ResultadoRequisicao() {
        this.aprovado = true;
        this.resultado = new String[] {"OK"};
    }

    public ResultadoRequisicao(boolean aprovado, String[] resultado)
    {
        this.aprovado = aprovado;
        this.resultado = resultado;
    }

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
