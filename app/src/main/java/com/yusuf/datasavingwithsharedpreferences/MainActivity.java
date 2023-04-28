package com.yusuf.datasavingwithsharedpreferences;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button save;

    Button button_delete;
    EditText name;
    TextView savedName;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = this.getSharedPreferences("com.yusuf.datasavingwithsharedpreferences", Context.MODE_PRIVATE);

        save = findViewById(R.id.button);
        button_delete=findViewById(R.id.button_delete);
        name = findViewById(R.id.editText);
        savedName = findViewById(R.id.textView);

        String defaultSharedName = sharedPreferences.getString("sharedName","");

        if (!defaultSharedName.matches("")){
            savedName.setText("Your Name: " + defaultSharedName);
        }
        else {
            savedName.setText("No Name Found!");
        }
    }


    public void save(View view){
        if (name.getText().toString().matches("")){
            savedName.setText("Enter a name!");
        }
        else {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Save");
            alert.setMessage("Are You Sure?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String sharedName = name.getText().toString();
                    savedName.setText("Your Name: " + sharedName);
                    sharedPreferences.edit().putString("sharedName",sharedName).apply();
                }
            });

            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    savedName.setText("Unsucessful Saving!");

                }
            });

            alert.show();

        }
    }

    public void delete(View view){
        sharedPreferences.edit().remove("sharedName").apply();
        savedName.setText("Your Name Deleted!");
    }

}