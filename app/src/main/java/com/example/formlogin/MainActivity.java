package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText nome, cognome, data, email, password, genere;
    SeekBar altezzaSB, pesoSB, circonferenzaSB;

    TextView altezzaT;
    TextView pesoT;
    TextView circonferenzaT;

    Button inserisci;
    TextView errorText;
    Persona persona;

    static Persona logged;

    public static final String PERSONA_PATH ="com.example.esercitazione2.Persona";
    public static final int DONNA = 0;
    public static final int UOMO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.attrNome);
        cognome = findViewById(R.id.attrCognome);
        data = findViewById(R.id.attrData);
        email = findViewById(R.id.attrEmail);
        password = findViewById(R.id.attrPassword);
        genere = findViewById(R.id.attrGenere);

        //TextView e Seekbar
        altezzaT = findViewById(R.id.altezzaText);
        pesoT = findViewById(R.id.pesoText);
        circonferenzaT = findViewById(R.id.circonferenzaPolsoText);

        altezzaSB = findViewById(R.id.seekbarAltezza);
        altezzaSB.setMax(300);
        pesoSB = findViewById(R.id.seekbarPeso);
        pesoSB.setMax(200);
        circonferenzaSB = findViewById(R.id.seekbarPolso);
        circonferenzaSB.setMax(30);



        inserisci = findViewById(R.id.saveButton);
        errorText = findViewById(R.id.errorText);
        persona = new Persona();

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    showDialog();
                }
            }
        });
        inserisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showResult = new Intent(MainActivity.this, ResultActivity.class);
                Intent parametri = new Intent(MainActivity.this, StartLogin.class);
                Intent forHome = new Intent(MainActivity.this, Home.class);
                if(checkInput()){
                    UpdatePerson();
                    showResult.putExtra(PERSONA_PATH, persona);
                    parametri.putExtra(PERSONA_PATH, persona);
                    forHome.putExtra(PERSONA_PATH, persona);
                    startActivity(parametri);
                    //startActivity(showResult);
                }
            }
        });
        altezzaSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                altezzaT.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                altezzaT.setText(String.valueOf(seekBar.getProgress()));

            }
        });
        pesoSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pesoT.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                pesoT.setText(String.valueOf(seekBar.getProgress()));

            }
        });
        circonferenzaSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circonferenzaT.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                circonferenzaT.setText(String.valueOf(seekBar.getProgress()));

            }
        });
    }

    void showDialog() {
        DialogFragment newFragment = DatePickerFragment.newInstance();
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    public void doPositiveClick(Calendar date) {
        // Do stuff here.
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        data.setText(format.format(date.getTime())); //10/10/2020
    }

    public void doNegativeClick() {
        // Do stuff here.

    }

    public void UpdatePerson(){
        logged = persona;
        this.persona.setNome(this.nome.getText().toString());
        this.persona.setCognome(this.cognome.getText().toString());
        this.persona.setEmail(this.email.getText().toString());
        this.persona.setPassword(this.password.getText().toString());
        this.persona.setAltezza(Integer.parseInt((this.altezzaT).getText().toString()));
        this.persona.setGenere(this.genere.getText().toString());
        this.persona.setPeso(Integer.parseInt((this.pesoT).getText().toString()));
        this.persona.setCirconferenzaPolso(Integer.parseInt((this.circonferenzaT).getText().toString()));


        //this.persona.setGenere(this.genere);

        // this.persona.setAltezza(Integer.parseInt(String.valueOf(this.altezzaT)));
        //this.persona.setPeso(Integer.parseInt(String.valueOf(this.pesoT)));
        //this.persona.setCirconferenzaPolso(Integer.parseInt(String.valueOf(this.circonferenzaT)));
    }

    public void updateDataDiNascita(Calendar date){
        this.persona.setDataDiNascita(date);
    }

    //true se è andato a buon fine, false altrimenti
    public boolean checkInput(){
        int errors =0;
        if(nome.getText() .toString().length() ==0){
            errors++;
            nome.setError("Inserire il nome");
        }
        else nome.setError(null);
        if(cognome.getText().toString().length() ==0){
            errors++;
            cognome.setError("Inserire il cognome");
        }
        else cognome.setError(null);

        if(data.getText().toString().length() ==0){
            errors++;
            data.setError("Inserire la data");
        }
        else data.setError(null);

        if(genere.getText().toString().length() ==0){
            errors++;
            genere.setError("Inserire la data");
        }
        else genere.setError(null);
        if(altezzaT.getText().toString().length() ==0){
            errors++;
            altezzaT.setError("Inserire la data");
        }
        else altezzaT.setError(null);
        if(pesoT.getText().toString().length() ==0){
            errors++;
            pesoT.setError("Inserire la data");
        }
        else pesoT.setError(null);
        if(circonferenzaT.getText().toString().length() ==0){
            errors++;
            circonferenzaT.setError("Inserire la data");
        }
        else circonferenzaT.setError(null);
        if(email.getText().toString().length() ==0){
            errors++;
            email.setError("Inserire la data");
        }
        else email.setError(null);
        if(password.getText().toString().length() ==0){
            errors++;
            password.setError("Inserire la data");
        }
        else password.setError(null);



        return errors==0;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.donnaRB:
                if (checked)
                    genere.setText("Donna");
                break;
            case R.id.uomoRB:
                if (checked)
                    genere.setText("Uomo");
                break;
        }
    }
}