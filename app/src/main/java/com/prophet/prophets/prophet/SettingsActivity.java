package com.prophet.prophets.prophet;

/**
 * Created by Paz_X on 10/14/2017.
 */


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity
{   @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);

    Spinner s = (Spinner) findViewById(R.id.spinner);
    }
    }
