package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Home extends AppCompatActivity {

    TextView dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dataView = findViewById(R.id.Usuario);
        Bundle datosRecibidos = getIntent().getExtras(); ///se reciben los datos empaquetados en el bundle de la clase main
        assert datosRecibidos != null;
        dataView.setText("name: "+ datosRecibidos.getString("name")+" pass:"+ datosRecibidos.getString("password"));
    }

    public void volver(View h){
        Intent ir = new Intent(this,MainActivity.class);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);
    }
}
