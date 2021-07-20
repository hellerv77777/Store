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

public class RegistroActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText pass;
    private EditText passConfirm;
    private Button buttonBack;
    private Button buttonRegistrarme;
    private SQLiteDatabase db;
    private DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);



        setUp();

        buttonBack.setOnClickListener(v -> {

        });
        buttonRegistrarme.setOnClickListener(v -> registarUsuario());

    }

    private void registarUsuario() {

        if(editTextName.getText().toString().isEmpty()){

            editTextName.setError("Ingrese dato");
            return;
        }

        if(editTextEmail.getText().toString().isEmpty()){

            editTextEmail.setError("Ingrese dato");
            return;
        }

        if(pass.getText().toString().isEmpty()){

            pass.setError("Ingrese dato");
            return;
        }
        if(passConfirm.getText().toString().isEmpty()){

            passConfirm.setError("Ingrese dato");
            return;
        }

        if(!pass.getText().toString().equals(passConfirm.getText().toString())){

            pass.setError("Contraseñas no son iguales");
            passConfirm.setError("Contraseñas no son iguales");
            return;
        }

       int respuesta = UserQuery.insertUser(
            db,
            editTextName.getText().toString(),
            editTextEmail.getText().toString(),
            pass.getText().toString()
        );

        if(respuesta==1){

            Toast.makeText(this, "Email ya esta registrado", Toast.LENGTH_SHORT).show();
            return;
        }
        //Se guarda en una preferencia el email como session
        Preferencias.saveLogin(this,editTextEmail.getText().toString());

        startActivity(new Intent(this,InicioActivity.class));
        finish();

    }

    private void setUp() {
        dataBase = new DataBase(this);
        db = dataBase.getWritableDatabase();


        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        pass = findViewById(R.id.editTextPassword);
        passConfirm = findViewById(R.id.editTextPasswordConfirm);
        buttonRegistrarme = findViewById(R.id.registrarme);
        buttonBack = findViewById(R.id.buttonBack);

    }
}