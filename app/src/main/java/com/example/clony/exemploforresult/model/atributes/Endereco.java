package com.example.clony.exemploforresult.model.atributes;

import java.io.Serializable;

public class Endereco implements Serializable {
    private String cep;
    private String rua;
    private String cidade;
    private String bairro;
    private String estado;

    public Endereco() {
    }

    public Endereco(String cep, String rua, String cidade, String bairro, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSaida1() {
        return "CEP: " + cep + "\nRua: " + rua +"\nCidade: " + cidade;
    }

    public String getSaida2() {
        return "Bairro: " + bairro + "\nEstado: " + estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
