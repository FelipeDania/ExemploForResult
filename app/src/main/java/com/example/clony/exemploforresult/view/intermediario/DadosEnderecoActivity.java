package com.example.clony.exemploforresult.view.intermediario;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.clony.exemploforresult.R;
import com.example.clony.exemploforresult.control.intermediario.DadosEnderecoControl;

public class DadosEnderecoActivity extends Activity {
    DadosEnderecoControl dadosEnderecoControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_endereco);

        dadosEnderecoControl = new DadosEnderecoControl(this);
    }

    public void enviar(View v){
        dadosEnderecoControl.retornarDadosAction();
    }

    public void cancelar(View v){
        dadosEnderecoControl.cancelarAction();
    }

}
