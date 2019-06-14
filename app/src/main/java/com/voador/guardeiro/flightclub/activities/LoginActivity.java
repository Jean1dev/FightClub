package com.voador.guardeiro.flightclub.activities;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;
import com.voador.guardeiro.flightclub.R;
import com.voador.guardeiro.flightclub.infrastructure.repositories.UsuarioRepository;
import com.voador.guardeiro.flightclub.models.Usuario;
import com.voador.guardeiro.flightclub.retrofit.ApiService;
import com.voador.guardeiro.flightclub.retrofit.models.AlunoRetrofit;
import com.voador.guardeiro.flightclub.retrofit.services.AlunoService;

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

        //buscarTodos();

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

    private Usuario login(String email) {
        List<Usuario> users = new UsuarioRepository(getApplicationContext()).whereEmail(email);
        Usuario usuario = new Usuario();
        for (Usuario user : users) {
            if (user.getEmail().equals(email)) {
                usuario = user;
            }

        }
        return usuario;
    }

    private void handleLogin() {
        email = emailInput.getText().toString();
        senha = senhaInput.getText().toString();
        Usuario user;
        if (!email.equals("") && !senha.equals("")) {
            user = login(email);
            if (user != null && user.getSenha().equals(senha)) {

                registrarLogin();
                SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("Redirecionando");
                pDialog.setCancelable(false);
                pDialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        goToClearStack(MainActivity.class);
                    }
                }, 1000);

            } else {
                showErrorMessage("E-mail ou senha inválidos");
            }
        } else {
            showErrorMessage("E-mail ou senha inválidos");
        }
    }

    public void onClickRegistrarUsuario(View view) {
        goTo(RegistrationActivity.class);
    }

    private void registrarLogin() {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("login", true);
    }

    private void buscarAlunos() {
        alunoService.buscarAlunos(20).enqueue(new Callback<List<AlunoRetrofit>>() {
            @Override
            public void onResponse(Call<List<AlunoRetrofit>> call, Response<List<AlunoRetrofit>> response) {
                for (final AlunoRetrofit aluno : response.body()) {
                    System.out.print(aluno);

                    showToast("AlunoRetrofit:" + aluno.getId());
                }
            }

            @Override
            public void onFailure(Call<List<AlunoRetrofit>> call, Throwable t) {
                t.printStackTrace();
                showToast("Ocorreu um erro");
            }
        });
    }

}
