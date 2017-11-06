package com.example.fauza.threading;

import android.os.AsyncTask;
import android.widget.TextView;

public class RandomTask extends AsyncTask<Void, Integer, Void> {

    private final TextView textViewHello;

    public RandomTask(TextView textView) {
        this.textViewHello = textView;
    }

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

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int number = values[0];
        this.textViewHello.setText(number);
    }
}
