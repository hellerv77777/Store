package com.android.store;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class MyProductosRecyclerViewAdapter extends RecyclerView.Adapter<MyProductosRecyclerViewAdapter.ViewHolder> {

    private final List<ProductoBean> mValues;
    private ProductoListener mListener;

    public MyProductosRecyclerViewAdapter(List<ProductoBean> items,ProductoListener mListener) {
        mValues = items;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textName.setText(mValues.get(position).getProductName());
        holder.textPrice.setText(String.valueOf(mValues.get(position).getProductPrice()));
        holder.imageViewProduct.setBackgroundResource(mValues.get(position).getProductImage());


        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.onClickAddProduct(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textPrice;
        public final TextView textName;
        public final Button addToCart;
        public final ImageView imageViewProduct;
        public ProductoBean mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            addToCart=view.findViewById(R.id.buttonAddToCart);
            imageViewProduct=view.findViewById(R.id.imageViewProduct);
            textPrice = (TextView) view.findViewById(R.id.textPrice);
            textName = (TextView) view.findViewById(R.id.textName);
        }

    }
}