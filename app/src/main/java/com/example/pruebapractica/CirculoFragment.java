package com.example.pruebapractica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

/*
Autor: Juan Francisco Sánchez González
Fecha: 20/01/2024
Clase: Fragment que calcula el área del círculo.
*/

public class CirculoFragment extends Fragment {

    private Button btnCalculo;
    private EditText etRadio;

    public CirculoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_circulo, container, false);

        // Instancia componentes de la interfaz
        etRadio = (EditText)view.findViewById(R.id.editTextRadio);
        btnCalculo = (Button) view.findViewById(R.id.btnCalculo);
        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double radio = 0;
                double result = 0;
                if (!etRadio.getText().toString().isEmpty()) {
                    radio = Double.parseDouble(etRadio.getText().toString());
                    result = Math.PI * Math.pow(radio, 2);
                }
                Snackbar.make(view, getString(R.string.frag1_sb_text) + " " + String.valueOf(result),Snackbar.LENGTH_LONG).show();
            }
        });

        return view;
    }
}