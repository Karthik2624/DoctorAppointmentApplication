package com.example.doctorfinalprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayPatientAppointmentDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name;
    ArrayList<String> contact;
    ArrayList<String> concern;
    ArrayList<String>  date;
    dbmanager db;
    myadapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_patient_appointment_details);

        db=new dbmanager(this);
        name=new ArrayList<String>();
        contact=new ArrayList<String>();
        concern=new ArrayList<String>();
        date=new ArrayList<String>();
        recyclerView=findViewById(R.id.recview);
        adapter=new myadapter(this,name,contact,concern,date);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }
    private void displaydata(){
        Cursor cursor=db.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(DisplayPatientAppointmentDetails.this, "no entery exists", Toast.LENGTH_SHORT).show();
            return ;
        }else {
            while (cursor.moveToNext()){
                name.add(cursor.getString(0));
                contact.add(cursor.getString(1));
                concern.add(cursor.getString(2));
                date.add(cursor.getString(3));
            }
        }
    }
}






/*        recyclerView=(RecyclerView) findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=new dbmanager(this).readalldata();
        dataholder=new ArrayList<>();

        while(cursor.moveToNext())
        {
            model obj=new model(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            dataholder.add(obj);
        }

        myadapter  adapter=new myadapter(dataholder);
        recyclerView.setAdapter(adapter);
    }
*/