package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Impostazioni extends AppCompatActivity {

    ImageButton logout, home, impostazioni, esercizi, allenamento, modificapassword;
    EditText nuova,vecchia;
    Button conferma;
    Persona persona;
    public static final String PERSONA_PATH ="com.example.esercitazione2.Persona";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impostazioni);

        modificapassword = findViewById(R.id.modificaPassword);
        nuova = findViewById(R.id.nuova_password);
        vecchia = findViewById(R.id.vecchia_password);
        conferma = findViewById(R.id.conferma_pass);

        Integer[] i = new Integer[]{0};

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

        public boolean checkInput(){
            int errors =0;
            if(vecchia.getText().toString() != persona.getPassword()){
                errors++;
                vecchia.setError("le password non combaciano");
            }
            else vecchia.setError(null);

            return errors==0;
        }

}