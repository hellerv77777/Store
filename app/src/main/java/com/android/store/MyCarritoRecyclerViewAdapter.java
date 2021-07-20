package com.android.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyCarritoRecyclerViewAdapter extends RecyclerView.Adapter<MyCarritoRecyclerViewAdapter.ViewHolder> {

    private final List<String> mValues;
    private ProductoListener mListener;

    public MyCarritoRecyclerViewAdapter(List<String> items, ProductoListener mListener) {
        mValues = items;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_carrito, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textProducto.setText(mValues.get(position));

        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.OnClickDeleteProducto(holder.mItem);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void removeItem(String producto) {

        int index = mValues.indexOf(producto);
        mValues.remove(index);
        notifyItemRemoved(index);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public final Button eliminar;
        public final TextView textProducto;
        public String mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            eliminar=view.findViewById(R.id.buttonDelete);
            textProducto=view.findViewById(R.id.textProducto);
        }
    }
}