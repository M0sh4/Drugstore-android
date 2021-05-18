package com.trats.drugstore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trats.drugstore.R;
import com.trats.drugstore.models.Producto;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder>{
    Context context;
    ArrayList<Producto> listaProductos;

    public ProductoAdapter(Context context) {
        this.context = context;
        listaProductos = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.producto_card,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Producto obj = listaProductos.get(position);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivProducto;
        TextView tvNombre, tvDescripcion, tvOferta, tvPrecio;
        Button btnAgregar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProducto= itemView.findViewById(R.id.ivProducto);
            tvNombre= itemView.findViewById(R.id.tvNomProd);
            tvDescripcion= itemView.findViewById(R.id.tvDescProd);
            tvOferta= itemView.findViewById(R.id.tvOfertaProd);
            tvPrecio= itemView.findViewById(R.id.tvPrecioProd);
            btnAgregar= itemView.findViewById(R.id.btnAgregarProd);
        }
    }

    public void agregarElementos(ArrayList<Producto> listaProds){
        listaProductos.clear();
        listaProductos.addAll(listaProds);
        notifyDataSetChanged();
    }
}
