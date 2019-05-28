package com.voador.guardeiro.flightclub.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    protected void goTo(Class<?> toActivity) {
        startActivity(new Intent(this, toActivity));
    }


    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
