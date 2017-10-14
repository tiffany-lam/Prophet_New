package com.prophet.prophets.prophet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //PAZZZZZZZZ
        int App = 1;

        Button LogIn = (Button) findViewById(R.id.login);
        Button SignUp = (Button) findViewById(R.id.sign_up);
        Button QuickTips = (Button) findViewById(R.id.quick_tips);

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg("You have pressed Log In!");

            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
                RegisterActivity ap = new RegisterActivity();
            }
        });

        QuickTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Intent i = new Intent(MainActivity.this, MainMenu.class);
                Bundle send = new Bundle();
                send.putLong("id", dbid);
                send.putString("naam", CompanyNaam);
                Intent intent = new Intent(this, NotificationReceiver.class);
                intent.putExtras(send);
                startActivity(i);

*/
            }
        });

    }

    private void msg(String x)
    {
        Toast.makeText(MainActivity.this, x, Toast.LENGTH_SHORT);

    }
}


/*
* *******************************************************
*           GPS Function
*
* ************************************************************
*     public void getLocation() {
        //if(Global/Shared Preferences then)
        {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            try {
                isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            } catch (Exception ex) {
                msg("GPS is disabled ='(");
            }

            try {
                isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            } catch (Exception ex) {
                msg("Network is Unavailable ='(");
            }

            if (!isGPSEnabled) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                msg("Please Enable GPS");
                startActivity(intent);
            }

            if (!isNetworkEnabled) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                msg("Please Enable Network");
                startActivity(intent);
            }
            // Get the location manager

            Criteria criteria = new Criteria();
            //LocationListener ll =
            provider = locationManager.getBestProvider(criteria, false);
            Location location;

            try {
                location = locationManager.getLastKnownLocation(provider);
                lat = location.getLatitude();
                lon = location.getLongitude();
                msg("WE got something! \nLat=" + lat + "\nlon=" + lon);
                return;
            } catch (NullPointerException e) {
                e.printStackTrace();
                msg("Ooops something went terribly wrong with GPS");
                return;
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lon = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Enabled new provider " + provider,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Disabled provider " + provider,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(locationManager !=null)
        {
            locationManager.removeUpdates(this);
        }
    }
*
*
*
* */
