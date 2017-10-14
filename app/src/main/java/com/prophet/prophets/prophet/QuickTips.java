package com.prophet.prophets.prophet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Paz_X on 10/13/2017.
 */

public class QuickTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quick_tips);
        {

            Button Qt = (Button) findViewById(R.id.quick_tips_quick_tips2);
            Button medical = (Button) findViewById(R.id.quick_tips_medical);

            Qt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent i = new Intent(QuickTips.this, QuickTips2.class);
                    startActivity(i);
                }
            });

            medical.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent i = new Intent(QuickTips.this, Medical.class);
                    startActivity(i);
                }
            });
        }
    }
}
