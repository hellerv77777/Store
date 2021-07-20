package com.android.store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.android.store.R;

public class ConctactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conctacto);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.setTitle("Contacto");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){

            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}