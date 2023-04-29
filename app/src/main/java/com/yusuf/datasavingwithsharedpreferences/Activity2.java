package com.yusuf.datasavingwithsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textView=findViewById(R.id.textView3);

        Intent intent = getIntent();
        String name = intent.getStringExtra("sendedName");
        textView.setText("Your Name:"+name);
    }

    public void goTo1Screen(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}