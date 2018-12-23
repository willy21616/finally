package com.example.afinally;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Main4Activity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mp =MediaPlayer.create(this, R.raw.di01);
        mp.start();
    }
    public void fin(View view){
        mp.stop();
        finish();
    }
}
