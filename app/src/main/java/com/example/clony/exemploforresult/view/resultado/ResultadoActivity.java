package com.example.clony.exemploforresult.view.resultado;

import android.app.Activity;
import android.os.Bundle;

import com.example.clony.exemploforresult.R;
import com.example.clony.exemploforresult.control.resultado.ResultadoControl;

public class ResultadoActivity extends Activity {
    private ResultadoControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        control = new ResultadoControl(this);
        control.montarResultadoAction();
    }
}
