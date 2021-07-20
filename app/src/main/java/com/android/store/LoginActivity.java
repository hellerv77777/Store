package com.android.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.store.database.DataBase;
import com.android.store.database.consultas.UserQuery;

public class LoginActivity extends AppCompatActivity {


    private Button buttonRegistrar;
    private DataBase dataBase;
    private SQLiteDatabase db;
    private Button buttonLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRegistrar = findViewById(R.id.buttonRegistrar);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        dataBase = new DataBase(this);
        db = dataBase.getWritableDatabase();

        getSupportActionBar().hide();

        buttonRegistrar.setOnClickListener(v -> startActivity(new Intent(this,RegistroActivity.class)));

        buttonLogin.setOnClickListener(v -> {

            if(editTextEmail.getText().toString().isEmpty()){

                Toast.makeText(this, "Ingresa tu email", Toast.LENGTH_SHORT).show();
                return;
            }

            if(editTextPassword.getText().toString().isEmpty()){

                Toast.makeText(this, "Ingresa tu contraseña", Toast.LENGTH_SHORT).show();
                return;
            }

            int conteoUser = UserQuery.validarQuery(db,editTextEmail.getText().toString(),editTextPassword.getText().toString());

            if(conteoUser==0){

                Toast.makeText(this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_SHORT).show();

                return;
            }
            //Se guarda en una preferencia el email como session
            Preferencias.saveLogin(this,editTextEmail.getText().toString());

            startActivity(new Intent(this,InicioActivity.class));
            finish();

        });

    }
}