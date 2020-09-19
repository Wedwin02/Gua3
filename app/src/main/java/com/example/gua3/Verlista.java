package com.example.gua3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gua3.Adaptadores.AdaptadorInformacion;
import com.example.gua3.Adaptadores.Encuestado;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Verlista extends AppCompatActivity {

    private List<Encuestado> ListaEncuestado = new ArrayList<Encuestado>();
    private RecyclerView Lista;
    private AdaptadorInformacion Adaptador;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlista);

        //Recibimos los datos
        Intent a = getIntent();
        String DatosLista = a.getStringExtra("DatosLista");
        Gson gn = new Gson();
        Type type =  new TypeToken<ArrayList<Encuestado>>(){}.getType();
        ArrayList<Encuestado>items = gn.fromJson(DatosLista,type);
        this.ListaEncuestado = items;



        //
        this.Lista = findViewById(R.id.RCV);
        this.manager = new  LinearLayoutManager(this);
        this.Adaptador= new AdaptadorInformacion(ListaEncuestado);

        //Configurar

        this.Lista.setHasFixedSize(true);
        this.Lista.setLayoutManager(manager);
        this.Lista.setAdapter(Adaptador);
    }
}