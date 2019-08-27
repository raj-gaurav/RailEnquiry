package com.example.railenquiry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PNRStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnrstatus);
//https://api.railwayapi.com/v2/pnr-status/pnr/6733431064/apikey/92243deb92af26be2fbeac69d7f67565/
        String s="https://www.ndtv.com/indian-railway/live-train-status";
        WebView browser=findViewById(R.id.webView);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(s);

    }
}
