package com.trats.drugstore.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trats.drugstore.R;
import com.trats.drugstore.adapters.VentaAdapter;
import com.trats.drugstore.models.Venta;

import java.util.ArrayList;

public class ComprasFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView rvCompras;
    private VentaAdapter compraAdapter;
    private ArrayList<Venta> listaCompras;

    public ComprasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_compras, container, false);
        rvCompras = root.findViewById(R.id.rvCompras);
        rvCompras.setLayoutManager(new LinearLayoutManager(getContext()));
        compraAdapter = new VentaAdapter(getActivity());
        rvVentas.setAdapter(ventaAdapter);
        listaVentas = new ArrayList<>();
        listaVentas.add(new Venta(1,82312311,"17/05/2021",500,"av. RERERERERE","Visa"));
        listaVentas.add(new Venta(2,82312312,"16/05/2021",400,"av. RARARARARA","Visa"));
        listaVentas.add(new Venta(3,82312313,"15/05/2021",300,"av. RQRQRQRQRQ","Mastercard"));
        compraAdapter.agregarVentas(listaVentas);

        return root;
    }

    public static ComprasFragment newInstance(String param1, String param2) {
        ComprasFragment fragment = new ComprasFragment();
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