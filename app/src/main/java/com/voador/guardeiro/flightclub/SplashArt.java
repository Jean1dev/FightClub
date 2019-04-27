package com.voador.guardeiro.flightclub;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import testes.UnitTests;

public class SplashArt extends AppCompatActivity {

    private static int SPLAH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_art);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                UnitTests test = new UnitTests(getApplicationContext());
                test.test_insert_usuario();
                test.test_getall_usuario();
            }
        }, SPLAH_TIME_OUT);
    }
}
