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

import com.squareup.picasso.Picasso;
import com.trats.drugstore.R;
import com.trats.drugstore.models.Producto;

import java.util.ArrayList;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.ViewHolder>{
    Context context;
    ArrayList<Producto> listaProductos;

    public StockAdapter(Context context) {
        this.context = context;
        listaProductos = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.stockprod_card,parent, false);
        return new StockAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Producto producto = listaProductos.get(position);
        Picasso.with(context).load(producto.getImagen()).fit().centerInside().into(holder.ivStock);
        holder.tvNombreStock.setText(producto.getNombre());
        holder.tvDescripcionStock.setText(producto.getDescripcion());
        holder.tvPrecioStock.setText(String.valueOf(producto.getPrecio()));
        holder.btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivStock;
        TextView tvNombreStock, tvDescripcionStock, tvPrecioStock;
        Button btnActualizar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivStock= itemView.findViewById(R.id.ivStock);
            tvNombreStock= itemView.findViewById(R.id.tvNomStock);
            tvDescripcionStock= itemView.findViewById(R.id.tvDescStock);
            tvPrecioStock= itemView.findViewById(R.id.tvPrecioStock);
            btnActualizar= itemView.findViewById(R.id.btnStock);
        }
    }
    public void agregarProductosStock(ArrayList<Producto> listaProds, ArrayList<Stock>){
        listaProductos.clear();
        listaProductos.addAll(listaProds);
        notifyDataSetChanged();
    }

}
