package com.app.reference.android.androidreferenceapp;

import android.icu.text.DecimalFormat;
import android.icu.text.SimpleDateFormat;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Date;

public class MediaPlayerActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton;
    private SeekBar musicSeekBar;
    private TextView musicProgressText;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.super_mario_theme);
        musicSeekBar = (SeekBar) findViewById(R.id.musicSeekBar);
        playButton = (Button) findViewById(R.id.playButton);
        musicProgressText = (TextView) findViewById(R.id.musicProgressText);

        musicSeekBar.setMax(mediaPlayer.getDuration());

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    pauseMusic();
                    playButton.setText("Play");
                }
                else {
                    playMusic();
                    playButton.setText("Pause");
                }
            }
        });

        musicSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    int minute;
                    int second;
                    String strProgress;

                    mediaPlayer.seekTo(progress);
                    musicProgressText.setText(String.valueOf(new SimpleDateFormat("mm:ss").format(new Date(mediaPlayer.getCurrentPosition()))));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void playMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            updateThread();
        }
    }

    public void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void updateThread() {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (mediaPlayer != null && mediaPlayer.isPlaying()) {
                        Thread.sleep(50);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int newPosition = mediaPlayer.getCurrentPosition();
                                musicSeekBar.setProgress(newPosition);
                                musicProgressText.setText(new SimpleDateFormat("mm:ss").format(new Date(newPosition)));
                            }
                        });
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;

            thread.interrupt();
            thread = null;
        }
    }
}
