package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Home extends AppCompatActivity {

    ImageButton  profilo, impostazioni, esercizi, allenamento, logout;
    Persona persona;
    TextView etaTv, altezzaTv, circonferenzaTv, pesoAttualeTv, imcTv, minTv, maxTv, pesoIdealeTv, risultatoTv, genereTv, metabolismoTv;
    TextView sottopesoT, normopesoT, sovrappesoT, obeso1T, obeso2T, obeso3T;
    TextView descrSottopeso, descrNormopeso, descSovrappeso, descrObeso;

    Float imcI, pesoA, minP, maxP;
    Integer polso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //--------------------------Ricerca da ID
        logout = findViewById(R.id.logoutButton);
        esercizi = findViewById(R.id.eserciziButton);
        profilo = findViewById(R.id.profiloButton);
        impostazioni = findViewById(R.id.impostazioniButton);
        allenamento = findViewById(R.id.allenamentoButton);

        etaTv = findViewById(R.id.etaR);
        altezzaTv = findViewById(R.id.altezzaR);
        circonferenzaTv = findViewById(R.id.circonferenzaR);
        pesoAttualeTv = findViewById(R.id.pesoAttualeR);
        imcTv = findViewById(R.id.imcR);
        minTv = findViewById(R.id.minR);
        maxTv = findViewById(R.id.maxR);
        pesoIdealeTv = findViewById(R.id.ideale);
        risultatoTv = findViewById(R.id.risultatoImc);
        metabolismoTv = findViewById(R.id.metabolismoR);
        genereTv = findViewById(R.id.genereR);

        sottopesoT = findViewById(R.id.sottopeso);
        normopesoT = findViewById(R.id.normopeso);
        sovrappesoT = findViewById(R.id.sovrappeso);
        obeso1T = findViewById(R.id.obeso1);
        obeso2T = findViewById(R.id.obeso2);
        obeso3T = findViewById(R.id.obeso3);
        descrNormopeso = findViewById(R.id.spiegazioneNormopeso);
        descrObeso = findViewById(R.id.spiegazioneObeso);
        descrSottopeso = findViewById(R.id.spiegazioneSottopeso);
        descSovrappeso = findViewById(R.id.spiegazioneSovrappeso);



        //-------------------------Passaggio dei dati dalla registrazione
        Intent presa = getIntent();
        Serializable object = presa.getSerializableExtra(StartLogin.UTENTE_PATH);

        if(object instanceof Persona){
            this.persona = (Persona) object;
        }
        else {
            this.persona = new Persona();
        }










        //----------------Modifica TextView
        altezzaTv.setText(Integer.toString(persona.getAltezza()));
        pesoAttualeTv.setText(Integer.toString(persona.getPeso()));
        circonferenzaTv.setText(Integer.toString(persona.getCirconferenzaPolso()));
        genereTv.setText(persona.getGenere());

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        etaTv.setText(format.format(persona.getDataDiNascita().getTime()));
        LocalDate newDate = LocalDate.parse(etaTv.getText().toString(), DateTimeFormatter.ofPattern("dd/MM/yyy"));
        Period period = Period.between(newDate, LocalDate.now());
        etaTv.setText(Integer.toString(period.getYears()));


        imcI = (float) (persona.getPeso())/ ((persona.getAltezza()) * (persona.getAltezza())/10000);
        imcTv.setText(Float.toString(imcI));
        if(imcI < 18.5){                          //Sottopeso
            risultatoTv.setText("Sottopeso");
            sottopesoT.setVisibility(View.VISIBLE);
            descrSottopeso.setVisibility(View.VISIBLE);
        }else if(imcI <= 24.9 && imcI >= 18.5){   //Normopeso
            risultatoTv.setText("Normopeso");
            normopesoT.setVisibility(View.VISIBLE);
            descrNormopeso.setVisibility(View.VISIBLE);
        }else if(imcI <= 29.9 && imcI >= 25.0){   //Sovrappeso
            risultatoTv.setText("Sovrappeso");
            sovrappesoT.setVisibility(View.VISIBLE);
            descSovrappeso.setVisibility(View.VISIBLE);
        }else if(imcI <= 34.9 && imcI >= 30.0){   //Obesità 1
            risultatoTv.setText("Obesità 1");
            obeso1T.setVisibility(View.VISIBLE);
            descrObeso.setVisibility(View.VISIBLE);
        }else if(imcI <= 39.9 && imcI >= 35.0){   //Obesità 2
            risultatoTv.setText("Obesità 2");
            obeso2T.setVisibility(View.VISIBLE);
            descrObeso.setVisibility(View.VISIBLE);
        }else if (imcI >= 40.0){                  //Obesità 3
            risultatoTv.setText("Obesità 3");
            obeso3T.setVisibility(View.VISIBLE);
            descrObeso.setVisibility(View.VISIBLE);
        }

        polso = persona.getCirconferenzaPolso();

        if(persona.getPassword().equals("Donna")){
            if(polso < 14){         //Corporatura esile

            }else if(polso > 18){   //Coporatura normolinea

            }else{                  //Corporatura robusta

            }
        }

        if(persona.getPassword().equals("Uomo")){
            if(polso < 16){         //Corporatura esile

            }else if(polso > 18){   //Coporatura normolinea

            }else{                  //Corporatura robusta

            }
        }











        //-------------------------------------Barra di controllo
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,StartLogin.class);
                startActivity(intent);
            }
        });
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