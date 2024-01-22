package com.example.pruebapractica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

/*
Autor: Juan Francisco Sánchez González
Fecha: 20/01/2024
Clase: Actividad que contiene un TabLayout para cambiar de fragmento. Se utilizan 2 fragmentos con 2 funcionalidades
distintas.
*/

public class MainActivity extends AppCompatActivity {

    private Fragment fCirculo;
    private Fragment fRectangulo;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciamos los 2 fragmentos y añadimos 1 de ellos a la Actividad
        fCirculo = new CirculoFragment();
        fRectangulo = new RectanguloFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, fCirculo).commit();

        // Componente TabLayout con 2 pestañas
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.arrow_down_float));
        tabLayout.addTab(tabLayout.newTab().setIcon(android.R.drawable.arrow_up_float));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        // Se reemplaza el fragment Circulo en la Actividad
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fCirculo).commit();
                        break;
                    case 1:
                        // Se reemplaza el fragment Rectángulo en la Actividad
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fRectangulo).commit();
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}