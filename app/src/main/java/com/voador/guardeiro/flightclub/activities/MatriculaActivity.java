package com.voador.guardeiro.flightclub.activities;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.adapters.PlanoSpinnerAdapter;
import com.voador.guardeiro.flightclub.infrastructure.repositories.AlunoRepository;
import com.voador.guardeiro.flightclub.infrastructure.repositories.MatriculaModalidadeRepository;
import com.voador.guardeiro.flightclub.infrastructure.repositories.PlanoRepository;
import com.voador.guardeiro.flightclub.models.Aluno;
import com.voador.guardeiro.flightclub.models.MatriculaModalidade;
import com.voador.guardeiro.flightclub.models.Plano;
import com.voador.guardeiro.flightclub.utils.CustomDatePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MatriculaActivity extends BaseActivity {

    private Spinner spinnerPlanos;
    private Button btnSalvar;
    private TextView txtDiaInicio;
    private EditText txtDiaVenc;
    private EditText editTextCodigoAluno;
    private TextView txtNomeAluno;
    private Aluno aluno;
    private MatriculaModalidadeRepository matriculaModalidadeRepository;
    private PlanoRepository planoRepository;
    private List<Plano> planos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matricula);

        spinnerPlanos = findViewById(R.id.listViewPlanos);
        btnSalvar = findViewById(R.id.btnSalvarMatricula);
        txtDiaInicio = findViewById(R.id.dataInicio);
        txtDiaVenc = findViewById(R.id.diaVencimento);
        editTextCodigoAluno = findViewById(R.id.txtCodigoAluno);
        txtNomeAluno = findViewById(R.id.txtNomeAluno);

        matriculaModalidadeRepository = new MatriculaModalidadeRepository(getBaseContext());
        planoRepository = new PlanoRepository(getBaseContext());
//        final AlunoRepository alunoRepository = new AlunoRepository(getBaseContext());
//        AlunoRetrofit a = new AlunoRetrofit(1L, "Derick", "Souza", "derick-sM@hotmail.com", "12345", "Souza", "Souza", "Souza", "Souza", "Souza", "Souza");
//        alunoRepository.insert(a);
//
//        Plano p = new Plano(1.0, "cu", new ModalidadeRetrofit("treta"));
//
//        planoRepository.insert(p);

        getPlanos();

    }

    public void novaData(final View view) {
        DialogFragment newFragment = new CustomDatePicker(txtDiaInicio);
        newFragment.show(getFragmentManager(), "Date Picker");

    }

    public void buscarCodigoAluno(View view) {
        Long codigo = Long.parseLong(editTextCodigoAluno.getText().toString());
        try {
            aluno = buscaUsuario(codigo);
            txtNomeAluno.setText(aluno.getNome());
        } catch (Exception e) {
            showErrorMessage("Não foi possível encontrar o código informado");
        }

    }

    public Aluno buscaUsuario(Long codigo) {
        return new AlunoRepository(getApplicationContext()).getById(codigo);
    }

    private void getPlanos() {
        planos = planoRepository.getAll();
        if (planos != null) {

            PlanoSpinnerAdapter array = new PlanoSpinnerAdapter(MatriculaActivity.this, android.R.layout.simple_spinner_item, planos);
            array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerPlanos.setAdapter(array);

        }
    }

    public void cadastrarMatricula(View view) {

        MatriculaModalidade matricula = null;

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date diaVenc;
        Date diaInicio;

        try {
            diaVenc = formatter.parse(txtDiaVenc.getText().toString());
            diaInicio = formatter.parse(txtDiaInicio.getText().toString());
        } catch (Exception ex) {
            diaVenc = new Date();
            diaInicio = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(diaVenc);
        cal.add(Calendar.MONTH, 1);

        final Plano plano = (Plano) spinnerPlanos.getSelectedItem();

        try {
            matricula =
                    new MatriculaModalidade(
                            aluno,
                            plano,
                            diaInicio,
                            diaVenc
                    );

            matriculaModalidadeRepository.insert(matricula);
            showSuccessMessage("Matrícula cadastrada com sucesso");
        } catch (Exception e) {
            showErrorMessage("Preencha tudo ai seu merda");
        }


    }

}
