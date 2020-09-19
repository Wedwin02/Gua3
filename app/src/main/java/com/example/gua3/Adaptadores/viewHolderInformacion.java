package com.example.gua3.Adaptadores;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gua3.R;

public class viewHolderInformacion extends RecyclerView.ViewHolder {

    private TextView lblNombre;

    public viewHolderInformacion(@NonNull View itemView) {
        super(itemView);

        this.lblNombre = itemView.findViewById(R.id.lblNombre);
    }

    public TextView getlblNombre() {
        return lblNombre;
    }
}
