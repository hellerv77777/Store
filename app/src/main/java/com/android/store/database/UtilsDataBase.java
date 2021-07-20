package com.android.store.database;

public class UtilsDataBase {

    public static final String SQL_CREATE_TABLE_USER =
            "CREATE TABLE user (id INTEGER PRIMARY KEY,nombre TEXT,email, clave TEXT)";

    public static final String SQL_CREATE_TABLE_CARRITO =
            "CREATE TABLE carrito (id INTEGER PRIMARY KEY,producto TEXT,usuario TEXT)";
}
