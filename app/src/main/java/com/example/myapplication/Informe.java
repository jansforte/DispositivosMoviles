package com.example.myapplication;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.time.LocalDate;
import java.time.Period;


public class Informe extends AppCompatActivity {

    TextView nombre, edad, genero,profesion;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informe);
        nombre = findViewById(R.id.nombre);
        edad = findViewById(R.id.edad);
        genero = findViewById(R.id.genero);
        profesion = findViewById(R.id.profesion);

        imagen = findViewById(R.id.imagen);

        Bundle datos = getIntent().getExtras();
        nombre.setText("Nombre: "+datos.getString("nombre"));

        edad.setText("Nació el: "+datos.getString("fecha"));
        genero.setText("Genero: "+datos.getString("genero"));
        profesion.setText("Profesion: "+datos.getString("profesion"));

        switch (datos.getString("profesion")){
            case "Ingeniero Biomedico":
                imagen.setImageResource(R.drawable.biomedico);
                break;
            case "Ingeniero Electronico":
                imagen.setImageResource(R.drawable.electronico);
                break;
            case "Ingeniero Sistemas":
                imagen.setImageResource(R.drawable.informatico);
                break;
            default:
                imagen.setImageResource(R.drawable.otro);
                break;
        }
    }
}
