package com.example.gua3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gua3.Adaptadores.Encuestado;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnVerLista;
    Button btnAgregarNombre;
    Button btnDatos;
    List<Encuestado> ListaGlobal = new ArrayList<Encuestado>();
    public static final int id=4;

    public void onActivityResult(int requestcode, int resultcode, Intent data ){
        super.onActivityResult(requestcode, resultcode, data);

        switch (requestcode){
            case id:{
                if(RESULT_OK == resultcode){
                    Encuestado n = new Encuestado();
                    n.setNombre(data.getStringExtra(AgregarNombre.textoNombre));
                    ListaGlobal.add(n);
                    Toast.makeText(this, "Enviado con Exito..", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Saliendo....", Toast.LENGTH_SHORT).show();

                }
            }
            break;
            default:
                Toast.makeText(this, "Error en el switch..", Toast.LENGTH_SHORT).show();
                break;
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAgregarNombre = findViewById(R.id.btnAgregarNombre);
        btnVerLista = findViewById(R.id.btnVerLista);
        btnDatos = findViewById(R.id.btnDatos);

        this.btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frm = new Intent(MainActivity.this, Datos.class);
                startActivity(frm);
            }
        });

        this.btnAgregarNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent frm = new Intent(MainActivity.this,AgregarNombre.class);
                startActivityForResult(frm,id);
            }
        });

        this.btnVerLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(ListaGlobal.size() == 0)){
                    Intent frm = new Intent(MainActivity.this,Verlista.class);
                    Gson g = new Gson();
                    String Datos = g.toJson(ListaGlobal);
                    frm.putExtra("DatosLista",Datos);
                    startActivity(frm);
                }else{
                    Toast.makeText(MainActivity.this,"Lista Vacia..",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}