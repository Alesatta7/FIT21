package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Tutorial extends AppCompatActivity {

    SeekBar timer_sb;
    TextView timer_tv, testoEs;
    Button start_btn;
    CountDownTimer countDownTimer;
    Boolean counterAttivo = false;
    MediaPlayer mediaPlayer;

    pl.droidsonroids.gif.GifImageView crunch_Immagine;
    pl.droidsonroids.gif.GifImageView android_Immagine;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        Intent info = getIntent();
        int idEs = info.getIntExtra("esercizio", -1);

        testoEs = findViewById(R.id.pulsante);
        crunch_Immagine = findViewById(R.id.crunch_im);
        android_Immagine = findViewById(R.id.androidGif);

        timer_sb = findViewById(R.id.timer_sb);
        timer_tv = findViewById(R.id.timer_tv);
        start_btn = findViewById(R.id.start_btn);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarm);
        timer_sb.setMax(30);
        timer_sb.setProgress(30);


        switch(idEs){
            case -1:
                break;
            case 0:
                crunch_Immagine.setVisibility(View.VISIBLE);
                break;
            case 1:
                android_Immagine.setVisibility(View.VISIBLE);
                break;
        }

/* Esempio con pulsante e textview

        testoEs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                esempio.setVisibility(View.VISIBLE);
            }
        });

 */

        timer_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                update(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void update(int progress) {
        int minutes = progress / 60;
        int seconds = progress % 60;
        String secondsFinal = "";

        if(seconds<= 0){
            secondsFinal = "0" + seconds;
        }else{
            secondsFinal = "" + seconds;
        }

        timer_sb.setProgress(progress);
        timer_tv.setText(""+minutes+":"+secondsFinal);
    }

    public void start_timer(View view) {
        if(counterAttivo == false){
            counterAttivo = true;
            timer_sb.setEnabled(false);
            start_btn.setText("STOP");
            countDownTimer = new CountDownTimer(timer_sb.getProgress()*1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    update((int)millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    reset();
                    if(mediaPlayer != null)
                        mediaPlayer.start();
                }
            }.start();
        }else{
            reset();
        }

    }

    private void reset() {
        timer_tv.setText("0:30");
        timer_sb.setProgress(30);
        countDownTimer.cancel();
        start_btn.setText("AVVIO");
        timer_sb.setEnabled(true);
        counterAttivo = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(counterAttivo){
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(counterAttivo){
            countDownTimer.cancel();
        }
    }
}