package com.voador.guardeiro.flightclub;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import database.model.Persistence.UsuarioPersistence;
import database.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private EditText emailInput;
    private EditText senhaInput;
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

        email = emailInput.getText().toString();
        senha = senhaInput.getText().toString();
    }

    private boolean login(){
        return !new UsuarioPersistence(getApplicationContext()).whereEmail(email).isEmpty();
    }

}
