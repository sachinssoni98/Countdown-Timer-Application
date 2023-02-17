package com.example.timerapplication;

import static java.lang.String.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView time;
    Button start, stop;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = findViewById(R.id.time);
        start = findViewById(R.id.startBtn);
        stop = findViewById(R.id.stopBtn);
        start.setOnClickListener(this::startTimer);
        stop.setOnClickListener(this::stopTimer);
    }

    @SuppressLint("DefaultLocale")
    public void startTimer(View view) {
        countDownTimer = new CountDownTimer(100000, 1000) {
            @Override
            public void onTick(long l) {
                time.setText(String.format("%d", l / 1000));
            }

            @Override
            public void onFinish() {
                time.setText(0);
            }
        }.start();
    }

    public void stopTimer(View view){
        countDownTimer.cancel();
    }
}