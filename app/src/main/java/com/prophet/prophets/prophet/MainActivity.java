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
                msg("You have pressed Sign Up!");

            }
        });

        QuickTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, QuickTips.class);
                startActivity(i);


            }
        });

    }

    private void msg(String x)
    {
        Toast.makeText(MainActivity.this, x, Toast.LENGTH_SHORT);

    }
}
