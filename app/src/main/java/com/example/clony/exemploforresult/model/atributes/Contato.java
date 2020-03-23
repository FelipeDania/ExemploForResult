package com.example.clony.exemploforresult.model.atributes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contato implements Serializable {
    List<String> listTelefones;
    List<String> listEmail;

    public Contato() {
        listTelefones = new ArrayList<>();
        listEmail = new ArrayList<>();
    }

    public Contato(List<String> listTelefones, List<String> listEmail) {
        this.listTelefones = listTelefones;
        this.listEmail = listEmail;
    }

    public List<String> getListTelefones() {
        return listTelefones;
    }

    public void setListTelefones(List<String> listTelefones) {
        this.listTelefones = listTelefones;
    }

    public List<String> getListEmail() {
        return listEmail;
    }

    public void setListEmail(List<String> listEmail) {
        this.listEmail = listEmail;
    }

    public void addTelefone(String newTelefone){
        if(newTelefone != null && !newTelefone.trim().isEmpty())
            listTelefones.add(newTelefone);
    }

    public void addEmail(String newEmail){
        if(newEmail != null && !newEmail.trim().isEmpty())
            listEmail.add(newEmail);
    }

    @Override
    public String toString() {
        String fones = "";
        for(String telefone:listTelefones){
            fones += telefone+"\n";
        }

        String emails = "";
        for(String email:listEmail){
            emails += email+"\n";
        }

        String retorno = "Telefones\n"+fones;
        retorno += "\n\n";
        retorno += "E-mails\n"+emails;

        return retorno;
    }
}
