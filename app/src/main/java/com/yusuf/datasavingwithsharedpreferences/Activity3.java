package com.yusuf.datasavingwithsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    TextView textView;
    Runnable runnable;
    Handler handler;

    Button button_start;

    Button button_stop;
int number;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        intent=getIntent();
        button_start=findViewById(R.id.button6);
        button_stop=findViewById(R.id.button7);
        textView=findViewById(R.id.timer);
        number =0;
    }

    public void start(View view){
        handler = new Handler();
        button_start.setEnabled(false);
        button_stop.setEnabled(true);
        runnable = new Runnable() {
            @Override
            public void run() {
                number++;
                textView.setText(""+number);
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
    }
    public void stop(View view){
        handler.removeCallbacks(runnable);
        button_start.setEnabled(true);
        button_stop.setEnabled(false);
    }

    public void clear(View view){
        handler.removeCallbacks(runnable);
        button_start.setEnabled(true);
        button_stop.setEnabled(false);
        textView.setText("");
    }

}