package com.example.gua3;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class AgregarNombre extends AppCompatActivity {
    EditText txbNombre;
    Button btnProcesar;
    private static int contProceso = 0;
    private ProgressBar progresbar;
    private Handler manejadorProcesos;
    public static final String textoNombre = "textoNombre";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_nombre);

        btnProcesar = findViewById(R.id.btnProcesar);
        this.progresbar = findViewById(R.id.progressBar);
        this.manejadorProcesos = new Handler();
        txbNombre = findViewById(R.id.txtNombre);
        this.progresbar.setMax(100);


        this.btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!InfoIsValid()){
                    Toast.makeText(AgregarNombre.this,"Campos requeridos..",Toast.LENGTH_SHORT).show();
                }else{
                    new Thread(new ProcesoSecundario()).start();
                }
            }
        });
    }
    final class ProcesoSecundario implements Runnable{
        @Override
        public void run() {
            while (contProceso < 100){
                metodoEspera();
                manejadorProcesos.post(new Runnable() {
                    @Override
                    public void run() {
                        progresbar.setProgress(contProceso);
                        //Validar si el proceso ya termino
                        if(contProceso == 100){
                            String Name = txbNombre.getText().toString();
                            Intent msg = new Intent();
                            msg.putExtra(textoNombre,Name);
                            contProceso = 0;
                            setResult(RESULT_OK,msg);
                            finish();

                        }
                    }
                });
            }
        }

        private void metodoEspera(){
            try {
                Thread.sleep(90);
                contProceso++;
            }catch(Exception e){

            }
        }

    }
    private boolean InfoIsValid(){
        if(this.txbNombre.getText().toString().trim().length() <= 1){

            return false;
        }
        return true;
    }

}