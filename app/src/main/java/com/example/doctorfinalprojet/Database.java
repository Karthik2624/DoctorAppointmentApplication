package com.example.doctorfinalprojet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {



    public Database(@Nullable Context context,@Nullable String name,@Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlLiteDatabase) {
        //this method is create a table for the users
        String qry1="create table users(username text,email text, password text)";
        sqlLiteDatabase.execSQL(qry1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void register(String username, String email, String password) {
        //values that entered in registration page ae being stored in the database called db.
        ContentValues cv =new ContentValues();
        cv.put("username", username);

        cv.put("email", email);

        cv.put("password", password);

        SQLiteDatabase db =getWritableDatabase();

       db.insert("users",null,cv);

        db.close();
    }
    public int login(String username,String password){
        //checking wheather entered password and user name match with the actual username and password
        int result = 0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c=db.rawQuery("select * from users where username=? and password=?",str);
        if(c.moveToFirst()){
            result = 1;
        }
        return result;
    }
}
