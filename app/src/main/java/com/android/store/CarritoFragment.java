package com.android.store;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.store.database.DataBase;
import com.android.store.database.consultas.ProductosQuery;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class CarritoFragment extends BottomSheetDialogFragment  implements ProductoListener{

    private SQLiteDatabase db;
    private DataBase dataBase;
    private View view;
    private MyCarritoRecyclerViewAdapter mAdapter;
    private RecyclerView recyclerCarrito;

    public CarritoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_carrito, container, false);
        dataBase = new DataBase(requireContext());
        db = dataBase.getWritableDatabase();
        recyclerCarrito =view.findViewById(R.id.recyclerCarrito);
        //Se obtiene los productos agregados al carrito de la session
        List<String> listaCarrito = ProductosQuery.getCarrito(db,Preferencias.getUser(requireContext()));

        mAdapter = new MyCarritoRecyclerViewAdapter(listaCarrito,this);

        recyclerCarrito.setHasFixedSize(true);
        LinearLayoutManager linearLayout = new LinearLayoutManager(requireContext());
        recyclerCarrito.setLayoutManager(linearLayout);
        recyclerCarrito.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onClickAddProduct(ProductoBean productoBean) {

    }

    @Override
    public void OnClickDeleteProducto(String producto) {

        ProductosQuery.deleteProducto(db,Preferencias.getUser(requireContext()),producto);
        mAdapter.removeItem(producto);

    }
}