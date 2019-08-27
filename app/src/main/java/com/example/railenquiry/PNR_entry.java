package com.example.railenquiry;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PNR_entry extends AppCompatActivity {

    Toolbar toolbar;
    EditText pnr;
    Button status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnr_entry);

        toolbar=findViewById(R.id.toolbar);
        pnr=findViewById(R.id.pnr);
        status=findViewById(R.id.status);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("PNR");


        ProgressDialog dialog=new ProgressDialog(this);
        dialog.show();
        dialog.setMessage("Loading...");

        String pnr_no=pnr.getText().toString().trim();
        Intent i= new Intent(getApplicationContext(),PNRStatus.class);
        i.putExtra("pnr",pnr_no);
        startActivity(i);
        finish();





    }
}
