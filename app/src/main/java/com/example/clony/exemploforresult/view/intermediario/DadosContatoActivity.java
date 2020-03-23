package com.example.clony.exemploforresult.view.intermediario;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.clony.exemploforresult.R;
import com.example.clony.exemploforresult.control.intermediario.DadosContatoControl;

public class DadosContatoActivity extends Activity {
    private DadosContatoControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_contato);

        control = new DadosContatoControl(this);
    }

    public void enviar(View v){
        control.retornarDadosAction();
    }

    public void cancelar(View v){
        control.cancelarAction();
    }
}
