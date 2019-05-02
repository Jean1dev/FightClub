package com.voador.guardeiro.flightclub;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.show);
        mp.start();
    }
}
