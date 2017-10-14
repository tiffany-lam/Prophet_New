package com.prophet.prophets.prophet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by Paz_X on 10/13/2017.
 */

public class QuickTips2 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quick_tips2);

        WebView wb = (WebView) findViewById(R.id.quick_tips2_webview);
        wb.loadUrl("file:///android_asset/quick_tips.html");
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setDefaultFontSize(33);
    }



}
