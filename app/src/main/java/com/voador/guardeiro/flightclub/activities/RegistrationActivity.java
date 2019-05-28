package com.voador.guardeiro.flightclub.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.infrastructure.repositories.UsuarioRepository;
import com.voador.guardeiro.flightclub.models.Usuario;

public class RegistrationActivity extends BaseActivity {

    private EditText editTextNome;
    private EditText editTextSobrenome;
    private EditText editTextEmail;
    private EditText editTextSenha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editTextNome = findViewById(R.id.edit_text_nome);
        editTextSobrenome = findViewById(R.id.edit_text_sobrenome);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextSenha = findViewById(R.id.edit_text_senha);
        btnCadastrar = findViewById(R.id.btn_cadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });
    }

    private void cadastrarUsuario() {
        try {
            final UsuarioRepository usuarioRepository = new UsuarioRepository(getBaseContext());
            usuarioRepository.insert(criarUsuario());
            showToast("Usuário registrado com sucesso");
            goTo(LoginActivity.class);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
            showToast("Ocorreu um erro ao registrar o usuário");
        }
    }

    private Usuario criarUsuario() {
        final String nome = editTextNome.getText().toString();
        final String sobrenome = editTextSobrenome.getText().toString();
        final String email = editTextEmail.getText().toString();
        final String senha = editTextSenha.getText().toString();

        return new Usuario(nome, sobrenome, email, senha);
    }
}
