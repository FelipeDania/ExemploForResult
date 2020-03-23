package com.example.clony.exemploforresult.view.intermediario;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.clony.exemploforresult.R;
import com.example.clony.exemploforresult.control.intermediario.DadosPessoaisControl;

public class DadosPessoaisActivity extends Activity {
    DadosPessoaisControl dadosGeraisControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_pessoais);
        dadosGeraisControl = new DadosPessoaisControl(this);
    }

    public void enviar(View v){
        dadosGeraisControl.retornarDadosAction();
    }

    public void cancelar(View v){
        dadosGeraisControl.cancelarAction();
    }
}
