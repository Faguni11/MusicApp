package com.example.dell.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
String order;
int x;
Button play,stop,pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=(Button)findViewById(R.id.playBtn);
        stop=(Button)findViewById(R.id.stopBtn);
        pause=(Button)findViewById(R.id.pauseBtn);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,music.class);
                order="start";
                i.putExtra("order",order);
                startService(i);

            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,music.class);
                order="stop";
                i.putExtra("order",order);
                stopService(i);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,music.class);
                order="pause";
                intent.putExtra("order",order);
                play.setText("Resume");
                startService(intent);
            }
        });

    }




}
