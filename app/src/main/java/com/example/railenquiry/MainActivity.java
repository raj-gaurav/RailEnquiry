package com.example.railenquiry;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView err1,err2;
    CardView pnr,train;
    EditText email,subject,suggestion;
    Button send_email;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("RailEnquiry");


        pnrstatus();
        trainenquiry();



    }

    public void init(){
        err1=findViewById(R.id.errlay1);
        err2=findViewById(R.id.errlay2);
        toolbar=findViewById(R.id.toolbar);
        pnr=findViewById(R.id.PNR_status);
        train=findViewById(R.id.card_train_status);
        email=findViewById(R.id.email);
        subject=findViewById(R.id.subject);
        suggestion=findViewById(R.id.suggestion);
        send_email=findViewById(R.id.send);

        send_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eid=email.getText().toString().trim();
                String sub=subject.getText().toString().trim();
                String sugg=suggestion.getText().toString().trim();

                if(eid.isEmpty())
                {
                    err1.setText("You must provide email-id.");
                    err1.setVisibility(View.VISIBLE);
                    err2.setVisibility(View.INVISIBLE);

                }
                else if(sub.isEmpty())
                {
                    err1.setText("You must mention the subject.");
                    err1.setVisibility(View.VISIBLE);
                    err2.setVisibility(View.INVISIBLE);
                }
                else if(sugg.isEmpty())
                {
                    err1.setVisibility(View.INVISIBLE);
                    err2.setText("You should give some suggestion to send.");
                    err2.setVisibility(View.VISIBLE);
                }
                else
                {
                    err1.setVisibility(View.INVISIBLE);
                    err2.setVisibility(View.INVISIBLE);
                    Intent i=new Intent(Intent.ACTION_SEND);
                    i.setData(Uri.parse("email"));
                    String[] s={"rajgauravraj97@gmail.com","gauravraj9378@yahoo.in"};
                    i.putExtra(Intent.EXTRA_EMAIL,s);
                    i.putExtra(Intent.EXTRA_SUBJECT,sub);
                    i.putExtra(Intent.EXTRA_TEXT,sugg);
                    i.setType("message/rfc822");
                    Intent send=Intent.createChooser(i,"Launch Email");
                    startActivity(send);

                }


            }
        });


    }

    public void pnrstatus() {
       pnr.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if(isOnline())
               {
                   err1.setVisibility(View.INVISIBLE);
                   err2.setVisibility(View.INVISIBLE);
                   Intent i=new Intent(MainActivity.this,PNR_entry.class);
                   startActivity(i);
               }
               else
               {
                   Snackbar snac=Snackbar.make(findViewById(R.id.main), Html.fromHtml("<font color=\"#ffffff\">No Internet Connection :(</font>"),Snackbar.LENGTH_LONG);
                    snac.getView().setBackgroundColor(ContextCompat.getColor(v.getContext(),android.R.color.holo_red_dark));
                    snac.show();
               }


           }
       });
    }

    public void trainenquiry(){
        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOnline())
                {
                    err1.setVisibility(View.INVISIBLE);
                    err2.setVisibility(View.INVISIBLE);
                    Intent i=new Intent(MainActivity.this,TrainActivity.class);
                    startActivity(i);
                }
                else
                {
                    Snackbar snac=Snackbar.make(findViewById(R.id.main), Html.fromHtml("<font color=\"#ffffff\">No Internet Connection :(</font>"),Snackbar.LENGTH_LONG);
                    snac.getView().setBackgroundColor(ContextCompat.getColor(v.getContext(),android.R.color.holo_red_dark));
                    snac.show();
                }
            }
        });
    }

    public Boolean isOnline() {
        try {
            Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com");
            int returnVal = p1.waitFor();
            boolean reachable = (returnVal==0);
            return reachable;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
}
