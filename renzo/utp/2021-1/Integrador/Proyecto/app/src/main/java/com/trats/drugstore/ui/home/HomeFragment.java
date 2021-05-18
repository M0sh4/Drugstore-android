package com.trats.drugstore.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.trats.drugstore.R;
import com.trats.drugstore.adapters.ProductoAdapter;
import com.trats.drugstore.models.Producto;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView rvProductos;
    private ProductoAdapter productoAdapter;
    private ArrayList<Producto> listaProductos;
    private Button btnRegCli;
    private SharedPreferences preferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        btnRegCli = root.findViewById(R.id.btnRegCli);
        rvProductos = root.findViewById(R.id.rvProductos);
        preferences = getContext().getSharedPreferences("trats", Context.MODE_PRIVATE);
        int cargo = preferences.getInt("tipoUsuario", 0);
        if(!preferences.getString("usuario","").equals("")){
            btnRegCli.setVisibility(View.GONE);
        }else{
            btnRegCli.setVisibility(View.VISIBLE);
        }
        rvProductos.setLayoutManager(new GridLayoutManager(getActivity(),2));
        productoAdapter = new ProductoAdapter(getActivity());
        rvProductos.setAdapter(productoAdapter);
        listaProductos = new ArrayList<>();
        listaProductos.add(new Producto(1,123,"Vacuna","gaaaaaaaaaaa","https://global.unitednations.entermediadb.net/assets/mediadb/services/module/asset/downloads/preset/Collections/Embargoed/18-12-2020-Biontech-COVID-19-vaccine.jpg/image1170x530cropped.jpg",
                12.5));
        listaProductos.add(new Producto(1,123,"Vacuna","gaaaaaaaaaaa","https://global.unitednations.entermediadb.net/assets/mediadb/services/module/asset/downloads/preset/Collections/Embargoed/18-12-2020-Biontech-COVID-19-vaccine.jpg/image1170x530cropped.jpg",
                12.5));
        listaProductos.add(new Producto(1,123,"Vacuna","gaaaaaaaaaaa","https://global.unitednations.entermediadb.net/assets/mediadb/services/module/asset/downloads/preset/Collections/Embargoed/18-12-2020-Biontech-COVID-19-vaccine.jpg/image1170x530cropped.jpg",
                12.5));
        productoAdapter.agregarProductos(listaProductos, cargo);
        btnRegCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_regcliente);
            }
        });
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}