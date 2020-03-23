package com.example.clony.exemploforresult.view.intermediario;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.clony.exemploforresult.R;
import com.example.clony.exemploforresult.control.intermediario.DadosProfissionaisControl;

public class DadosProfissionaisActivity extends Activity {
    private DadosProfissionaisControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_profissionais);
        control = new DadosProfissionaisControl(this);
    }

    public void enviar(View v){
        control.retornarDadosAction();
    }

    public void cancelar(View v){
        control.cancelarAction();
    }
}
