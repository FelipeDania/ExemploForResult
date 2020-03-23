package com.example.clony.exemploforresult.control.principal;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import com.example.clony.exemploforresult.R;
import com.example.clony.exemploforresult.Uteis.Constantes;
import com.example.clony.exemploforresult.model.atributes.Endereco;
import com.example.clony.exemploforresult.model.entidades.Entrevistado;
import com.example.clony.exemploforresult.model.atributes.Profissional;
import com.example.clony.exemploforresult.view.intermediario.DadosContatoActivity;
import com.example.clony.exemploforresult.view.intermediario.DadosEnderecoActivity;
import com.example.clony.exemploforresult.view.intermediario.DadosPessoaisActivity;
import com.example.clony.exemploforresult.view.intermediario.DadosProfissionaisActivity;
import com.example.clony.exemploforresult.view.resultado.ResultadoActivity;

public class MainControl {
    private Activity activity;
    private Entrevistado entrevistado;
    private TextView tvTesteRetorno;

    public MainControl(Activity activity) {
        this.activity = activity;
        initComponents();
        entrevistado = new Entrevistado();
    }

    private void initComponents(){
        //Resgata o textView para testes
        tvTesteRetorno = activity.findViewById(R.id.tvTesteRetorno);
    }

    public void enviarAction(){
        Intent it = new Intent(activity, ResultadoActivity.class);
        it.putExtra(Constantes.PARAM_ENTREVISTADO, entrevistado);
        activity.startActivity(it);
    }

    public void chamarTelaAction(int idBotao){
        Intent it = null;
        switch (idBotao){
            case R.id.btDadosPessoais:
                it = new Intent(activity, DadosPessoaisActivity.class);
                it.putExtra(Constantes.PARAM_ENTREVISTADO, entrevistado);
                activity.startActivityForResult(it, Constantes.REQUEST_DADOS_PESSOAIS);
                break;

            case R.id.btDadosProfissionais:
                it = new Intent(activity, DadosProfissionaisActivity.class);
                it.putExtra(Constantes.PARAM_ENTREVISTADO, entrevistado);
                activity.startActivityForResult(it, Constantes.REQUEST_DADOS_PROFISSIONAL);
                break;

            case R.id.btDadosEndereco:
                it = new Intent(activity, DadosEnderecoActivity.class);
                it.putExtra(Constantes.PARAM_ENTREVISTADO, entrevistado);
                activity.startActivityForResult(it, Constantes.REQUEST_DADOS_ENDERECO);
                break;

            case R.id.btDadosContato:
                it = new Intent(activity, DadosContatoActivity.class);
                activity.startActivityForResult(it, Constantes.REQUEST_DADOS_CONTATO);
                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == activity.RESULT_OK){
            switch (requestCode){
                case Constantes.REQUEST_DADOS_PESSOAIS:
                    //Resgate dos dados coletados na activity dos dados pessoais
                    entrevistado.setNome(data.getStringExtra(Constantes.PARAM_NOME));
                    entrevistado.setIdade(data.getIntExtra(Constantes.PARAM_IDADE, 0));
                    entrevistado.setCpf(data.getStringExtra(Constantes.PARAM_CPF));

                    //Mostra uma mensagem com os dados coletados
                    tvTesteRetorno.setText("Dados pessoais coletados\n" + entrevistado.toString());
                    break;

                case Constantes.REQUEST_DADOS_PROFISSIONAL:
                    //Resgate dos dados coletados na activity dos dados profissionais
                    Profissional profissa = (Profissional) data.getSerializableExtra(Constantes.PARAM_PROFISSIONAL);
                    entrevistado.setProfissional(profissa);

                    //Mostra uma mensagem com os dados coletados
                    tvTesteRetorno.setText("Dados profissionais coletados\n" + profissa.toString());
                    break;

                case Constantes.REQUEST_DADOS_ENDERECO:
                    Endereco endereco = (Endereco) data.getSerializableExtra(Constantes.PARAM_ENDERECO);
                    entrevistado.setEndereco(endereco);

                    //Mostra uma mensagem com os dados coletados
                    tvTesteRetorno.setText("Dados de endereço coletados\n" + endereco.toString());
                    break;

                case Constantes.REQUEST_DADOS_CONTATO:
                    String newFone = data.getStringExtra(Constantes.PARAM_CONTATO_FONE);
                    entrevistado.getContato().addTelefone(newFone);

                    String newEmail = data.getStringExtra(Constantes.PARAM_CONTATO_EMAIL);
                    entrevistado.getContato().addEmail(newEmail);

                    //Mostra uma mensagem com os dados coletados
                    tvTesteRetorno.setText("Dados de contato coletados\n" + entrevistado.getContato().toString());
                    break;
            }
        } else {
            tvTesteRetorno.setText("Cancelou ou pressionou voltar");
        }
    }
}
