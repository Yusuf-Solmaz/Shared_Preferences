package com.yusuf.datasavingwithsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    Intent intent;
    TextView textView;
    TextView timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textView=findViewById(R.id.textView3);

        intent = getIntent();
        String name = intent.getStringExtra("sendedName");
        textView.setText("Your Name:"+name);

        timer = findViewById(R.id.timer);
    }

    public void goTo1Screen(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void countTimer(View view){
        new CountDownTimer(10000,1000){


            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText("Left: "+millisUntilFinished/1000+"s");

            }

            @Override
            public void onFinish() {
                timer.setText("Time is over!");
                Toast.makeText(Activity2.this,"Time is Over!",Toast.LENGTH_LONG).show();
            }
        }.start();
    }


    public void goTo3thScreen(View view){
        Intent intent1 = new Intent(this, Activity3.class);

        startActivity(intent1);
    }
}