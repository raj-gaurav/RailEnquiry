package com.example.railenquiry;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PNRStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnrstatus);

        String pnr=getIntent().getExtras().getString("pnr");

        ProgressDialog dialog=new ProgressDialog(this);
        dialog.show();
        dialog.setMessage("Loading...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dialog.dismiss();

//https://api.railwayapi.com/v2/pnr-status/pnr/6733431064/apikey/92243deb92af26be2fbeac69d7f67565/
        //String s="https://etrain.info/in?PNR=";
       // String url=s+pnr;
        String url="https://www.trainspnrstatus.com/";
        WebView browser=findViewById(R.id.webView);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(url);

    }
}
