package com.voador.guardeiro.flightclub;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import database.model.AlunoModel;
import database.model.MatriculasModalidadeModel;
import database.model.Persistence.AlunoPersistence;
import database.model.Persistence.MatriculaModalidadePersistence;
import database.model.Persistence.PlanosPersistence;
import database.model.PlanosModel;
import utils.CustomDatePicker;

public class MatriculaActivity extends AppCompatActivity {

    private Spinner listViewPlanos;
    private Button btnSalvar;
    private TextView txtDiaInicio;
    private EditText txtDiaVenc;
    private EditText editTextCodigoAluno;
    private TextView txtNomeAluno;
    private AlunoModel aluno;
    private MatriculaModalidadePersistence matriculaModalidadePersistence;
    private PlanosPersistence planosPersistence;
    private List<PlanosModel> listaPlanos;
    private String[] planos;
    private String diaVencimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_matricula);

        listViewPlanos = findViewById(R.id.listViewPlanos);
        btnSalvar = findViewById(R.id.btnSalvarMatricula);
        txtDiaInicio = findViewById(R.id.dataInicio);
        txtDiaVenc = findViewById(R.id.diaVencimento);
        editTextCodigoAluno = findViewById(R.id.txtCodigoAluno);
        txtNomeAluno = findViewById(R.id.txtNomeAluno);

        matriculaModalidadePersistence = new MatriculaModalidadePersistence(getBaseContext());
        planosPersistence = new PlanosPersistence(getBaseContext());
        final AlunoPersistence alunoPersistence = new AlunoPersistence(getBaseContext());
        AlunoModel a = new AlunoModel(1, "Derick", "Souza", "derick-sM@hotmail.com", "12345", "Souza", "Souza", "Souza", "Souza", "Souza", "Souza");
        alunoPersistence.insert(a);

        PlanosModel p = new PlanosModel("treta", "cu", 1.0);

        planosPersistence.insert(p);

        getPlanos();

    }

    public void novaData(final View view) {
        DialogFragment newFragment = new CustomDatePicker(txtDiaInicio);
        newFragment.show(getFragmentManager(), "Date Picker");

    }

    public void buscarCodigoAluno(View view) {
        int codigo = Integer.parseInt(editTextCodigoAluno.getText().toString());
        aluno = buscaUsuario(codigo);
        txtNomeAluno.setText(aluno.getAluno());

    }

    public AlunoModel buscaUsuario(int codigo) {
        List<AlunoModel> user = new AlunoPersistence(getApplicationContext()).whereID(codigo);
        if (user != null) {
            return user.get(0);
        }

        return null;
    }

    private void getPlanos() {
        listaPlanos = planosPersistence.getAll();
        if (listaPlanos != null) {
            planos = new String[listaPlanos.size()];

            for (int i = 0; i < listaPlanos.size(); i++) {
                planos[i] = listaPlanos.get(i).getPlano();
            }

            ArrayAdapter<String> array = new ArrayAdapter<String>(MatriculaActivity.this, android.R.layout.simple_spinner_item, planos);
            array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            listViewPlanos.setAdapter(array);

        }
    }

    public void cadastrarMatricula(View view) {

        MatriculasModalidadeModel matricula = null;
        Date data = new Date();

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date diaVenc = null;
        Date diaInicio = null;

        try {
            diaVenc = (Date)formatter.parse(txtDiaVenc.getText().toString());
            diaInicio = (Date)formatter.parse(txtDiaInicio.getText().toString());
        }
        catch (Exception ex ) {
            diaVenc = new Date();
            diaInicio = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(diaVenc);
        cal.add(Calendar.MONTH, 1);

        try{
            matricula =
                    new MatriculasModalidadeModel(
                            aluno.getCodigo(),
                            listViewPlanos.getSelectedItem().toString(),
                            diaInicio,
                            cal.getTime(),
                            new Date(),
                            Integer.parseInt(txtDiaVenc.getText().toString()),
                            txtNomeAluno.getText().toString()
                    );


            matriculaModalidadePersistence.insert(matricula);
            Toast.makeText(MatriculaActivity.this, "Matrícula cadastrada com sucesso", Toast.LENGTH_SHORT).show();

        } catch(Exception e ){
            Toast.makeText(MatriculaActivity.this, "Preencha tudo ai seu merda", Toast.LENGTH_SHORT).show();

        }


    }

}
