package utils;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.voador.guardeiro.flightclub.R;

import java.util.Calendar;

@SuppressLint("ValidFragment")
public class CustomDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    private TextView txtView;

    @SuppressLint("ValidFragment")
    public CustomDatePicker(TextView ao_view) {
        txtView = ao_view;
    }

       @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current date as the default date in the date picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }
    public void onDateSet(DatePicker view, int year, int month, int day) {

        txtView.setText(day + "/" + month + "/" + year);
    }
}
