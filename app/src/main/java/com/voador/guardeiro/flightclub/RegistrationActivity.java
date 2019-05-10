package com.voador.guardeiro.flightclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.model.Persistence.UsuarioPersistence;
import database.model.Usuario;

public class RegistrationActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextSobrenome;
    private EditText editTextEmail;
    private EditText editTextSenha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
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
        final UsuarioPersistence usuarioPersistence = new UsuarioPersistence(getBaseContext());
        usuarioPersistence.insert(getUsuario());
    }

    private Usuario getUsuario() {
        final String nome = editTextNome.getText().toString();
        final String sobrenome = editTextSobrenome.getText().toString();
        final String email = editTextEmail.getText().toString();
        final String senha = editTextSenha.getText().toString();

        return new Usuario(nome, sobrenome, email, senha);
    }

    private void validarFormulario() {

    }
}
