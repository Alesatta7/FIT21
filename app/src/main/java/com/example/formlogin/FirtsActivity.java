package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirtsActivity extends AppCompatActivity {

    TextView log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firts);
        log = findViewById(R.id.buttonLog);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambio = new Intent(FirtsActivity.this, MainActivity.class);
                startActivity(cambio);
            }
        });
    }
}