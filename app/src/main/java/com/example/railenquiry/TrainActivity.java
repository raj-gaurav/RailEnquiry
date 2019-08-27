package com.example.railenquiry;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TrainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        ProgressDialog dialog=new ProgressDialog(this);
        dialog.show();
        dialog.setMessage("Loading...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dialog.dismiss();

        String s="https://www.railyatri.in/trains-between-stations";
        //String s="https://www.trainspnrstatus.com/trains";
        WebView browser=findViewById(R.id.webView);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(s);
    }
}
