package com.voador.guardeiro.flightclub;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import utils.CustomDatePicker;

public class MatriculaActivity extends AppCompatActivity {

    private ListView listaMatriculas;
    private Button btnSalvar;
    private EditText editTextodigoAluno;
    private TextView txtDiaInicio;
    private TextView txtDiaVenc;
    private Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_matricula);


        //receber do banco todas modalidades
        String[] modalidades = new String[]{
                "Guardeiro",
                "Voador",
                "Chute no saco"
        };

        listaMatriculas = findViewById(R.id.listViewMatricula);
        btnSalvar = findViewById(R.id.btnSalvarMatricula);
        editTextodigoAluno = findViewById(R.id.txtCodigoAluno);
        txtDiaInicio = findViewById(R.id.dataInicio);
        txtDiaVenc = findViewById(R.id.diaVencimento);

        ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, modalidades);
        listaMatriculas.setAdapter(array);


    }

    public void novaData(final View view) {
//        int id = view.getId();
//        DialogFragment newFragment = new CustomDatePicker();
//        newFragment.show(getFragmentManager(),"Date Picker");

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker viewDate, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(view);
            }

        };

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(MatriculaActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel(View view) {

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, new Locale("pt", "BR"));
        int id = view.getId();

        if (id == R.id.btnVencimento) {
            txtDiaVenc.setText(sdf.format(myCalendar.getTime()));
        } else if (id == R.id.btnInicio) {
            txtDiaInicio.setText(sdf.format(myCalendar.getTime()));

        }

    }

    public void buscarCodigoAluno(View view) {
        //return !new UsuarioPersistence(getApplicationContext()).whereEmail(email).isEmpty();
    }

//    private boolean login() {
//        return !new UsuarioPersistence(getApplicationContext()).whereEmail(email).isEmpty();
//    }

}
