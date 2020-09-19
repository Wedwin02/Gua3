package com.example.gua3.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gua3.R;

import java.util.List;

public class AdaptadorInformacion extends RecyclerView.Adapter<viewHolderInformacion> {
    private List<Encuestado> ListaEncuestado;

    public AdaptadorInformacion(List<Encuestado> data){
        this.ListaEncuestado = data;
    }
    @NonNull
    @Override
    public viewHolderInformacion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creamos los item de la vista
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_lista,parent,false);
        viewHolderInformacion vhi = new viewHolderInformacion(vista);
        return vhi;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderInformacion holder, int position) {
        holder.getlblNombre().setText(this.ListaEncuestado.get(position).getNombre());

    }

    @Override
    public int getItemCount() {
        return this.ListaEncuestado.size();
    }
}
