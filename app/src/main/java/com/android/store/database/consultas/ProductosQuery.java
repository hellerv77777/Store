package com.android.store.database.consultas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProductosQuery {

    public static int insertProduct(SQLiteDatabase db, String productName, String usuario) {

        int count = 0;
        Cursor cursor=db.rawQuery("SELECT count(*) FROM  carrito " + "WHERE producto = '"+productName+"' AND  usuario = '"+usuario+"'",null);
        if (cursor.moveToFirst()) {
            count = Integer.parseInt(cursor.getString(0));
        }
        cursor.close();
        //Si es mayor a 0 el producto ya esta en el carrito
        if(count>0){

            return count;
        }
        //Si no, se inserta el producto al carrito
        ContentValues values = new ContentValues();
        values.put("producto", productName);
        values.put("usuario", usuario);
        db.insert("carrito", null, values);

        return count;
    }

    public static List<String> getCarrito(SQLiteDatabase db,String user) {

        List<String> productos = new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT producto FROM  carrito WHERE usuario = '"+user+"'",null);
        while (cursor.moveToNext()) {
            productos.add(cursor.getString(0));
        }
        cursor.close();

        return productos;
    }

    public static void deleteProducto(SQLiteDatabase db, String user, String producto) {
        db.execSQL("DELETE  FROM carrito WHERE producto = '"+producto+"' AND usuario = '"+user+"'");
    }
}
