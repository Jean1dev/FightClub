package com.voador.guardeiro.flightclub;

import android.content.Intent;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import database.model.Persistence.UsuarioPersistence;


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

        emailInput = (EditText) findViewById(R.id.input_email);
        senhaInput = (EditText) findViewById(R.id.input_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private boolean login(){
        UsuarioPersistence test = new UsuarioPersistence(getApplicationContext());
        test.whereEmail(email);
        return !new UsuarioPersistence(getApplicationContext()).whereEmail(email).isEmpty();
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
        TextView tv = (TextView) findViewById(R.id.link_signup);
        startActivity(new Intent(this, RegistrationActivity.class));

    }

    public void registarLogin() {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("login", true);
    }

}
