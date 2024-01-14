package com.example.doctorfinalprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RescheduleDate extends AppCompatActivity{
    TextView olddate, date;

    Button sbmt,sbtoldate,sbtnewdate;
    dbmanager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reschedule_date);

        olddate= findViewById(R.id.olddatetext1);
        sbtnewdate=findViewById(R.id.newdate);
        sbtoldate=findViewById(R.id.olddate);

        date=findViewById(R.id.datetext1);

        sbmt = findViewById(R.id.sbmt_add);
        db=new dbmanager(this);
        sbtnewdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendate();
            }
        });
        sbtoldate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendate1();
            }
        });
        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String datetxt=olddate.getText().toString();

                String newdatetxt=date.getText().toString();


                String update=db.updaterecord(datetxt,newdatetxt);
                Toast.makeText(RescheduleDate.this, " "+update, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void opendate() {
        DatePickerDialog dialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                date.setText(String.valueOf(year)+"/"+String.valueOf(month+1)+"/"+String.valueOf(day));
            }
        }, 2022, 0, 15);
        dialog.show();
    }
    private void opendate1() {
        DatePickerDialog dialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                olddate.setText(String.valueOf(year)+"/"+String.valueOf(month+1)+"/"+String.valueOf(day));
            }
        }, 2022, 0, 15);
        dialog.show();
    }
}