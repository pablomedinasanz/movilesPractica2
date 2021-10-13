package com.example.calculadoraaosytemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AniosBisiestos extends AppCompatActivity {

    private EditText anio;
    private Button comprobar;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anios_bisiestos);

        Intent intent = getIntent();

        comprobar = findViewById(R.id.comprobarAñosButton);
        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobar();
            }
        });

    }

    public void comprobar() {

        anio = findViewById(R.id.anioInput);
        int numero = Integer.parseInt(anio.getText().toString());

        resultado = findViewById(R.id.resultadoAños);
        String muestra;

        if (numero % 4 == 0) {
            muestra = "El año es bisiesto";
            resultado.setText(muestra);
        } else {
            muestra = "El año no es bisiesto";
            resultado.setText(muestra);
        }


    }
}