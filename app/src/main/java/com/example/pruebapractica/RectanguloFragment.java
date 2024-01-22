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
Clase: Fragment que calcula el área del rectángulo.
*/

public class RectanguloFragment extends Fragment {

    private Button btnCalculo;
    private EditText etBase;
    private EditText etAltura;

    public RectanguloFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_rectangulo, container, false);

        // Instancia componentes de la interfaz
        etBase = (EditText)view.findViewById(R.id.editTextBase);
        etAltura = (EditText)view.findViewById(R.id.editTextAltura);
        btnCalculo = (Button) view.findViewById(R.id.btnCalculo);
        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double base = 0;
                double altura = 0;
                double result = 0;
                if (!etBase.getText().toString().isEmpty() && !etAltura.getText().toString().isEmpty()) {
                    base = Float.parseFloat(etBase.getText().toString());
                    altura = Float.parseFloat(etAltura.getText().toString());
                    result = base * altura;
                }
                Snackbar.make(view, getString(R.string.frag2_sb_text) + " " + String.valueOf(result),Snackbar.LENGTH_LONG).show();
            }
        });

        return view;
    }
}