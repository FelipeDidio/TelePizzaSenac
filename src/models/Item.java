/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author 180701103
 */
public class Item {
    private String sabor;
    private String tamanho;
    private boolean massaIntegral;
    private boolean bordaChedar;
    private boolean bordaChoco;
    private boolean outro;
    private int unidade;
    private float valor;  

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isMassaIntegral() {
        return massaIntegral;
    }

    public void setMassaIntegral(boolean massaIntegral) {
        this.massaIntegral = massaIntegral;
    }

    public boolean isBordaChedar() {
        return bordaChedar;
    }

    public void setBordaChedar(boolean bordaChedar) {
        this.bordaChedar = bordaChedar;
    }

    public boolean isBordaChoco() {
        return bordaChoco;
    }

    public void setBordaChoco(boolean bordaChoco) {
        this.bordaChoco = bordaChoco;
    }

    public boolean isOutro() {
        return outro;
    }

    public void setOutro(boolean outro) {
        this.outro = outro;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    
    }