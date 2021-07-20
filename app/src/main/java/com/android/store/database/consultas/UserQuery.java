package com.android.store.database.consultas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class UserQuery {


    public static int insertUser(SQLiteDatabase db, String nombre, String email, String clave ){


        int count = 0;
        Cursor cursor=db.rawQuery("SELECT count(*) FROM  user " + "WHERE email = '"+email+"'",null);
        if (cursor.moveToFirst()) {
            count = Integer.parseInt(cursor.getString(0));
        }
        cursor.close();

        if(count>0){


            return 1;
        }


        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("email", email);
        values.put("clave", clave);
        db.insert("user", null, values);

        return 0;
    }

    public static int validarQuery(SQLiteDatabase db, String email, String pass) {

        int count = 0;
        Cursor cursor=db.rawQuery("SELECT count(*) FROM  user " + "WHERE email = '"+email+"' AND  clave = '"+pass+"'",null);
        if (cursor.moveToFirst()) {
            count = Integer.parseInt(cursor.getString(0));
        }
        cursor.close();
        return count;
    }
}
