package com.example.clony.exemploforresult.control.intermediario;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clony.exemploforresult.R;
import com.example.clony.exemploforresult.Uteis.Constantes;
import com.example.clony.exemploforresult.model.atributes.Endereco;
import com.example.clony.exemploforresult.model.entidades.Entrevistado;
import com.example.clony.exemploforresult.model.retorno_json.EnderecoRetornoJSON;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class DadosEnderecoControl {
    private Activity activity;
    private EditText editCep;
    private EditText editRua;
    private EditText editCidade;
    private EditText editBairro;
    private EditText editEstado;
    private Endereco endereco;

    public DadosEnderecoControl(Activity activity) {
        this.activity = activity;
        initComponents();

        Entrevistado entrevistado = resgatarParametroEntrevistado();
        popularForm(entrevistado);
    }

    private Entrevistado resgatarParametroEntrevistado(){
        return (Entrevistado) activity.getIntent().getSerializableExtra(Constantes.PARAM_ENTREVISTADO);
    }

    private void popularForm(Entrevistado e){
        editCep.setText(e.getEndereco().getCep());
        editRua.setText(e.getEndereco().getRua());
        editCidade.setText(e.getEndereco().getCidade());
        editBairro.setText(e.getEndereco().getBairro());
        editEstado.setText(e.getEndereco().getEstado());
    }

    private void initComponents(){
        editCep = activity.findViewById(R.id.editCep);
        editRua = activity.findViewById(R.id.editRua);
        editCidade = activity.findViewById(R.id.editCidade);
        editBairro = activity.findViewById(R.id.editBairro);
        editEstado = activity.findViewById(R.id.editEstado);

        editCep.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()==8){
                    Toast.makeText(activity, "Requisição requisitada", Toast.LENGTH_SHORT).show();
                    carregarCamposEnderecoAction(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void carregarCamposEnderecoAction(String cep){
        String url = "https://viacep.com.br/ws/"+cep+"/json/";

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciando requisição", Toast.LENGTH_SHORT).show();
                bloquearCampos();
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String res = new String(bytes);
                Gson gson = new Gson();
                EnderecoRetornoJSON e = gson.fromJson(res, EnderecoRetornoJSON.class);
                popularCampos(e);
            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
                Toast.makeText(activity, "Tentativa "+retryNo, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Sua requisição falhou. Cod Falha:"+i, Toast.LENGTH_SHORT).show();
                desbloquearCampos();
            }
        });
    }

    private void bloquearCampos(){
        editRua.setText("...");
        editRua.setEnabled(false);

        editCidade.setText("...");
        editCidade.setEnabled(false);

        editBairro.setText("...");
        editBairro.setEnabled(false);

        editEstado.setText("...");
        editEstado.setEnabled(false);
    }

    private void desbloquearCampos(){
        editRua.setText("");
        editRua.setEnabled(true);

        editCidade.setText("");
        editCidade.setEnabled(true);

        editBairro.setText("");
        editBairro.setEnabled(true);

        editEstado.setText("");
        editEstado.setEnabled(true);
    }

    private void popularCampos(EnderecoRetornoJSON endereco){
        desbloquearCampos();
        editRua.setText(endereco.getLogradouro());
        editCidade.setText(endereco.getLocalidade());
        editBairro.setText(endereco.getBairro());
        editEstado.setText(endereco.getUf());
    }

    public void retornarDadosAction(){
        endereco = new Endereco();
        endereco.setCep(editCep.getText().toString());
        endereco.setRua(editRua.getText().toString());
        endereco.setBairro(editBairro.getText().toString());
        endereco.setCidade(editCidade.getText().toString());
        endereco.setEstado(editEstado.getText().toString());

        Intent it = new Intent();
        it.putExtra(Constantes.PARAM_ENDERECO, endereco);

        activity.setResult(Activity.RESULT_OK, it);
        activity.finish();
    }

    public void cancelarAction(){
        activity.setResult(Activity.RESULT_CANCELED);
        activity.finish();
    }

}
