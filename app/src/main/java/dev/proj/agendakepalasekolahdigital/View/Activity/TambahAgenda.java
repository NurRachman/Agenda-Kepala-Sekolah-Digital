package dev.proj.agendakepalasekolahdigital.View.Activity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;

import java.util.Calendar;

import dev.proj.agendakepalasekolahdigital.R;

public class TambahAgenda extends AppCompatActivity {

    private int mYear, mMonth, mDay, mHour, mMinute;
    private Calendar calendar;
    EditText agendaTanggal, agendaJam, alarmAgenda;
    Switch switchAlrm;
    Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_agenda);

        getSupportActionBar().setTitle("Tambah Agenda");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        mHour = calendar.get(Calendar.HOUR_OF_DAY);
        mMinute = calendar.get(Calendar.MINUTE);

        agendaTanggal = findViewById(R.id.agendaTanggal);
        agendaJam = findViewById(R.id.agendaJam);
        alarmAgenda = findViewById(R.id.alarmAgenda);
        switchAlrm = findViewById(R.id.switchAlrm);
        simpan = findViewById(R.id.simpan);

        initMethod();
    }
    private void initMethod(){
        agendaTanggal.setOnClickListener(v -> showDialogDate());
        agendaJam.setOnClickListener(v -> showDialogTime(agendaJam));
        switchAlrm.setOnCheckedChangeListener((buttonView, isChecked) -> {
            alarmAgenda.setClickable(isChecked);
            alarmAgenda.setEnabled(isChecked);
            alarmAgenda.setFocusable(isChecked);
        });
        alarmAgenda.setOnClickListener(v -> showDialogTime(alarmAgenda));
        simpan.setOnClickListener(v -> finish());
    }

    private void showDialogDate(){
        @SuppressLint("DefaultLocale") DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year, monthOfYear, dayOfMonth) -> agendaTanggal.setText(String.format("%d-%d-%d", dayOfMonth, monthOfYear + 1, year)), mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    private void showDialogTime(EditText editText){
        @SuppressLint("DefaultLocale") TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minute) -> editText.setText(String.format("%d:%d", hourOfDay, minute)), mHour, mMinute, false);
        timePickerDialog.show();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
