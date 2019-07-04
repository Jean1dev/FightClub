package com.voador.guardeiro.flightclub.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.infrastructure.repositories.AlunoRepository;
import com.voador.guardeiro.flightclub.models.Aluno;
import com.voador.guardeiro.flightclub.retrofit.ApiService;
import com.voador.guardeiro.flightclub.retrofit.models.AlunoRetrofit;
import com.voador.guardeiro.flightclub.retrofit.services.AlunoService;
import com.voador.guardeiro.flightclub.retrofit.services.ModalidadeService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlunoActivity extends BaseActivity {
    private static final String[] SEXO_OPTIONS = {"M", "F"};

    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextTelefone;
    private EditText editTextCelular;
    private EditText editTextNumero;
    private EditText editTextBairro;
    private EditText editTextCep;
    private EditText editTextComplemento;
    private EditText editTextObservacao;
    private Spinner spinnerSexo;


    private AlunoService alunoService;

    private Button btnCadastrar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        initSpinner();

        alunoService = new ApiService().getAlunoService();

        editTextNome = findViewById(R.id.input_nome);
        editTextEmail = findViewById(R.id.input_email);
        editTextTelefone = findViewById(R.id.input_telefone);
        editTextCelular = findViewById(R.id.input_celular);
        editTextNumero = findViewById(R.id.input_numero);
        editTextBairro = findViewById(R.id.input_bairro);
        editTextCep = findViewById(R.id.input_cep);
        editTextComplemento = findViewById(R.id.input_complemento);
        editTextObservacao = findViewById(R.id.input_observacao);
        btnCadastrar = findViewById(R.id.btn_cadastrar_aluno);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cadastrarAluno();
                inserirAluno();
            }
        });
    }

    private void initSpinner() {
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, SEXO_OPTIONS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerSexo = findViewById(R.id.input_sexo);
        spinnerSexo.setAdapter(adapter);
    }

    private void inserirAluno() {
        alunoService
                .inserirAluno(criarAluno())
                .enqueue(new Callback<Long>() {
                    @Override
                    public void onResponse(Call<Long> call, Response<Long> response) {
                        showSuccessMessage("Aluno cadastrado com sucesso");
                    }
                    @Override
                    public void onFailure(Call<Long> call, Throwable t) {
                        showSuccessMessage("Erro ao cadastrar aluno");
                    }
                });
    }

    private AlunoRetrofit criarAluno() {
        final AlunoRetrofit aluno = new AlunoRetrofit();
        aluno.setNm_aluno(editTextNome.getText().toString());
        aluno.setCelular(editTextCelular.getText().toString());
        aluno.setBairro(editTextBairro.getText().toString());
        aluno.setCep(editTextCep.getText().toString());
        aluno.setCidade("Criciuma");
        aluno.setData_nascimento("22222");
        aluno.setEmail(editTextEmail.getText().toString());
        aluno.setEstado("Santa catarina");
        aluno.setEndereco("Endereco");
        aluno.setPais("Brasil");
        aluno.setTelefone(editTextTelefone.getText().toString());
        aluno.setNumero(editTextNumero.getText().toString());
        aluno.setSexo(spinnerSexo.getSelectedItem().toString());
        aluno.setIdConta(DEFAULT_CONTA_ID);
        return aluno;
    }

}
