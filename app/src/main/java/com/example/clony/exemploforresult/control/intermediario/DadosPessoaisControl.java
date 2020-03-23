package com.example.clony.exemploforresult.control.intermediario;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import com.example.clony.exemploforresult.R;
import com.example.clony.exemploforresult.Uteis.Constantes;
import com.example.clony.exemploforresult.model.atributes.Profissional;
import com.example.clony.exemploforresult.model.entidades.Entrevistado;

public class DadosPessoaisControl {
    private Activity activity;
    private EditText editNome;
    private EditText editIdade;
    private EditText editCpf;

    public DadosPessoaisControl(Activity activity) {
        this.activity = activity;
        initComponents();

        Entrevistado entrevistado = resgatarParametroEntrevistado();
        popularForm(entrevistado);
    }

    private void initComponents(){
        editNome = activity.findViewById(R.id.editNome);
        editIdade = activity.findViewById(R.id.editIdade);
        editCpf = activity.findViewById(R.id.editCpf);
    }

    private Entrevistado resgatarParametroEntrevistado(){
        return (Entrevistado) activity.getIntent().getSerializableExtra(Constantes.PARAM_ENTREVISTADO);
    }

    private void popularForm(Entrevistado e){
        editNome.setText(e.getNome());
        editIdade.setText(String.valueOf(e.getIdade()));
        editCpf.setText(e.getCpf());
    }

    public void retornarDadosAction(){
        Intent it = new Intent();
        it.putExtra(Constantes.PARAM_NOME, editNome.getText().toString());
        it.putExtra(Constantes.PARAM_IDADE, Integer.parseInt(editIdade.getText().toString()));
        it.putExtra(Constantes.PARAM_CPF, editCpf.getText().toString());

        activity.setResult(Activity.RESULT_OK, it);
        activity.finish();
    }

    public void cancelarAction(){
        activity.setResult(Activity.RESULT_CANCELED);
        activity.finish();
    }

}
