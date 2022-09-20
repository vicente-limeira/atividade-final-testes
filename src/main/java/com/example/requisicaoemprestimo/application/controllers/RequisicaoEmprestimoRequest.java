package com.example.requisicaoemprestimo.application.controllers;

import java.util.UUID;

public class RequisicaoEmprestimoRequest {
    private String usuario;
    private double valor;
    private int parcelas;


    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public UUID getUsuario() {
        return UUID.fromString(usuario);
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
