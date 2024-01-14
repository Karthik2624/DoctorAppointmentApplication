package com.example.doctorfinalprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Homeactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

       SharedPreferences sp=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=sp.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "welcome DR "+username, Toast.LENGTH_SHORT).show();

        CardView exit=findViewById(R.id.docappoint4);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sp.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(Homeactivity.this,LoginActivity.class));
            }
        });
      CardView appointment=findViewById(R.id.appointdetails);
      appointment.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(Homeactivity.this,DisplayPatientAppointmentDetails.class));
          }
      });

      CardView complete=findViewById(R.id.docappoint1);
      complete.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(Homeactivity.this,AppointmentComplete.class));
          }
      });

      CardView reschdule=findViewById(R.id.rescheduledate);
      reschdule.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(Homeactivity.this,RescheduleDate.class));
          }
      });
    }
}