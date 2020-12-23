package com.example.scorecounterapplication;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class Text_A_Friend extends AppCompatActivity implements View.OnClickListener{

    //  final int SEND_SMS_PERMISSION_REQUEST_CODE = 1;

    // EditText enter_number, enter_text;
    // private Button onSend;

    private EditText editTextPlainText;
    private Button buttonPlainText;
    private String TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text__a__friend);

        editTextPlainText = findViewById(R.id.editTextPlain);
        buttonPlainText = findViewById(R.id.buttonShareText);

        buttonPlainText.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "case: TEXT");
        sendText();

    }

    private void sendText() {
        Log.d(TAG, "inside sendText method");
        String theText = editTextPlainText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Choose something")
                .setText(theText)
                .startChooser();

    }
}
