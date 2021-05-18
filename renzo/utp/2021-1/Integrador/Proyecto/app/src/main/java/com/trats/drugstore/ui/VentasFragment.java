package com.trats.drugstore.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trats.drugstore.R;
import com.trats.drugstore.adapters.ProductoAdapter;
import com.trats.drugstore.adapters.VentaAdapter;
import com.trats.drugstore.models.Producto;
import com.trats.drugstore.models.Venta;

import java.util.ArrayList;

public class VentasFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView rvVentas;
    private VentaAdapter ventaAdapter;
    private ArrayList<Venta> listaVentas;

    public VentasFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ventas, container, false);
        rvVentas = root.findViewById(R.id.rvVentas);
        rvVentas.setLayoutManager(new LinearLayoutManager(getContext()));
        ventaAdapter = new VentaAdapter(getActivity());
        rvVentas.setAdapter(ventaAdapter);
        listaVentas = new ArrayList<>();
        listaVentas.add(new Venta(1,82312311,"17/05/2021",500,"av. RERERERERE","Visa"));
        listaVentas.add(new Venta(2,82312312,"16/05/2021",400,"av. RARARARARA","Visa"));
        listaVentas.add(new Venta(3,82312313,"15/05/2021",300,"av. RQRQRQRQRQ","Mastercard"));
        ventaAdapter.agregarVentas(listaVentas,1);

        return root;
    }

    public static VentasFragment newInstance(String param1, String param2) {
        VentasFragment fragment = new VentasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }
}