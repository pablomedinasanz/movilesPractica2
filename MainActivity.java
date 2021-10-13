package com.example.calculadoraaosytemp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button aniosBisiestos;
    private Button temperatura;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aniosBisiestos = findViewById(R.id.añosButton);
        aniosBisiestos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, AniosBisiestos.class);
                startActivity(intent);
            }
        });

        temperatura = findViewById(R.id.tempButton);
        temperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, Temperatura.class);
                startActivity(intent);
            }
        });

    }

}