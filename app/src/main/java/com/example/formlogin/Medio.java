package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Medio extends AppCompatActivity {

    //Dichiarazione pulsanti dei muscoli
    Button addominali, dorso, bicipiti, polpacci, petto, avambracci, gambe, spalle, tricipiti;

    //Dichiarazione pulsanti barra di controllo
    ImageButton logout, profilo, impostazioni, esercizi, allenamento, home;

    //Dichiarazione pulsanti degli esercizi
    Button crunch, sollevamentoGambe, russianTwist, superMan;
    Button stacchi, rematore;
    Button curl, curlBraccio;
    Button salti, sollevamentoAlluce;
    Button pushups, piegamentiBraccio;
    Button rotazionePolsi;
    Button squat, affondi, calci;
    Button alzateLaterali, alzateFrontali;
    Button piegamentiFianco, piegamenti;

    //Altri pulsanti

    //Dichiarazione variabili d'appoggio per gli ascoltatori
    Integer[] i = new Integer[] {0,0,0,0,0,0,0,0,0};

    pl.droidsonroids.gif.GifImageView esempio;

    int es;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medio);
        Intent info = getIntent();

        //button bottom
        home= findViewById(R.id.HomeButton);


        //-------------------Assegnamento tramite id per i muscoli
        addominali = findViewById(R.id.addominali_Button);
        dorso = findViewById(R.id.dorso_Button);
        bicipiti = findViewById(R.id.bicipiti_Button);
        polpacci = findViewById(R.id.polpacci_Button);
        petto = findViewById(R.id.petto_Button);
        avambracci = findViewById(R.id.avambracci_Button);
        gambe = findViewById(R.id.gambe_Button);
        spalle = findViewById(R.id.spalle_Button);
        tricipiti = findViewById(R.id.tricipi_Button);

        //-------------------Assegnamento tramite id per gli esercizi
        crunch = findViewById(R.id.crunch_Button);
        esempio = findViewById(R.id.androidGif);
        sollevamentoGambe = findViewById(R.id.sollevamento_gambe_Button);
        russianTwist = findViewById(R.id.russian_twist_Button);
        superMan = findViewById(R.id.superman_Button);

        stacchi = findViewById(R.id.stacchi_Button);
        rematore = findViewById(R.id.rematore_Button);

        curl = findViewById(R.id.curl_Button);
        curlBraccio = findViewById(R.id.curl_braccio_Button);

        salti = findViewById(R.id.salti_talloni_Button);
        sollevamentoAlluce = findViewById(R.id.sollevamento_alluce_Button);

        pushups = findViewById(R.id.pushups_Button);
        piegamentiBraccio = findViewById(R.id.piegamenti_braccio_Button);

        rotazionePolsi = findViewById(R.id.rotazione_polsi_Button);

        squat = findViewById(R.id.squat_Button);
        affondi = findViewById(R.id.affondi_Button);
        calci = findViewById(R.id.calci_Button);

        alzateFrontali = findViewById(R.id.alzateFrontali_Button);
        alzateLaterali = findViewById(R.id.alzateLaterali_Button);

        piegamentiFianco = findViewById(R.id.piegamenti_fianco_Button);
        piegamenti = findViewById(R.id.piegamenti_Button);



        //Pulsante
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ritornoHome = new Intent(Medio.this, Home.class);
                startActivity(ritornoHome);
            }
        });

        //---------------------Listener per i muscoli

        //---------------------Addominali
        addominali.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(i[0] == 1){
                    crunch.setVisibility(View.GONE);
                    sollevamentoGambe.setVisibility(View.GONE);
                    i[0]=0;
                }
                else if(i[0] == 0){
                    crunch.setVisibility(View.VISIBLE);
                    sollevamentoGambe.setVisibility(View.VISIBLE);
                    i[0]=1;
                }
            }

        });

        //---------------------Dorso
        dorso.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(i[1] == 1){
                    stacchi.setVisibility(View.GONE);
                    rematore.setVisibility(View.GONE);
                    i[1]=0;
                }
                else if(i[1] == 0){
                    stacchi.setVisibility(View.VISIBLE);
                    rematore.setVisibility(View.VISIBLE);
                    i[1]=1;
                }
            }
        });

        //---------------------Bicipiti
        bicipiti.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(i[2] == 1){
                    curl.setVisibility(View.GONE);
                    curlBraccio.setVisibility(View.GONE);
                    i[2]=0;
                }
                else if(i[2] == 0){
                    curl.setVisibility(View.VISIBLE);
                    curlBraccio.setVisibility(View.VISIBLE);
                    i[2]=1;
                }
            }
        });

        //---------------------Polpacci
        polpacci.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(i[3] == 1){
                    sollevamentoAlluce.setVisibility(View.GONE);
                    i[3]=0;
                }
                else if(i[3] == 0){
                    sollevamentoAlluce.setVisibility(View.VISIBLE);
                    i[3]=1;
                }
            }
        });

        //---------------------Petto
        petto.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(i[4] == 1){
                    pushups.setVisibility(View.GONE);
                    piegamentiBraccio.setVisibility(View.GONE);
                    i[4]=0;
                }
                else if(i[4] == 0){
                    pushups.setVisibility(View.VISIBLE);
                    piegamentiBraccio.setVisibility(View.VISIBLE);
                    i[4]=1;
                }
            }
        });

        //---------------------Avambracci
        avambracci.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(i[5] == 1){
                    rotazionePolsi.setVisibility(View.GONE);
                    i[5]=0;
                }
                else if(i[5] == 0){
                    rotazionePolsi.setVisibility(View.VISIBLE);
                    i[5]=1;
                }
            }
        });

        //---------------------Gambe
        gambe.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(i[6] == 1){
                    squat.setVisibility(View.GONE);
                    affondi.setVisibility(View.GONE);
                    i[6]=0;
                }
                else if(i[6] == 0){
                    squat.setVisibility(View.VISIBLE);
                    affondi.setVisibility(View.VISIBLE);
                    i[6]=1;
                }
            }
        });

        //---------------------Spalle
        spalle.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(i[7] == 1){
                    alzateFrontali.setVisibility(View.GONE);
                    alzateLaterali.setVisibility(View.GONE);
                    i[7]=0;
                }
                else if(i[7] == 0){
                    alzateFrontali.setVisibility(View.VISIBLE);
                    alzateLaterali.setVisibility(View.VISIBLE);
                    i[7]=1;
                }
            }
        });

        //---------------------Tricipiti
        tricipiti.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if(i[8] == 1){
                    piegamentiFianco.setVisibility(View.GONE);
                    i[8]=0;
                }
                else if(i[8] == 0){
                    piegamentiFianco.setVisibility(View.VISIBLE);
                    i[8]=1;
                }
            }
        });

        //Implementazione della barra di controllo
        esercizi = findViewById(R.id.eserciziButton);
        profilo = findViewById(R.id.profiloButton);
        impostazioni = findViewById(R.id.impostazioniButton);
        allenamento = findViewById(R.id.allenamentoButton);

        esercizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Medio.this,ListaEsercizi.class);
                startActivity(intent);
            }
        });
        allenamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Medio.this,SceltaAllenamento.class);
                startActivity(intent);
            }
        });


        //---------------------Esercizi con gif
        crunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                es = 0;
                Intent cambioP = new Intent(Medio.this, Tutorial.class);
                cambioP.putExtra("esercizio", es);
                startActivity(cambioP);
            }
        });
        sollevamentoGambe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                es = 1;
                Intent cambioP = new Intent(Medio.this, Tutorial.class);
                cambioP.putExtra("esercizio", es);
                startActivity(cambioP);
            }
        });

    }
}