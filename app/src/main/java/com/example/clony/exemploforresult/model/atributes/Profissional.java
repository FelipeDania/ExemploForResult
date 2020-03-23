package com.example.clony.exemploforresult.model.atributes;

import java.io.Serializable;

public class Profissional implements Serializable {
    private String profissao;
    private int anosExperiencia;
    private String empresa;

    public Profissional() {
    }

    public Profissional(String profissao, int anosExperiencia, String empresa) {
        this.profissao = profissao;
        this.anosExperiencia = anosExperiencia;
        this.empresa = empresa;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Profissão: " + profissao + "\nExperiência: " + anosExperiencia + " anos\nEmpresa: " + empresa;

    }
}
