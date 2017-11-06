package com.example.fauza.threading;

import android.os.AsyncTask;

public class RandomTask extends AsyncTask<Void, Integer, Void> {
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            while (true) {
                int number = (int) (Math.random() * 100);
                publishProgress(number);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
