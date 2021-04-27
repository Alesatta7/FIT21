package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SceltaAllenamento extends AppCompatActivity {

    CardView facile,medio,difficile;

    //Dichiarazione pulsanti barra di controllo
    ImageButton logout, profilo, impostazioni, esercizi, allenamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scelta_allenamento);

        facile = findViewById(R.id.facile);
        medio = findViewById(R.id.medio);
        difficile = findViewById(R.id.difficile);

        //Implementazione della barra di controllo

        esercizi = findViewById(R.id.eserciziButton);
        profilo = findViewById(R.id.profiloButton);
        impostazioni = findViewById(R.id.impostazioniButton);
        allenamento = findViewById(R.id.allenamentoButton);


        esercizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SceltaAllenamento.this,ListaEsercizi.class);
                startActivity(intent);
            }
        });

        allenamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SceltaAllenamento.this,SceltaAllenamento.class);
                startActivity(intent);
            }
        });
    }


}