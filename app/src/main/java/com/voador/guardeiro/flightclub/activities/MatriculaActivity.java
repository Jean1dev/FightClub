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
import com.voador.guardeiro.flightclub.adapters.PlanoListViewAdapter2;
import com.voador.guardeiro.flightclub.adapters.PlanoSpinnerAdapter;
import com.voador.guardeiro.flightclub.infrastructure.repositories.AlunoRepository;
import com.voador.guardeiro.flightclub.infrastructure.repositories.MatriculaModalidadeRepository;
import com.voador.guardeiro.flightclub.infrastructure.repositories.PlanoRepository;
import com.voador.guardeiro.flightclub.models.Aluno;
import com.voador.guardeiro.flightclub.models.MatriculaModalidade;
import com.voador.guardeiro.flightclub.models.Plano;
import com.voador.guardeiro.flightclub.retrofit.ApiService;
import com.voador.guardeiro.flightclub.retrofit.models.AlunoRetrofit;
import com.voador.guardeiro.flightclub.retrofit.models.MatriculModalidadeRetrofit;
import com.voador.guardeiro.flightclub.retrofit.models.ModalidadeRetrofit;
import com.voador.guardeiro.flightclub.retrofit.models.PlanoRetrofit;
import com.voador.guardeiro.flightclub.retrofit.services.AlunoService;
import com.voador.guardeiro.flightclub.retrofit.services.PlanoService;
import com.voador.guardeiro.flightclub.utils.CustomDatePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatriculaActivity extends BaseActivity {

    private Spinner spinnerPlanos;
    private Button btnSalvar;
    private TextView txtDiaInicio;
    private EditText txtDiaVenc;
    private EditText editTextCodigoAluno;
    private TextView txtNomeAluno;
    private AlunoRetrofit aluno;
    private MatriculaModalidadeRepository matriculaModalidadeRepository;
    private List<PlanoRetrofit> planos = new ArrayList<PlanoRetrofit>();

    private AlunoService alunoService;
    private PlanoService planoService;

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
        planoService = new ApiService().getPlanoService();
        alunoService = new ApiService().getAlunoService();

        buscarPlanos();

    }

    public void novaData(final View view) {
        DialogFragment newFragment = new CustomDatePicker(txtDiaInicio);
        newFragment.show(getFragmentManager(), "Date Picker");

    }

    public void buscarCodigoAluno(View view) {
        Long codigo = Long.parseLong(editTextCodigoAluno.getText().toString());
        try {
            aluno = buscaUsuario(codigo);
            txtNomeAluno.setText(aluno.getNm_aluno());
        } catch (Exception e) {
            showErrorMessage("Não foi possível encontrar o código informado");
        }

    }

    public AlunoRetrofit buscaUsuario(Long codigo) {
        final AlunoRetrofit[] aluno = {new AlunoRetrofit()};
        alunoService.buscarAlunos(22).enqueue(new Callback<List<AlunoRetrofit>>() {
            @Override
            public void onResponse(Call<List<AlunoRetrofit>> call, Response<List<AlunoRetrofit>> response) {
                for (final AlunoRetrofit a : response.body()) {
                    if(a.getId() == codigo){
                        aluno[0] = a;
                    }
                }
            }
            @Override
            public void onFailure(Call<List<AlunoRetrofit>> call, Throwable t) {
                showErrorMessage("Erro ao buscar aluno");
            }
        });

        return aluno[0];
    }


    private void buscarPlanos() {
        planos.clear();
        planoService.buscarTodos(22, 22).enqueue(new Callback<List<PlanoRetrofit>>() {
            @Override
            public void onResponse(Call<List<PlanoRetrofit>> call, Response<List<PlanoRetrofit>> response) {
                for (final PlanoRetrofit plano : response.body()) {
                    planos.add(plano);
                }
            }
            @Override
            public void onFailure(Call<List<PlanoRetrofit>> call, Throwable t) {
                t.printStackTrace();
                showToast("Ocorreu um erro");
            }
        });

        if ( spinnerPlanos!= null) {
            PlanoSpinnerAdapter array = new PlanoSpinnerAdapter(MatriculaActivity.this, android.R.layout.simple_spinner_item, planos);
            array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerPlanos.setAdapter(array);
        }
    }

//    public void cadastrarMatricula(View view) {
//
//        MatriculModalidadeRetrofit matricula = null;
//
//        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        Date diaVenc;
//        Date diaInicio;
//
//        try {
//            diaVenc = formatter.parse(txtDiaVenc.getText().toString());
//            diaInicio = formatter.parse(txtDiaInicio.getText().toString());
//        } catch (Exception ex) {
//            diaVenc = new Date();
//            diaInicio = new Date();
//        }
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(diaVenc);
//        cal.add(Calendar.MONTH, 1);
//
//        final Plano plano = (Plano) spinnerPlanos.getSelectedItem();
//
//        try {
//            matricula =
//                    new MatriculModalidadeRetrofit(
//                            aluno,
//                            plano,
//                            diaInicio,
//                            diaVenc
//                    );
//
//            matriculaModalidadeRepository.insert(matricula);
//            showSuccessMessage("Matrícula cadastrada com sucesso");
//        } catch (Exception e) {
//            showErrorMessage("Preencha tudo ai seu merda");
//        }
//
//
//    }

}
