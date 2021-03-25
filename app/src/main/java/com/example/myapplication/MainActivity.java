package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDelegado, btnLinea, btnInterface;
    EditText name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.Usuario);
        password = findViewById(R.id.password);

        btnDelegado = findViewById(R.id.btnDelegado);
        btnLinea = findViewById(R.id.btnLinea);
        btnInterface = findViewById(R.id.btnInterface);

        btnInterface.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInterface:
                Toast.makeText(getApplicationContext(),"Este es el botón Interface",Toast.LENGTH_LONG).show();
                break;
            default: break;
        }
    }

    public void saludar(View h){
        String nombre = validar(name);
        String clave = validar(password);
        if(!nombre.isEmpty() && !clave.isEmpty()){
            Intent ir = new Intent(this,Home.class);
            volver(ir);
            Bundle datos = new Bundle();
            datos.putString("name",name.getText().toString());
            datos.putString("password",password.getText().toString());
            ir.putExtras(datos);
            startActivity(ir);
        }else{
            Toast.makeText(getApplicationContext(),"Por favor llene todos los campos",Toast.LENGTH_LONG).show();
        }
    }

    public void holi(View h){
        Intent i = new Intent(this,Registro.class);
        volver(i);
        startActivity(i);
    }

    private void volver(Intent i){
        i.addFlags(i.FLAG_ACTIVITY_CLEAR_TASK | i.FLAG_ACTIVITY_CLEAR_TOP);
    }

    private String validar(EditText dato){
        return dato.getText().toString().trim();
    }
}
