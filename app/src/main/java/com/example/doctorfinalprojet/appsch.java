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

public class appsch extends AppCompatActivity {
    EditText name, contact, concern;
   TextView date;
    Button sbmt,selectdate;
    dbmanager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appsch);

        name = findViewById(R.id.nametext);
        contact = findViewById(R.id.contacttext);
        concern =   findViewById(R.id.concerntext);
        date=findViewById(R.id.datetext);
        selectdate=findViewById(R.id.olddate);


        sbmt = findViewById(R.id.sbmt_add);
        db=new dbmanager(this);
        


       sbmt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              String nametxt=name.getText().toString();
              String contacttxt=contact.getText().toString();
              String concerntxt=concern.getText().toString();
              String datetxt=date.getText().toString();


              boolean checkinsertdata=db.addrecord(nametxt,contacttxt,concerntxt,datetxt);
              if(checkinsertdata==true){
                  Toast.makeText(appsch.this, "successfully Inserted", Toast.LENGTH_SHORT).show();
              }else {
                  Toast.makeText(appsch.this, "not Inserted", Toast.LENGTH_SHORT).show();
              }
           }
       });

       selectdate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               opendate();
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
    /*private void processinsert(String n, String c, String e)
    {
        String res=new dbmanager(this).addrecord(n,c,e);
        name.getEditText().setText("");
        contact.getEditText().setText("");
        email.getEditText().setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }*/

}