package com.mbs.entidades;

import java.io.Serializable;

/**
 *
 * @author marcelo
 */
public class Endereco implements Serializable{

    private String nomeRua;
    private Integer numero;

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    
    
}
