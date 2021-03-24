package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Registro extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText nombre,fecha, profesionOtra;
    private String genero="";
    private String profesion="";
    private String item="";
    private boolean otroP=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.nombre);
        fecha = findViewById(R.id.fechaNacimiento);
        profesionOtra =  findViewById(R.id.estudioOtro);

        Spinner spinner = findViewById(R.id.profesion);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.estudio_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void onRadioGenero(View v){
        boolean escogido = ((RadioButton) v).isChecked();
        switch (v.getId()){
            case R.id.masculino:
                if(escogido)
                    genero="Masculino";
                break;
            case R.id.femenino:
                if(escogido)
                    genero="Femenino";
                break;
        }
    }

    public void onRadioProfesion(View v){
        boolean escogido = ((RadioButton) v).isChecked();
        switch (v.getId()){
            case R.id.estudio:
                if(escogido){
                    profesion = "Ingeniero "+item;
                    otroP=false;
                }
                break;
            case R.id.estudioOtro:
                if(escogido){
                    otroP=true;
                }
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = parent.getItemAtPosition(position).toString();
        Toast.makeText(this,"Item "+item,Toast.LENGTH_LONG);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void visualizar(View h){
        String nombreU = validar(nombre);
        if(!nombreU.isEmpty()){
            if(otroP){
                profesion = validar(profesionOtra);
                if(profesion.isEmpty())
                    profesion="Otra";
            }
            Intent ir = new Intent(this,Informe.class);
            volver(ir);
            Bundle datos = new Bundle();
            datos.putString("nombre",nombreU);
            datos.putString("fecha",fecha.getText().toString());
            datos.putString("genero",genero);
            datos.putString("profesion",profesion);
            ir.putExtras(datos);
            startActivity(ir);
        }else{
            Toast.makeText(this,"Por favor llene todos los campos",Toast.LENGTH_LONG);
        }
    }

    public void Atras(View h){
        Intent ir = new Intent(this,MainActivity.class);
        volver(ir);
        startActivity(ir);
    }

    private void volver(Intent i){
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TASK | i.FLAG_ACTIVITY_CLEAR_TOP);
    }

    private String validar(EditText dato){
        return dato.getText().toString().trim();
    }
}
