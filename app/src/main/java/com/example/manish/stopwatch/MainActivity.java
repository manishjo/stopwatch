package com.example.manish.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    Chronometer mChronometer;
    Button start, stop, restart;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChronometer = (Chronometer) findViewById(R.id.chronometer1);

        start = (Button) findViewById(R.id.srt_button);
        start.setOnClickListener(mStartListener);

        stop = (Button) findViewById(R.id.stp_button);
        stop.setOnClickListener(mStopListener);

        restart = (Button) findViewById(R.id.reset_button);
        restart.setOnClickListener(mResetListener);

        textView = (TextView) findViewById(R.id.Elapsed_time);

    }

    private void showElapsedTime() {
        long elapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
        Toast.makeText(MainActivity.this, "Elapsed milliseconds: " + elapsedMillis,
                Toast.LENGTH_SHORT).show();
        int total_time = (int)elapsedMillis/1000;
        textView.setText(String.valueOf(total_time));

    }

    View.OnClickListener mStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            mChronometer.setBase(SystemClock.elapsedRealtime());
            mChronometer.start();
        }
    };

    View.OnClickListener mStopListener = new View.OnClickListener() {
        public void onClick(View v) {
            mChronometer.stop();
            showElapsedTime();
        }
    };

    View.OnClickListener mResetListener = new View.OnClickListener() {
        public void onClick(View v) {
            mChronometer.setBase(SystemClock.elapsedRealtime());
        }
    };
}





