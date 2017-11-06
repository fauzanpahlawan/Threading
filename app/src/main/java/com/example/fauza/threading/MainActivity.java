package com.example.fauza.threading;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonStartStop;
    private TextView textViewHello;
    private int number;
    private Handler handler = new Handler();

    private Runnable uiRunnable = new Runnable() {
        @Override
        public void run() {
            textViewHello.setText(number + "");
        }
    };

    private Runnable bgRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    number = (int) (Math.random() * 10);
                    Thread.sleep(100);
                    handler.post(uiRunnable);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonStartStop = findViewById(R.id.bt_start_stop);
        this.textViewHello = findViewById(R.id.tv_hello);

        this.buttonStartStop.setOnClickListener(this);
    }

    Thread t;
    RandomTask randomTask;

    @Override
    public void onClick(View view) {
        if (randomTask == null || randomTask.getStatus() == AsyncTask.Status.FINISHED) {
            randomTask = new RandomTask(this.textViewHello);
            randomTask.execute();
        } else {
            randomTask.cancel(true);
        }

//        if (t == null || !t.isAlive()) {
//            t = new Thread(bgRunnable);
//            t.start();
//        } else {
//            t.interrupt();
//        }
    }
}
