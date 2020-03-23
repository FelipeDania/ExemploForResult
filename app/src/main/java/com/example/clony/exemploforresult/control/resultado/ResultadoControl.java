package com.example.clony.exemploforresult.control.resultado;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.clony.exemploforresult.R;
import com.example.clony.exemploforresult.Uteis.Constantes;
import com.example.clony.exemploforresult.model.entidades.Entrevistado;

public class ResultadoControl {
    private Activity activity;
    private TextView tvResultadoPessoais;
    private TextView tvResultadoProfissional;
    private TextView tvResultadoEndereco1;
    private TextView tvResultadoEndereco2;
    private ListView lvTelefones;
    private ListView lvEmails;

    private Entrevistado entrevistado;

    public ResultadoControl(Activity activity) {
        this.activity = activity;
        iniComponents();
    }

    private void iniComponents(){
        tvResultadoPessoais = activity.findViewById(R.id.tvResultadoPessoais);
        tvResultadoProfissional = activity.findViewById(R.id.tvResultadoProfissional);
        tvResultadoEndereco1 = activity.findViewById(R.id.tvResultadoEndereco1);
        tvResultadoEndereco2 = activity.findViewById(R.id.tvResultadoEndereco2);
        lvTelefones = activity.findViewById(R.id.lvTelefones);
        lvEmails = activity.findViewById(R.id.lvEmails);

        entrevistado = resgatarParametroEntrevistado();
        configurarListViewEmails();
        configurarListViewTelefones();
    }

    private Entrevistado resgatarParametroEntrevistado(){
        return (Entrevistado) activity.getIntent().getSerializableExtra(Constantes.PARAM_ENTREVISTADO);
    }

    private void configurarListViewTelefones(){
        final ArrayAdapter<String> adapterTelefone = new ArrayAdapter<>(
                                                        activity,
                                                        android.R.layout.simple_list_item_1,
                                                        entrevistado.getContato().getListTelefones()
                                                );
        lvTelefones.setAdapter(adapterTelefone);
        lvTelefones.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String telefone = adapterTelefone.getItem(position);

                Uri uri = Uri.parse("tel:"+telefone);
                Intent it = new Intent(Intent.ACTION_DIAL, uri);
                activity.startActivity(it);
                return true;
            }
        });
    }

    private void configurarListViewEmails(){
        ArrayAdapter<String> adapterEmails = new ArrayAdapter<>(
                activity,
                android.R.layout.simple_list_item_1,
                entrevistado.getContato().getListEmail()
        );
        lvEmails.setAdapter(adapterEmails);
    }

    public void montarResultadoAction(){
        tvResultadoPessoais.setText(entrevistado.toString());
        tvResultadoProfissional.setText(entrevistado.getProfissional().toString());
        tvResultadoEndereco1.setText(entrevistado.getEndereco().getSaida1());
        tvResultadoEndereco2.setText(entrevistado.getEndereco().getSaida2());
    }
}
