package com.prophet.prophets.prophet;

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

public class GetHelp extends AppCompatActivity
{

    private ProgressDialog pd;
    private double lat = 0.0;
    private double lon = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_help);


        Bundle receive = getIntent().getExtras();
        try {
            lat = receive.getDouble("lat");
            lon = receive.getDouble("lon");
        }catch(Exception e)
        {}


        pd = new ProgressDialog(GetHelp.this);
        TextView msg = (TextView) findViewById(R.id.get_help_received_msg);
        msg.setText("Worry Not! \nHelp is on the way!"+"\n"+lat+","+lon);



        String Coordinates = "http://www.google.com/maps/place/"+lat+","+lon;
        WebView wb = (WebView) findViewById(R.id.get_help_map);


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
