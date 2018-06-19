package com.example.dell.musicapp;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class music extends Service
{
    int pos;
    MediaPlayer mp;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp=MediaPlayer.create(getApplicationContext(),R.raw.perfc);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent.getStringExtra("order").equals("start")){
                        mp.start();

        }

        else
            if(intent.getStringExtra("order").equals("pause")){
           pos=mp.getCurrentPosition();
            mp.pause();

        }

        else
            if(intent.getStringExtra("order").equals("resume")){
           mp.seekTo(pos);
           mp.start();
                }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp.isPlaying()){
            mp.stop();
        }
    }


}
