package com.voador.guardeiro.flightclub.activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.infrastructure.ApiService;
import com.voador.guardeiro.flightclub.infrastructure.repositories.UsuarioRepository;
import com.voador.guardeiro.flightclub.models.Aluno;
import com.voador.guardeiro.flightclub.services.AlunoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    private EditText emailInput;
    private EditText senhaInput;
    private Button btnLogin;
    private String email;
    private String senha;
    private AlunoService alunoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.show);
        mp.start();

        alunoService = new ApiService().getAlunoService();

        buscarAlunos();

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
        if (login()) {
            registrarLogin();
            goTo(MainActivity.class);
            finish();
        } else {
            showToast("E-mail ou senha inválidos");
        }

    }

    public void onClickRegistrarUsuario(View view) {
        goTo(RegistrationActivity.class);
    }

    private void registrarLogin() {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("login", true);
    }

    private void buscarAlunos() {
        alunoService.buscarAlunos(20).enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {
                for (final Aluno aluno : response.body()) {
                    showToast(aluno.getNome());
                }
            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                showToast("Ocorreu um erro");
            }
        });
    }

}
