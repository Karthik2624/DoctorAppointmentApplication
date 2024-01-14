package com.example.doctorfinalprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
EditText  username,password;
Button login;

TextView register;
//initilizing the drop down box
String[] item={"Doctor","Admin"};
AutoCompleteTextView autoCompleteTextView;
ArrayAdapter<String> adapterItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.regusername);
        password=findViewById(R.id.regpassword2);
        login=findViewById(R.id.registerbuttton);
        register=findViewById(R.id.register);

        autoCompleteTextView=findViewById(R.id.auto_complete);
        adapterItems=new ArrayAdapter<String>(this,R.layout.list_file,item);


        autoCompleteTextView.setAdapter(adapterItems);

        final String[] items = new String[1];

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l){
                items[0] =adapterView.getItemAtPosition(i).toString();
                Toast.makeText(LoginActivity.this, ""+items[0], Toast.LENGTH_SHORT).show();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = username.getText().toString();
                String Password = password.getText().toString();
                Database db=new Database(getApplicationContext(),"userdb",null,1);
                if (username.length() == 0 || password.length() == 0 ) {
                    Toast.makeText(LoginActivity.this, "Missing either username or password", Toast.LENGTH_SHORT).show();
                } else {
                    //extracting data from database and checking

                  if (items[0]=="Doctor") {
                      if (db.login(Username, Password) == 1) {
                          Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                          SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                          SharedPreferences.Editor editor = sharedpreferences.edit();
                          editor.putString("username", Username);
                          //to save the data with help of key and value
                          editor.apply();
                          //startActivity(new Intent(LoginActivity.this, Home-activity.class));
                          Intent intent = new Intent(LoginActivity.this, Homeactivity.class);
                          startActivity(intent);
                      } else {
                          Toast.makeText(getApplicationContext(), "invalid user name or password", Toast.LENGTH_SHORT).show();
                      }
                  }
                  else{
                      if (db.login(Username, Password) == 1) {
                          Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                          SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                          SharedPreferences.Editor editor = sharedpreferences.edit();
                          editor.putString("username", Username);
                          //to save the data with help of key and value
                          editor.apply();
                          //startActivity(new Intent(LoginActivity.this, Home-activity.class));
                          Intent intent = new Intent(LoginActivity.this, Admin.class);
                          startActivity(intent);
                      } else {
                          Toast.makeText(getApplicationContext(), "invalid user name or password", Toast.LENGTH_SHORT).show();
                      }
                  }


                  // startActivity(new Intent(LoginActivity.this, Homeactivity.class));
                }
            }
        });
         register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //to go from login to register form
                 startActivity(new Intent(LoginActivity.this,RegisterActivity2.class));
             }
         });
    }
}