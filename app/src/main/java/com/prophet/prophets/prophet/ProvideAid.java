package com.prophet.prophets.prophet;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Created by Paz_X on 10/14/2017.
 */

public class ProvideAid extends AppCompatActivity{


    private ProgressDialog pd;
    private double lat = 0.0;
    private double lon = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.provide_aid);





        pd = new ProgressDialog(ProvideAid.this);
        TextView msg = (TextView) findViewById(R.id.provide_aid_received_msg);
        msg.setText("These are the People Around you\n who need assistance! ");



        String Coordinates = "https://www.google.com/maps/dir/33.8869738,-118.3733779,//33.891962,-118.373524//33.894298,+-118.373620//33.8869738,-118.3733779//33.892779,+-118.376638/@33.8903658,-118.3751142,16z/data=!4m16!4m15!1m0!1m0!1m0!1m0!1m3!2m2!1d-118.37362!2d33.894298!1m0!1m0!1m0!1m3!2m2!1d-118.376638!2d33.892779";
        WebView wb = (WebView) findViewById(R.id.provide_aid_map);


        wb.getSettings().setJavaScriptEnabled(true);
        //wb.loadUrl("http://www.google.com/maps/place/33.77579059,-118.17396795");
        wb.loadUrl(Coordinates);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setDefaultFontSize(33);

        pd.setMessage("Your GPS Coordinates are being transmitted...");
        pd.show();

        wb.setWebViewClient(new WebViewClient(){

            public void onPageFinished(WebView view, String url)
            {
                if(pd.isShowing())
                    pd.dismiss();
            }
        });

        Random rand = new Random();

        int  n = rand.nextInt(50) + 1;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("peopleInNeed");


        DatabaseReference usersRef = myRef.child("peopleInNeed"+n);

        Map<String, HelpNeeded> users = new HashMap<String, HelpNeeded>();

        //public Profile(int DBID, String name, String familyMembers, String skills, String locations){
        users.put("Paz"+n, new HelpNeeded(n, "Paz"+n, ""+lat+","+lon));
        //users.put("Tiffanny34", new Profile(68, "Tiff", "HP, Iphone", "Green, Yellow, Red", "133.32, 189.23"));

        usersRef.setValue(users);






    }
}
