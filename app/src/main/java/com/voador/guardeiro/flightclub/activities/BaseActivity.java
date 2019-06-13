package com.voador.guardeiro.flightclub.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

abstract public class BaseActivity extends AppCompatActivity {

    protected static final long DEFAULT_CONTA_ID = 22;

    protected void
    goTo(Class<?> toActivity) {
        startActivity(new Intent(this, toActivity));
    }

    protected void goToClearStack(Class<?> toActivity) {
        Intent intent = new Intent(this, toActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void showSuccessMessage(String text) {
        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Sucesso")
                .setContentText(text)
                .show();
    }

    protected void showErrorMessage(String text) {
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Erro ao remover")
                .setContentText(text)
                .show();
    }

    protected void showErrorMessage(String title, String text) {
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)
                .setContentText(text)
                .show();
    }


}
