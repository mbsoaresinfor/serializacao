package com.mbs.entidades;

import java.io.Serializable;

/**
 *
 * @author marcelo
 */
public class Pessoa implements Serializable{
    
    private static final long serialVersionUID = 4893313136960255886L;
    
    private String  nome;
    private Integer idade;
    private Endereco endereco;
    
    private transient float peso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
}
