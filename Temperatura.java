package com.example.calculadoraaosytemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Temperatura extends AppCompatActivity {

    private EditText temperatura;
    private CheckBox kelvinBox;
    private CheckBox celsiusBox;
    private CheckBox farenBox;
    private Button kelvinButton;
    private Button celsiusButton;
    private Button farenButton;
    private TextView resultado;
    private String uCambio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        Intent intent = getIntent();

        resultado = findViewById(R.id.resultadoTemp);

        kelvinButton = findViewById(R.id.kelvinButton2);
        kelvinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uCambio = "K";
                convertir();
            }
        });

        celsiusButton = findViewById(R.id.celsiusButton2);
        celsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uCambio = "ºC";
                convertir();

            }
        });
        farenButton = findViewById(R.id.farenheitButton2);
        farenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uCambio = "ºF";
                convertir();

            }
        });

    }

    public void convertir() {

        temperatura = findViewById(R.id.tempInput);
        double numero = Integer.parseInt(temperatura.getText().toString());

        kelvinBox = findViewById(R.id.kelvinBox);
        boolean kelvin = kelvinBox.isChecked();
        celsiusBox = findViewById(R.id.celsiusBox);
        boolean celsius = celsiusBox.isChecked();
        farenBox = findViewById(R.id.farenheitBox);
        boolean faren = farenBox.isChecked();
        String unidad = "";
        if (kelvin == true) {
            unidad = "K";
        } else if (celsius == true) {
            unidad = "ºC";
        } else if (faren == true) {
            unidad = "ºF";
        }
        
        switch (unidad) {
            case "K":
                if (uCambio.equals("ºC")) {
                    numero = numero - 273.15;
                    resultado.setText(String.valueOf(numero) + "ºC");
                } else if (uCambio.equals("Fº")) {
                    numero = 1.8 * (numero - 273.15) + 32;
                    resultado.setText(String.valueOf(numero) + "Fº");
                } else if (uCambio.equals("K")) {
                    numero = numero;
                    resultado.setText(String.valueOf(numero) + "K");
                }
                break;

            case "ºC":
                if (uCambio.equals("ºC")) {
                    numero = numero;
                    resultado.setText(String.valueOf(numero) + "ºC");
                } else if (uCambio.equals("Fº")) {
                    numero = numero * 1.8 + 32;
                    resultado.setText(String.valueOf(numero) + "Fº");
                } else if (uCambio.equals("K")) {
                    numero += 273.15;
                    resultado.setText(String.valueOf(numero) + "K");
                }
                break;

            case "Fº":
                if (uCambio.equals("ºC")) {
                    numero = (numero - 32) / 1.8;
                    resultado.setText(String.valueOf(numero) + "ºC");
                } else if (uCambio.equals("Fº")) {
                    numero = numero;
                    resultado.setText(String.valueOf(numero) + "Fº");
                } else if (uCambio.equals("K")) {
                    numero = 5 / 9 * (numero - 32) + 273.15;
                    resultado.setText(String.valueOf(numero) + "K");
                }
                break;

            default:
                break;

        }

    }
}