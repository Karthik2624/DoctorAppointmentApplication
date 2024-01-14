package com.example.doctorfinalprojet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbmanager extends SQLiteOpenHelper
{
  //  private static final String dbname="patient";

    public dbmanager(@Nullable Context context)
    {

        super(context, "patient", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        //String qry="create table patient (  name TEXT primary key, contact TEXT , email TEXT)";
        sqLiteDatabase.execSQL("create table patient (  name TEXT primary key, contact TEXT , concern TEXT,date DATE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
      //  String qry="drop Table if exists patient";
        sqLiteDatabase.execSQL("drop Table if exists patient");

    }

    public  boolean addrecord(String name, String contact, String concern,String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("contact",contact);
        cv.put("concern",concern);
        cv.put("date",date);
        long res=db.insert("patient",null,cv);

        if(res==-1)
            return false;
        else
            return  true;

    }


    public  String updaterecord(String date,String newdate) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();


        cv.put("date",newdate);
        Cursor cursor = db.rawQuery("select * from patient where date= ?", new String[]{date});
        if (cursor.getCount() > 0) {
            long res = db.update("patient", cv, "date=?", new String[]{date});

            if (res == -1)
                return "Fai1led";
            else
                return "Successfully Updated";
        }else{
            return "Failed";
        }
    }

    public  String deleterecord(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from patient where name= ?", new String[]{name});
          if(cursor.getCount() > 0) {
              long res;
              res = db.delete("patient", " name = ?", new String[]{name});

              if (res == -1)
               return "Failed To Delete";
              else
                  return "Successfully Completed";
          }
   else {
       return "Patient Does Not Exist";
              }


    }




    public  Cursor getdata() {
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.rawQuery("select * from patient ORDER BY date", null);
       return cursor;
    }


}

