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
public class Pedido {
    private String cliente;
    private String telefone;
    private String endereco;
    private String cidade;
    
    

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        if(cliente == null || cliente.trim().isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio!");
        }
        this.cliente = cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone == null || telefone.trim().isEmpty()){
            throw new IllegalArgumentException("O número de telefone não pode ser nulo ou vazio");
        }
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if(endereco == null || endereco.trim().isEmpty()){
            throw new IllegalArgumentException("O endereço não pode ser nulo ou vazio.");
        }
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if(cidade == null || cidade.trim().isEmpty() ){
            throw new IllegalArgumentException("A cidade precisa ser selecionada;");
        }
        this.cidade = cidade;
    }
}
