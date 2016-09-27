package com.example.ziyi.mediaplayerpractice;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button_start = (Button)findViewById(R.id.start);
        final Button button_pause = (Button)findViewById(R.id.pause);
        final Button button_stop = (Button)findViewById(R.id.stop);

        button_pause.setEnabled(false);
        button_stop.setEnabled(false);

        button_start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {



                            mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.typewriter);


                            mediaPlayer.start();


                        button_pause.setEnabled(true);
                        button_stop.setEnabled(true);

                    }
                }
        );

        button_pause.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(mediaPlayer.isPlaying()){
                            button_pause.setText("播放");
                            mediaPlayer.pause();
                        }
                        else {
                            button_pause.setText("暂停");
                            mediaPlayer.start();
                        }
                    }
                }
        );

        button_stop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                    }
                }
        );
    }
}
