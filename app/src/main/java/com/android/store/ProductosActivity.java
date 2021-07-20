package com.android.store;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.android.store.database.DataBase;
import com.android.store.database.consultas.ProductosQuery;
import java.util.List;

public class ProductosActivity extends AppCompatActivity implements ProductoListener {

    private RecyclerView recyclerProductos;
    private MyProductosRecyclerViewAdapter mAdapter;
    private SQLiteDatabase db;
    private DataBase dataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        dataBase = new DataBase(this);
        db = dataBase.getWritableDatabase();

        String categoria = getIntent().getExtras().getString("categoria");
        this.setTitle(categoria.toUpperCase());
        List<ProductoBean> listaProductos = Productos.getProductosPorCategoria(categoria);

        mAdapter = new MyProductosRecyclerViewAdapter(listaProductos,this);
        recyclerProductos = findViewById(R.id.recyclerProductos);
        recyclerProductos.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerProductos.setLayoutManager(gridLayoutManager);
        recyclerProductos.setAdapter(mAdapter);
    }

    @Override
    public void onClickAddProduct(ProductoBean productoBean) {


       int respuesta =  ProductosQuery.insertProduct(db,productoBean.getProductName(), Preferencias.getUser(this));
       if(respuesta>0){

           AlertDialog.Builder builder = new AlertDialog.Builder(this);
           builder.setTitle(R.string.acerca)
                   .setMessage("Producto ya esta en el carrito")
                   .setPositiveButton("Ok",null).create().show();

           return;
       }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.acerca)
                .setMessage("Producto agregado al carrito")
                .setPositiveButton("Ok",null).create().show();

    }

    @Override
    public void OnClickDeleteProducto(String string) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){

            onBackPressed();
            return true;
        }
        if (item.getItemId() == R.id.action_settings) {

                //Abre el carrito
                CarritoFragment carritoFragment = new CarritoFragment();
                carritoFragment.show(getSupportFragmentManager(),"carrito");

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}