package com.prophet.prophets.prophet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import andriod.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    private RadioGroup radioChoice;
    private RadioButton radioChoiceButton;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addListenerOnButton();

        Button registerButton = (Button) findViewById(R.id.registerButton);
        final String name = ((EditText) findViewById(R.id.nameEditText)).getText().toString();
        final String skills = ((EditText) findViewById(R.id.skillsEditText)).getText().toString();
        //final String volunte7y er = ((TextView) findViewById(R.id.volunteerEditText)).getText().toString();
        //final String familymembers = ((EditText) findViewById(R.id.familymembersEditText)).getText().toString();
        final String locations = ((EditText) findViewById(R.id.placesEditText)).getText().toString();



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profile p = new Profile(-1, name, skills, radioChoiceButton.getText().toString(), locations);
                Toast.makeText(RegisterActivity.this,
                        name, Toast.LENGTH_SHORT).show();
                Toast.makeText(RegisterActivity.this,
                        skills, Toast.LENGTH_SHORT).show();
                Toast.makeText(RegisterActivity.this,
                        locations, Toast.LENGTH_SHORT).show();


                //TODO add p to database
            }
        });
    }

    public void addListenerOnButton(){
        radioChoice = (RadioGroup) findViewById(R.id.radioChoice);
        btnDisplay = (Button) findViewById(R.id.registerButton);
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get selected radio button from radioGroup
                int selectedId = radioChoice.getCheckedRadioButtonId();
                //find the radiobutton by returned id
                radioChoiceButton = (RadioButton) findViewById(selectedId);
                Toast.makeText(RegisterActivity.this,
                        radioChoiceButton.getText(), Toast.LENGTH_SHORT).show();



            }
        });



    }

}
