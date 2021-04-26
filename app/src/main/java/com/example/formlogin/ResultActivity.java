package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class ResultActivity extends AppCompatActivity {

    Persona persona;
    TextView nomeText, cognomeText, dataText, genereText, altezzaText, pesoText, circonferenzaText, emailText, passwordText;
    Button confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        nomeText = findViewById(R.id.titleNome);
        cognomeText = findViewById(R.id.titleCognome);
        dataText = findViewById(R.id.titleData);
        genereText = findViewById(R.id.titleGenere);
        altezzaText = findViewById(R.id.titleAltezza);
        pesoText = findViewById(R.id.titlePeso);
        circonferenzaText = findViewById(R.id.titleCirconferenzaPolso);
        emailText = findViewById(R.id.titleEmail);
        passwordText = findViewById(R.id.titlePassword);
        confirm = findViewById(R.id.Confirm);


        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(MainActivity.PERSONA_PATH);

        if(object instanceof Persona){
            this.persona = (Persona) object;
        }
        else {
            this.persona = new Persona();
        }

        nomeText.setText(persona.getNome());
        cognomeText.setText(persona.getCognome());
       // genereText.setText(persona.getGenere());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dataText.setText(format.format(persona.getDataDiNascita().getTime()));

        emailText.setText(persona.getEmail());
        passwordText.setText(persona.getPassword());
        altezzaText.setText(Integer.toString(persona.getAltezza()));
        pesoText.setText(Integer.toString(persona.getPeso()));
        circonferenzaText.setText(Integer.toString(persona.getCirconferenzaPolso()));
        genereText.setText(persona.getGenere());

        confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cambio = new Intent(ResultActivity.this, StartLogin.class);
                startActivity(cambio);
            }
        });
    }
}