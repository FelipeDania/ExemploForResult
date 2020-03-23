package com.example.clony.exemploforresult.view.principal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.clony.exemploforresult.R;
import com.example.clony.exemploforresult.control.principal.MainControl;

public class MainActivity extends Activity {
    MainControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control = new MainControl(this);
    }

    public void resgatarDados(View v){
        control.chamarTelaAction(v.getId());
    }

    public void enviar(View v){
        control.enviarAction();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }
}
