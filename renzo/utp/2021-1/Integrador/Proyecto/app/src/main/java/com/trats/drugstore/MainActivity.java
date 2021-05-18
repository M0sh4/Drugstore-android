package com.trats.drugstore;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.trats.drugstore.ui.CarritoFragment;
import com.trats.drugstore.ui.home.HomeFragment;

import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Menu menu;
    private View header;
    private FragmentManager fm = getSupportFragmentManager();
    private SharedPreferences preferences;
    private TextView tvNombreUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
                navController.navigate(R.id.nav_carrito);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        preferences = getSharedPreferences("trats", Context.MODE_PRIVATE);

        header = navigationView.getHeaderView(0);
        tvNombreUsuario = header.findViewById(R.id.tvNombUsu);
        tvNombreUsuario.setText(preferences.getString("usuario",""));
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        menu = navigationView.getMenu();
        int cargo = preferences.getInt("tipoUsuario", 0);

        MenuItem logout = menu.findItem(R.id.nav_cerrarsesion);
        MenuItem micuenta = menu.findItem(R.id.nav_account);
        MenuItem productos = menu.findItem(R.id.nav_productos);
        MenuItem inventario = menu.findItem(R.id.nav_inventario);
        MenuItem ventas = menu.findItem(R.id.nav_ventas);
        MenuItem compras = menu.findItem(R.id.nav_compras);
        MenuItem login = menu.findItem(R.id.nav_iniciarsesion);
        if(!preferences.getString("usuario","").equals("")){
            logout.setVisible(true);
            login.setVisible(false);
            navigationView.getHeaderView(0).setVisibility(View.VISIBLE);
            if(cargo == 1){
                micuenta.setVisible(true);
                productos.setVisible(true);
                inventario.setVisible(false);
                ventas.setVisible(false);
                compras.setVisible(true);
            } else if(cargo == 2){
                micuenta.setVisible(false);
                productos.setVisible(true);
                inventario.setVisible(true);
                ventas.setVisible(true);
                compras.setVisible(false);
            }

        }else{
            logout.setVisible(false);
            login.setVisible(true);
            micuenta.setVisible(false);
            productos.setVisible(false);
            inventario.setVisible(false);
            ventas.setVisible(false);
            compras.setVisible(false);
            navigationView.getHeaderView(0).setVisibility(View.GONE);
            navigationView.setPadding(0,45,0,0);
        }
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_account, R.id.nav_productos, R.id.nav_inventario, R.id.nav_ventas
                , R.id.nav_compras, R.id.nav_contacto, R.id.nav_boticas, R.id.nav_carrito)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        login.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Intent login = new Intent(MainActivity.this, LoginActivity.class);
                SharedPreferences.Editor editor = getSharedPreferences("trats", Context.MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();
                startActivity(login);
                finish();
                return false;
            }
        });
        logout.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent logout = new Intent(MainActivity.this, LoginActivity.class);
                SharedPreferences.Editor editor = getSharedPreferences("trats", Context.MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();
                startActivity(logout);
                finish();
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}