package com.example.doctorfinalprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AppointmentComplete extends AppCompatActivity {
    EditText patient;
    Button cancel;
    dbmanager db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_complete);

        patient=findViewById(R.id.patientname1);
        cancel=findViewById(R.id.cancel_button1);
        db =new dbmanager(this);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametext=patient.getText().toString();
                String res=db.deleterecord(nametext);

                Toast.makeText(getApplicationContext(),""+res,Toast.LENGTH_SHORT).show();

            }
        });
    }
}