package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SceltaAllenamento extends AppCompatActivity {

    TextView facile,medio,difficile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scelta_allenamento);

        facile.findViewById(R.id.facile);
        medio.findViewById(R.id.medio);
        difficile.findViewById(R.id.difficile);
    }


}