package com.example.scorecounterapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Navigation extends AppCompatActivity  {

    public static final String TAG = "NavigationActivity";

    private EditText  editTextLoc;
    private Button buttonLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Log.d(TAG, "inside getReferencesToMyWidgets method");
        editTextLoc = findViewById(R.id.editTextLoc);
        buttonLoc = findViewById(R.id.buttonLoc);

        buttonLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "inside openMapLocation method");
                String loc = editTextLoc.getText().toString();
                Uri geoLocation = Uri.parse("geo:0,0?q="+loc);
                Intent locIntent = new Intent(Intent.ACTION_VIEW, geoLocation);
                if(   locIntent.resolveActivity(  getPackageManager()  )    != null   ){
                    startActivity(locIntent);
                }
                else{
                    Log.d(TAG, "could not handle map location");
                }
            }

        });
    }


}