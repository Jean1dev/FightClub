package com.voador.guardeiro.flightclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import database.model.AlunoModel;
import database.model.Persistence.AlunoPersistence;

public class AlunoActivity extends AppCompatActivity {
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

    private Button btnCadastrar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        initSpinner();

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
                cadastrarAluno();
            }
        });
    }

    private void initSpinner() {
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, SEXO_OPTIONS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerSexo = findViewById(R.id.input_sexo);
        spinnerSexo.setAdapter(adapter);
    }

    private void cadastrarAluno() {
        final AlunoPersistence alunoPersistence = new AlunoPersistence(getBaseContext());
        try {
            alunoPersistence.insert(criarAluno());
            Toast.makeText(AlunoActivity.this, "Aluno cadastrado com sucesso", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(AlunoActivity.this, "Ocorreu um erro ao salvar o aluno", Toast.LENGTH_SHORT).show();
        }
    }

    private AlunoModel criarAluno() {
        final AlunoModel aluno = new AlunoModel();
        aluno.setAluno(editTextNome.getText().toString());
        aluno.setBairro(editTextBairro.getText().toString());
        aluno.setCelular(editTextCelular.getText().toString());
        aluno.setCep(editTextCep.getText().toString());
        aluno.setComplemento(editTextComplemento.getText().toString());
        aluno.setEmail(editTextEmail.getText().toString());
        aluno.setNumero(editTextNumero.getText().toString());
        aluno.setSexo(spinnerSexo.getSelectedItem().toString());
        aluno.setTelefone(editTextTelefone.getText().toString());
        aluno.setObservacao(editTextObservacao.getText().toString());
        return aluno;
    }

}
