package com.example.doctorfinalprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        CardView schedule=findViewById(R.id.appointschedule);
        CardView cancel=findViewById(R.id.appointcancel);
         schedule.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(Admin.this,appsch.class));
             }
         });
         cancel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(Admin.this,AppointmentCancel.class));
             }
         });
         CardView Resch=findViewById(R.id.resch);
         Resch.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(Admin.this,RescheduleDate.class));
             }
         });
         CardView logout=findViewById(R.id.logadmin);
         logout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(Admin.this,LoginActivity.class));
             }
         });

    }
}