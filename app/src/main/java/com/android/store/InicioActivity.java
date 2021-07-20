package com.android.store;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonDelantales;
    private Button buttonManteleria;
    private Button buttonIndividual;
    private Button buttonTapiceria;
    private Button buttonAcerca;
    private Button buttonConctacto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        buttonDelantales = findViewById(R.id.buttonDelantales);
        buttonManteleria = findViewById(R.id.buttonManteleria);
        buttonIndividual = findViewById(R.id.buttonIndividual);
        buttonTapiceria = findViewById(R.id.buttonTapiceria);
        buttonAcerca = findViewById(R.id.buttonAcerca);
        buttonConctacto = findViewById(R.id.buttonConctacto);

        buttonDelantales.setOnClickListener(this);
        buttonManteleria.setOnClickListener(this);
        buttonIndividual.setOnClickListener(this);
        buttonTapiceria.setOnClickListener(this);
        buttonAcerca.setOnClickListener(this);
        buttonConctacto.setOnClickListener(this);



    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){

            case R.id.buttonDelantales:
                intent = new Intent(this,ProductosActivity.class);
                intent.putExtra("categoria","delantales");
                startActivity(intent);
            break;

            case R.id.buttonManteleria:
                intent = new Intent(this, ProductosActivity.class);
                intent.putExtra("categoria","manteleria");
                startActivity(intent);
                break;

            case R.id.buttonIndividual:
                intent = new Intent(this, ProductosActivity.class);
                intent.putExtra("categoria","individual");
                startActivity(intent);
            break;
            case R.id.buttonTapiceria:
                intent = new Intent(this, ProductosActivity.class);
                intent.putExtra("categoria","tapiceria");
                startActivity(intent);
            break;
            case R.id.buttonAcerca:
                intent = new Intent(this, AcercaDeActivity.class);
                startActivity(intent);
            break;
            case R.id.buttonConctacto:
                intent = new Intent(this, ConctactoActivity.class);
                startActivity(intent);
            break;
        }
    }
}