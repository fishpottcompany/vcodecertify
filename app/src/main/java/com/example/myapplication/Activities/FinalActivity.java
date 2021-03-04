package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FinalActivity extends AppCompatActivity {

    ImageView resultsImageView, correctOrWrongResultsImageView;
    TextView labelResultsTextView, resultsTextView, viewFileTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        String vcode = getIntent().getStringExtra("VCODE");

        resultsImageView = findViewById(R.id.doc);
        correctOrWrongResultsImageView = findViewById(R.id.validicon);
        labelResultsTextView = findViewById(R.id.label1);
        resultsTextView = findViewById(R.id.info1);
        viewFileTextView = findViewById(R.id.view);

        if(vcode.equalsIgnoreCase("2210070208001004")){
            resultsImageView.setImageResource(R.drawable.ajaz);
            correctOrWrongResultsImageView.setImageResource(R.drawable.ic_protection);
            labelResultsTextView.setText("Name");
            resultsTextView.setText("Ajaz Sulaman");
            resultsTextView.setTextColor(getColor(R.color.colorPrimaryDark));
            viewFileTextView.setVisibility(View.GONE);
        } else if(vcode.equalsIgnoreCase("80400e08000a0004")){
            resultsImageView.setImageResource(R.drawable.bilal);
            correctOrWrongResultsImageView.setImageResource(R.drawable.ic_protection);
            labelResultsTextView.setText("Name");
            resultsTextView.setText("Bilaq Farooq");
            resultsTextView.setTextColor(getColor(R.color.colorPrimaryDark));
            viewFileTextView.setVisibility(View.GONE);
        } else if(vcode.equalsIgnoreCase("0248000020201404")){
            resultsImageView.setImageResource(R.drawable.sanjay);
            correctOrWrongResultsImageView.setImageResource(R.drawable.ic_protection);
            labelResultsTextView.setText("Name");
            resultsTextView.setText("Shanjay Shay");
            resultsTextView.setTextColor(getColor(R.color.colorPrimaryDark));
            viewFileTextView.setVisibility(View.GONE);
        } else if(vcode.equalsIgnoreCase("0208002020201404")){
            resultsImageView.setImageResource(R.drawable.que);
            correctOrWrongResultsImageView.setImageResource(R.drawable.ic_wrong);
            labelResultsTextView.setText("Warning");
            resultsTextView.setText("This VCODE is not valid");
            resultsTextView.setTextColor(getColor(R.color.colorRed));
        } else if(vcode.equalsIgnoreCase("2800024050008104")){
            resultsImageView.setImageResource(R.drawable.pdf);
            correctOrWrongResultsImageView.setImageResource(R.drawable.ic_protection);
            labelResultsTextView.setText("Certicate");
            resultsTextView.setText("Issued to Bilal Farooq \n\nMBA from International Islamic University");
            resultsTextView.setTextColor(getColor(R.color.colorPrimaryDark));
        } else if(vcode.equalsIgnoreCase("08010a204060c804")){
            resultsImageView.setImageResource(R.drawable.pdf);
            correctOrWrongResultsImageView.setImageResource(R.drawable.ic_protection);
            labelResultsTextView.setText("Certicate");
            resultsTextView.setText("Issued issued to Bilal Farooq \n\nMS in Management Sciences from International Islamic University");
            resultsTextView.setTextColor(getColor(R.color.colorPrimaryDark));
        } else {
            resultsImageView.setImageResource(R.drawable.que);
            correctOrWrongResultsImageView.setImageResource(R.drawable.ic_wrong);
            labelResultsTextView.setText("Warning");
            resultsTextView.setText("This VCODE is not valid");
            resultsTextView.setTextColor(getColor(R.color.colorRed));
        }
        Log.e("BareFragVcode", "vcode: " + vcode);
    }
    private void openPDFFiles() {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), "cert1.pdf");//here schedule1.pdf is the pdf file name which is keep in assets folder.
        try {
            in = assetManager.open("cert1.pdf");
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Log.e("PDFOPENDER", e.getMessage());
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("file://" + getFilesDir() + "/schedule1.pdf"), "application/pdf");

        startActivity(intent);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }
}
