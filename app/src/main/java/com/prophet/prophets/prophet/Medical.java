package com.prophet.prophets.prophet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by Paz_X on 10/13/2017.
 */

public class Medical extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical);

        WebView wb = (WebView) findViewById(R.id.medical_webview);
        wb.loadUrl("file:///android_asset/medical.html");
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setDefaultFontSize(33);
    }



}
