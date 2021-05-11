package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.Serializable;

public class Impostazioni extends AppCompatActivity {

    ImageButton logout, home, impostazioni, esercizi, allenamento, modificapassword;
    EditText nuova,vecchia;
    Button conferma;
    Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impostazioni);

        modificapassword = findViewById(R.id.modificaPassword);
        nuova = findViewById(R.id.nuova_password);
        vecchia = findViewById(R.id.vecchia_password);
        conferma = findViewById(R.id.conferma_pass);
        logout = findViewById(R.id.logoutButton);
        esercizi = findViewById(R.id.eserciziButton);
        home = findViewById(R.id.homeButton);
        impostazioni = findViewById(R.id.impostazioniButton);
        allenamento = findViewById(R.id.allenamentoButton);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(MainActivity.PERSONA_PATH);

        if(object instanceof Persona){
            this.persona = (Persona) object;
        }
        else {
            this.persona = new Persona();
        }

        Integer[] i = new Integer[]{0};

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Impostazioni.this,StartLogin.class);
                startActivity(intent);
            }
        });

        //Barra di controllo

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Impostazioni.this,Home.class);
                startActivity(intent);
            }
        });


        esercizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Impostazioni.this,ListaEsercizi.class);
                startActivity(intent);
            }
        });

        allenamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Impostazioni.this,SceltaAllenamento.class);
                startActivity(intent);
            }
        });

        impostazioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Impostazioni.this,Impostazioni.class);
                startActivity(intent);
            }
        });

        modificapassword.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (i[0] == 1) {
                    nuova.setVisibility(View.GONE);
                    vecchia.setVisibility(View.GONE);
                    conferma.setVisibility(View.GONE);
                    i[0] = 0;
                } else if (i[0] == 0) {
                    nuova.setVisibility(View.VISIBLE);
                    vecchia.setVisibility(View.VISIBLE);
                    conferma.setVisibility(View.VISIBLE);
                    i[0] = 1;
                }
            }

        });


        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkInput()) {
                    UpdatePerson();
                }
            }
        });

    }

        public void UpdatePerson(){
            this.persona.setPassword(this.nuova.getText().toString());
        }

        //Da correggere
        public boolean checkInput(){
            int errors =0;
            if(vecchia.getText().toString().length() ==0 ){
                vecchia.setError("Inserire password");
                errors=1;
            } else vecchia.setError(null);

            if(!vecchia.getText().toString().equals(MainActivity.logged.getPassword())){
                vecchia.setError("Password sbagliata");
                errors=1;
            } else vecchia.setError(null);

            return errors==0;
        }

}