package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class FinalActivity extends AppCompatActivity {

    ImageView resultsImageView, correctOrWrongResultsImageView;
    TextView labelResultsTextView, resultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        String vcode = getIntent().getStringExtra("VCODE");

        resultsImageView = findViewById(R.id.doc);
        correctOrWrongResultsImageView = findViewById(R.id.validicon);
        labelResultsTextView = findViewById(R.id.label1);
        resultsTextView = findViewById(R.id.info1);

        if(vcode.equalsIgnoreCase("2210070208001004")){
            resultsImageView.setImageResource(R.drawable.ajaz);
            correctOrWrongResultsImageView.setImageResource(R.drawable.ic_protection);
            labelResultsTextView.setText("Name");
            resultsTextView.setText("Ajaz Sulaman");
        } else if(vcode.equalsIgnoreCase("80400e08000a0004")){
            resultsImageView.setImageResource(R.drawable.bilal);
            correctOrWrongResultsImageView.setImageResource(R.drawable.ic_protection);
            labelResultsTextView.setText("Name");
            resultsTextView.setText("Ajaz Sulaman");
        } else {

        }
        Log.e("BareFragVcode", "vcode: " + vcode);
    }
}
