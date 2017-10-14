package com.prophet.prophets.prophet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Paz_X on 10/13/2017.
 */

public class MainMenu extends AppCompatActivity {


    private GetGPSCoordinates gps;
    //gps = new GPSTracker(AndroidGPSTrackingActivity.this);
    private int ViewType = 0;
    private double lon = 0.0;
    private double lat = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        //gps.getLocation();
        gps= new GetGPSCoordinates(MainMenu.this);
        // check if GPS enabled
        if(gps.canGetLocation()){

            lat = gps.getLatitude();
            lon = gps.getLongitude();

            // \n is for new line
            //Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + lat + "\nLong: " + lon, Toast.LENGTH_LONG).show();
        }else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
        //Bundle receive = getIntent().getExtras();
        ///try {
           // ViewType = receive.getInt("viewType");
        //}catch(Exception e)
        //{}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        Button GetHelp = (Button) findViewById(R.id.main_menu_get_help);
        Button ProvideHelp = (Button) findViewById(R.id.main_menu_provide_help);
        Button Settings = (Button) findViewById(R.id.main_menu_settings);



    //32.779246, -117.113613
      //  if(ViewType == 1 )
        {
        //    GetHelp.setVisibility(View.GONE);
          //  ProvideHelp.setVisibility(View.GONE);
            //Settings.setVisibility(View.GONE);

        }

        //else
        {
          //  GetHelp.setVisibility(View.VISIBLE);
           // ProvideHelp.setVisibility(View.VISIBLE);
            //Settings.setVisibility(View.VISIBLE);


            GetHelp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(MainMenu.this, GetHelp.class);
                    Bundle send = new Bundle();
                    send.putDouble("lat",lat );
                    send.putDouble("lon",lon );
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + lat + "\nLong: " + lon, Toast.LENGTH_LONG).show();
                    i.putExtras(send);
                    gps.stopUsingGPS();
                    startActivity(i);
                }
            });

            Settings.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainMenu.this, SettingsActivity.class);
                    startActivity(i);
                }
            });

            ProvideHelp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainMenu.this, ProvideAid.class);
                    startActivity(i);
                }
            });


            //http://www.google.com/maps/place/33.77579059,-118.17396795

        }



        Button Qt = (Button) findViewById(R.id.main_menu_quick_tips);
        Qt.setTop(50);
        Qt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainMenu.this, QuickTips.class);
                //lat = gps.getLatitude();
                //lon = gps.getLongitude();

                //
                startActivity(i);
                //gps.stopUsingGPS();
            }
        });

    }
}