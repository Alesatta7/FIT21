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
    TextView etaTv, altezzaTv, circonferenzaTv, pesoAttualeTv, imcTv, minTv, maxTv, pesoIdealeTv, risultatoTv, risultatoCoportaturaTv, genereTv, metabolismoTv;
    TextView sottopesoT, normopesoT, sovrappesoT, obeso1T, obeso2T, obeso3T;
    TextView descrSottopeso, descrNormopeso, descSovrappeso, descrObeso;

    Float imcI, pesoId, minP, maxP, metabolismoF, etaF;
    Integer pesoA, altezzaCm;
    Integer polso;
    String minS, maxS, imcS, pesoS, metabolismoS;


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
        risultatoCoportaturaTv = findViewById(R.id.risultatoCorporatura);
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
        altezzaTv.setText(Integer.toString(MainActivity.logged.getAltezza()));
        pesoAttualeTv.setText(Integer.toString(MainActivity.logged.getPeso()));
        circonferenzaTv.setText(Integer.toString(MainActivity.logged.getCirconferenzaPolso()));
        genereTv.setText(MainActivity.logged.getGenere());

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        etaTv.setText(format.format(MainActivity.logged.getDataDiNascita().getTime()));
        LocalDate newDate = LocalDate.parse(etaTv.getText().toString(), DateTimeFormatter.ofPattern("dd/MM/yyy"));
        Period period = Period.between(newDate, LocalDate.now());
        etaTv.setText(Integer.toString(period.getYears()));
        etaF = (float) period.getYears();


        //-----------------Calcolo IMC e setto la descrizione del peso
        pesoA = MainActivity.logged.getPeso();
        altezzaCm = MainActivity.logged.getAltezza();
        imcI =  pesoA/(altezzaCm*altezzaCm/10000.0f);
        imcS = String.format("%.2f", imcI);

        //imcI = (float) (persona.getPeso())/ ((persona.getAltezza()) * (persona.getAltezza())/10000);
        imcTv.setText(imcS);
        if(imcI < 18.5){                          //Sottopeso
            risultatoTv.setText("Sottopeso");
            sottopesoT.setVisibility(View.VISIBLE);
            descrSottopeso.setVisibility(View.VISIBLE);
        }else if(imcI <= 25.0 && imcI >= 18.5){   //Normopeso
            risultatoTv.setText("Normopeso");
            normopesoT.setVisibility(View.VISIBLE);
            descrNormopeso.setVisibility(View.VISIBLE);
        }else if(imcI <= 30 && imcI >= 25.1){   //Sovrappeso
            risultatoTv.setText("Sovrappeso");
            sovrappesoT.setVisibility(View.VISIBLE);
            descSovrappeso.setVisibility(View.VISIBLE);
        }else if(imcI <= 35.0 && imcI >= 30.1){   //Obesità 1
            risultatoTv.setText("Obesità 1");
            obeso1T.setVisibility(View.VISIBLE);
            descrObeso.setVisibility(View.VISIBLE);
        }else if(imcI <= 40 && imcI >= 35.1){   //Obesità 2
            risultatoTv.setText("Obesità 2");
            obeso2T.setVisibility(View.VISIBLE);
            descrObeso.setVisibility(View.VISIBLE);
        }else if (imcI > 40.0){                  //Obesità 3
            risultatoTv.setText("Obesità 3");
            obeso3T.setVisibility(View.VISIBLE);
            descrObeso.setVisibility(View.VISIBLE);
        }


        //---------------In base alla grandezza del polso e al genere dell'utente si calcola il peso ideale
        //Variabili d'appoggio per polso, peso min e peso max calcolati in base all'altezza
        polso = MainActivity.logged.getCirconferenzaPolso();
        minP = (18.5f)*(altezzaCm/100f)*(altezzaCm/100f);
        maxP =  (25.1f)*(altezzaCm/100f)*(altezzaCm/100f);
        minS = String.format("%.2f", minP);
        maxS = String.format("%.2f", maxP);

        //Setto i valori delle TextView di peso minimo, massimo e della morfologia
        minTv.setText(minS);
        maxTv.setText(maxS);

        pesoId = 1.0f;
        //--------Corporatura DONNA
        if(MainActivity.logged.getGenere().equals("Donna")){
            metabolismoF = (float) (655.1+(9.563*pesoA)+(1.850*altezzaCm)-(4.676*etaF));
            if(polso < 14){         //Corporatura esile
                pesoId = minP + 1.0f;
                risultatoCoportaturaTv.setText("Corporatura esile");
            }else if(polso > 18){   //Coporatura normolinea
                pesoId = maxP - 2.0f;
                risultatoCoportaturaTv.setText("Corporatura robusta");
            }else{                  //Corporatura robusta
                pesoId = ((maxP-minP)/2.0f)+minP;
                risultatoCoportaturaTv.setText("Corporatura media");
            }
        }

        //--------Corporatura UOMO
        if(MainActivity.logged.getGenere().equals("Uomo")){
            metabolismoF = (float) (66.5+(13.75*pesoA)+(5.003*altezzaCm)-(6.775f*etaF));
            if(polso < 16){         //Corporatura esile
                pesoId = minP + 1.0f;
                risultatoCoportaturaTv.setText("Corporatura esile");
            }else if(polso > 20){   //Coporatura normolinea
                pesoId = maxP - 2.0f;
                risultatoCoportaturaTv.setText("Corporatura robusta");
            }else{                  //Corporatura robusta
                pesoId = ((maxP-minP)/2.0f) + minP;
                risultatoCoportaturaTv.setText("Corporatura media");
            }
        }

        //Settaggio peso ideale
        pesoS = String.format("%.2f", pesoId);
        pesoIdealeTv.setText(pesoS);
        metabolismoS = String.format("%.2f", metabolismoF);
        metabolismoTv.setText(metabolismoS);







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
