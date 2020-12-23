package com.example.scorecounterapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String COUNTER_KEY1 = "myCounter1";
    private static final String COUNTER_KEY2 = "myCounter1";
    private TextView textViewCounter1;
    private TextView textViewCounter2;

    Button button1;
    Button button2;

    private int counter1=0;
    private int counter2=0;
    private Intent intent;

    public static final String KEY_WINNER = "key_winner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "inside onCreate method");
        setContentView(R.layout.activity_main);

        textViewCounter1 = findViewById(R.id.tvShowCount1);
        textViewCounter2 = findViewById(R.id.tvShowCount2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {  //onclick listener for first button
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                textViewCounter1.setText(Integer.toString(counter1));
                if (counter1 < 5) {
                    counter1 ++;
                } else  if (counter1 == 5 ){
                    goToNextActivity("TEAM A: "+counter1);
                }
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {  // onclick listener for second button
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                textViewCounter2.setText(Integer.toString(counter2));
                if (counter2 < 5) {
                    counter2 ++;
                } else if (counter2 == 5){
                    goToNextActivity("TEAM B: "+counter2);
                }

            }
        });


    }

    private void goToNextActivity(String message){

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);


        intent.putExtra( KEY_WINNER, message);
        //intent.putExtra( KEY_WINNER, "Team A: "+counter1);
        //  intent.putExtra(KEY_WINNER, " Team B: "+counter2);
        startActivity(intent);
    }



}