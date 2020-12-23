package com.example.scorecounterapplication;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button buttoncall, buttonmessage, buttonsearch;


    private static final String TAG = "Second Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // on create is the method that creates all the functional application
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "inside of onCreate method of SecondActivity");

        Intent intent = getIntent();
        String message = "Winner: " +
                intent.getStringExtra(MainActivity.KEY_WINNER);

        TextView textView = findViewById(R.id.text_view_numbers);
        textView.setText(message);

        buttonmessage = findViewById(R.id.buttonmessage);
        buttoncall = findViewById(R.id.buttoncall);
        buttonsearch = findViewById(R.id.buttonsearch);


        buttoncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);    // creating an intent to make calls available
                startActivity(callIntent);
            }
        });

        buttonmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMessageActivity();
            }

            private void goToMessageActivity() {
                Intent messageIntent = new Intent(SecondActivity.this, Text_A_Friend.class);
                startActivity(messageIntent);

            }
        });
    }

    public void search(View view) {
        Intent navigationIntent = new Intent(SecondActivity.this, Navigation.class);    // creating an intent to make navigation available
        startActivity(navigationIntent);
    }
}



