package com.example.calculadoratemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText temperatura;
    private Button unidadC;
    private Button unidadF;
    private Button unidadK;
    private Button transC;
    private Button transF;
    private Button transK;
    private TextView resultado;
    private String unidad;
    private String trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        temperatura = findViewById(R.id.temperatura);
        double temp = Double.parseDouble(temperatura.getText().toString());

        unidadC = findViewById(R.id.celsiusButton);
        unidadC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unidad = "ºC";
            }
        });

        unidadF = findViewById(R.id.farenButton);
        unidadF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unidad = "Fº";
            }
        });

        unidadK = findViewById(R.id.kelvinButton);
        unidadK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unidad = "K";
            }
        });

        transC = findViewById(R.id.celsiusButton2);
        transC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trans = "ºC";
                resultado.setText((int) transformarUnidades(temp, unidad, trans));
            }
        });

        transF = findViewById(R.id.farenButton2);
        transF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trans = "Fº";
                resultado.setText((int) transformarUnidades(temp, unidad, trans));
            }
        });

        transK = findViewById(R.id.kelvinButton2);
        transK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trans = "K";
                resultado.setText((int) transformarUnidades(temp, unidad, trans));
            }
        });



    }

    public double transformarUnidades(double temp, String unidad, String trans) {

        switch (unidad) {
            case "ºC":
                if (trans.equals("ºC")) {
                    temp = temp;
                } else if (trans.equals("Fº")) {
                    temp = temp * 1.8 + 32;
                } else if (trans.equals("K")) {
                    temp = temp + 273.15;
                }
                break;

            case "Fº":
                if (trans.equals("ºC")) {
                    temp = (temp - 32) / 1.8;
                } else if (trans.equals("Fº")) {
                    temp = temp;
                } else if (trans.equals("K")) {
                    temp = 5 / 9 * (temp - 32) + 273.15;
                }
                break;

            case "K":
                if (trans.equals("ºC")) {
                    temp = temp - 273.15;
                } else if (trans.equals("Fº")) {
                    temp = 1.8 * (temp - 273.15) + 32;
                } else if (trans.equals("K")) {
                    temp = temp;
                }
                break;
            default:
                break;
        }

        return temp;
    }
}