package com.example.clony.exemploforresult.control.intermediario;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import com.example.clony.exemploforresult.R;
import com.example.clony.exemploforresult.Uteis.Constantes;

public class DadosContatoControl {
    private Activity activity;
    private EditText editEmail;
    private EditText editTelefone;

    public DadosContatoControl(Activity activity) {
        this.activity = activity;
        initComponents();
    }

    private void initComponents(){
        editEmail = activity.findViewById(R.id.editEmail);
        editTelefone = activity.findViewById(R.id.editTelefone);
    }

    public void retornarDadosAction(){
        Intent it = new Intent();
        it.putExtra(Constantes.PARAM_CONTATO_FONE, editTelefone.getText().toString());
        it.putExtra(Constantes.PARAM_CONTATO_EMAIL, editEmail.getText().toString());
        activity.setResult(Activity.RESULT_OK, it);
        activity.finish();
    }

    public void cancelarAction(){
        activity.setResult(Activity.RESULT_CANCELED);
        activity.finish();
    }

}