package com.prophet.prophets.prophet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerButton = (Button) findViewById(R.id.registerButton);
        final String name = ((EditText) findViewById(R.id.nameEditText)).getText().toString();
        final String skills = ((EditText) findViewById(R.id.skillsEditText)).getText().toString();
        final String familymembers = ((EditText) findViewById(R.id.familymembersEditText)).getText().toString();
        final String locations = ((EditText) findViewById(R.id.placesEditText)).getText().toString();
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profile p = new Profile(-1, name, skills, familymembers, locations);
                //TODO add p to database
            }
        });
    }
}
