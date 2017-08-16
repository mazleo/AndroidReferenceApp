package com.app.reference.android.androidreferenceapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekbarActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView seekbarRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekbarRating = (TextView) findViewById(R.id.seekbarRating);

        seekbarRating.setText(R.string.seekbar_init_text);
        seekbarRating.setTextColor(Color.GREEN);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String ratingString = "Rating: " + seekBar.getProgress();
                seekbarRating.setText(ratingString);

                if (seekBar.getProgress() < 4) {
                    seekbarRating.setTextColor(Color.GREEN);
                }
                else if (seekBar.getProgress() < 7) {
                    seekbarRating.setTextColor(getResources().getColor(R.color.color_orange));
                }
                else {
                    seekbarRating.setTextColor(Color.RED);
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
}
