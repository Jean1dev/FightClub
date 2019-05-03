package com.voador.guardeiro.flightclub;

import android.os.Bundle;
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

        editTextEmail = findViewById(R.id.edit_text_nome);
        editTextEmail = findViewById(R.id.edit_text_sobrenome);
        editTextEmail = findViewById(R.id.edit_text_email);
        editTextEmail = findViewById(R.id.edit_text_senha);
        btnCadastrar = findViewById(R.id.btn_cadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });
    }

    private void cadastrarUsuario() {
        new UsuarioPersistence();
        getUsuario();
    }

    private Usuario getUsuario() {
        final String nome = editTextNome.getText();
        final String sobrenome = editTextSobrenome.getText();
        final String email = editTextEmail.getText();
        final String senha = editTextSenha.getText();

        return new Usuario(nome, sobrenome, sobrenome, email, senha);
    }


}
