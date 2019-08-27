package com.example.railenquiry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TrainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        String s="https://www.railyatri.in/trains-between-stations";
        WebView browser=findViewById(R.id.webView);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(s);
    }
}
