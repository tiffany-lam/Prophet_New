package com.prophet.prophets.prophet;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by nicks on 10/14/2017.
 */

public class GPS extends AppCompatActivity implements LocationListener {
    private String provider;
    private LocationManager locationManager;
    private Double lat, lon;
    private Long time;
    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;


    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        getLocation();
        msg("WE got something! \nLat=" + lat + "\nlon=" + lon + "\ntime=" + time);

    }

    public void msg(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    public void getLocation() {
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
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                location = locationManager.getLastKnownLocation(provider);
                lat = location.getLatitude();
                lon = location.getLongitude();
                time = location.getTime();
                msg("WE got something! \nLat=" + lat + "\nlon=" + lon + "\ntime=" + time);
                return;
            } catch (NullPointerException e) {
                e.printStackTrace();
                msg("Ooops something went terribly wrong with GPS");
                return;
            }
        }
    }

    public Location getLastKnownLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        return locationManager.getLastKnownLocation(provider);
    }

    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lon = location.getLongitude();
        time = location.getTime();
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

    public Double getLat(){ return this.lat; }
    public Double getLon(){ return this.lon; }
    public Long getTime(){ return this.time; }
}
