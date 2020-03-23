package com.example.clony.exemploforresult.control.intermediario;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import com.example.clony.exemploforresult.R;
import com.example.clony.exemploforresult.Uteis.Constantes;
import com.example.clony.exemploforresult.model.atributes.Profissional;
import com.example.clony.exemploforresult.model.entidades.Entrevistado;

public class DadosProfissionaisControl {
    private Activity activity;
    private EditText editProfissao;
    private EditText editAnosExperiencia;
    private EditText editNomeEmpresa;

    public DadosProfissionaisControl(Activity activity) {
        this.activity = activity;
        initComponents();

        Entrevistado entrevistado = resgatarParametroEntrevistado();
        popularForm(entrevistado);
    }

    private void initComponents(){
        editProfissao = activity.findViewById(R.id.editProfissao);
        editAnosExperiencia = activity.findViewById(R.id.editAnosExperiencia);
        editNomeEmpresa = activity.findViewById(R.id.editNomeEmpresa);
    }

    private Entrevistado resgatarParametroEntrevistado(){
        return (Entrevistado) activity.getIntent().getSerializableExtra(Constantes.PARAM_ENTREVISTADO);
    }

    private void popularForm(Entrevistado e){
        editProfissao.setText(e.getProfissional().getProfissao());
        editAnosExperiencia.setText(String.valueOf(e.getProfissional().getAnosExperiencia()));
        editNomeEmpresa.setText(e.getProfissional().getEmpresa());
    }

    public void retornarDadosAction(){
        Profissional profissional = new Profissional();
        profissional.setProfissao(editProfissao.getText().toString());
        profissional.setAnosExperiencia(Integer.parseInt(editAnosExperiencia.getText().toString()));
        profissional.setEmpresa(editNomeEmpresa.getText().toString());

        Intent it = new Intent();
        it.putExtra(Constantes.PARAM_PROFISSIONAL, profissional);
        activity.setResult(Activity.RESULT_OK, it);
        activity.finish();
    }

    public void cancelarAction(){
        activity.setResult(Activity.RESULT_CANCELED);
        activity.finish();
    }

}
