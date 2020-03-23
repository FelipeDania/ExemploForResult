package com.example.clony.exemploforresult.model.entidades;

import com.example.clony.exemploforresult.model.atributes.Contato;
import com.example.clony.exemploforresult.model.atributes.Endereco;
import com.example.clony.exemploforresult.model.atributes.Profissional;

import java.io.Serializable;

public class Entrevistado implements Serializable {
    private String nome;
    private int idade;
    private String cpf;
    private Contato contato;
    private Endereco endereco;
    private Profissional profissional;

    public Entrevistado() {
        contato = new Contato();
        endereco = new Endereco();
        profissional = new Profissional();
    }

    public Entrevistado(String nome, int idade, String cpf, Contato contato, Endereco endereco, Profissional profissional) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.contato = contato;
        this.endereco = endereco;
        this.profissional = profissional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    @Override
    public String toString() {
        return "Nome:" + nome + "\nIdade: " + idade + "\nCPF: " + cpf;
    }
}
