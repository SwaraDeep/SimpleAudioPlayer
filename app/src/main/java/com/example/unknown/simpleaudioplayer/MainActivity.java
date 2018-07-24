package com.example.unknown.simpleaudioplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer player = MediaPlayer.create(this, R.raw.one_time);
        Button playButton = (Button) findViewById(R.id.playBtn);
        Button pauseButton = (Button) findViewById(R.id.pauseBtn);
        Button seekButton = (Button) findViewById(R.id.seekBtn);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
            }
        });

        seekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int time = player.getDuration();
                player.seekTo(time/2);
            }
        });
    }
}
