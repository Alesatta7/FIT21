package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    ImageButton  profilo, impostazioni, esercizi, allenamento, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent info = getIntent();

        logout = findViewById(R.id.logoutButton);
        esercizi = findViewById(R.id.eserciziButton);
        profilo = findViewById(R.id.profiloButton);
        impostazioni = findViewById(R.id.impostazioniButton);
        allenamento = findViewById(R.id.allenamentoButton);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,StartLogin.class);
                startActivity(intent);
            }
        });

        //Barra di controllo
        esercizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,ListaEsercizi.class);
                startActivity(intent);
            }
        });

        allenamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,SceltaAllenamento.class);
                startActivity(intent);
            }
        });

        impostazioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Impostazioni.class);
                startActivity(intent);
            }
        });


    }
}