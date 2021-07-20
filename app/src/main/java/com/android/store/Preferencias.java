package com.android.store;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {


    public static void saveLogin(Context context,String user){

        SharedPreferences sharedPref = context.getSharedPreferences("DATA",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("sesion",user);
        editor.apply();
    }

    public static String getUser(Context context) {

        SharedPreferences sharedPref = context.getSharedPreferences("DATA",Context.MODE_PRIVATE);
        return sharedPref.getString("sesion","");
    }
}
