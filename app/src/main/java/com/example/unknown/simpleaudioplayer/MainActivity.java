package com.example.unknown.simpleaudioplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer player = MediaPlayer.create(this, R.raw.one_time);
        final Button playButton = (Button) findViewById(R.id.playBtn);
        Button pauseButton = (Button) findViewById(R.id.pauseBtn);
        Button seekButton = (Button) findViewById(R.id.seekBtn);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MainActivity.this, "I'm done", Toast.LENGTH_LONG).show();
                    }
                });
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
                int time = player.getCurrentPosition();
                player.seekTo(time + 20000);
            }
        });
    }
}
