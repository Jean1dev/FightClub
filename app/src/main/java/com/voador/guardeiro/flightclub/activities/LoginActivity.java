package com.voador.guardeiro.flightclub.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.infrastructure.repositories.UsuarioRepository;

public class LoginActivity extends AppCompatActivity {

    private EditText emailInput;
    private EditText senhaInput;
    private Button btnLogin;
    private String email;
    private String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.show);
        mp.start();

        emailInput = findViewById(R.id.input_email);
        senhaInput = findViewById(R.id.input_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private boolean login() {
        UsuarioRepository test = new UsuarioRepository(getApplicationContext());
        test.whereEmail(email);
        return !new UsuarioRepository(getApplicationContext()).whereEmail(email).isEmpty();
    }

    private void handleLogin() {
        email = emailInput.getText().toString();
        senha = senhaInput.getText().toString();
        if(login()){
            registarLogin();
            irParaCadastro();
        }

        Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show();
    }

    public void irParaCadastro() {
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    public void registarLogin() {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("login", true);
    }

}
