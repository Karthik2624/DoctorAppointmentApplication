package com.example.doctorfinalprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity2 extends AppCompatActivity {
    EditText regusername,email,regpassword2,regpassword1;
    Button registerbutton;
    TextView existingaccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getting all the all values by their id
        setContentView(R.layout.activity_register2);
        regusername=findViewById(R.id.regusername);
        email=findViewById(R.id.email);
        regpassword1=findViewById(R.id.datetext);
        regpassword2=findViewById(R.id.regpassword2);
        registerbutton=findViewById(R.id.registerbuttton);
        existingaccount=findViewById(R.id.existingaccount);

        registerbutton.setOnClickListener(new View.OnClickListener() {
            //converting values into string
            @Override
            public void onClick(View v) {
                String run=regusername.getText().toString();
                String em=email.getText().toString();
                String pass=regpassword1.getText().toString();
                String confirm=regpassword2.getText().toString();
                Database db=new Database(getApplicationContext(),"userdb",null,1);
                if(run.length()==0 || em.length()==0 || pass.length()==0 || confirm.length()==0){
                    Toast.makeText(RegisterActivity2.this, "Enter all the details", Toast.LENGTH_SHORT).show();
                }else{
                    //this method is mainly for storing the data in the data base
                    if(pass.compareTo(confirm)==0){
                        if( isvalid(pass)){
                            db.register(run,em,pass);
                            Toast.makeText(RegisterActivity2.this, "Register Done", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity2.this,LoginActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity2.this, "password must contain at least one special symbol,Upper case letter and a number", Toast.LENGTH_SHORT).show();
                        }


                    }else{
                        Toast.makeText(RegisterActivity2.this, "Password and Confirm password dint Match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
         existingaccount.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(RegisterActivity2.this,LoginActivity.class));
             }
         });

    }
    public static boolean isvalid(String password){
        //checking password for its authenticity
        int f1=0,f2=0,f3=0;
        if(password.length()<8){
            return false;
        }else{
            for(int i=0;i<password.length();i++){
                if(Character.isLetter(password.charAt(i))){
                    f1=1;
                }
            }
            for(int i=0;i<password.length();i++){
                if(Character.isDigit(password.charAt(i))){
                    f2=1;
                }
            }
        }
        for(int i=0;i<password.length();i++){
           char c=password.charAt(i);
           if(c>=33&&c<=46||c==46){
               f3=1;
           }
        }
        if(f1==1 && f2==1 && f3==1)
            return true;
        return false;

    }
}