package com.prophet.prophets.prophet;

import android.content.DialogInterface;
import android.icu.util.ULocale;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
//import android.widget.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import andriod.widget.Toast;


public class RegisterActivity extends AppCompatActivity {
    private RadioGroup radioChoice;
    private RadioButton radioYes, radioNo,radioChoiceButton;
    private Button btnDisplay;
    private String Category;
    int selectedId = 0;
    LinearLayout survey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addListenerOnButton();

        Button registerButton = (Button) findViewById(R.id.registerButton);
        final String name = ((EditText) findViewById(R.id.nameEditText)).getText().toString();
        final String skills = ((EditText) findViewById(R.id.skillsEditText)).getText().toString();
        final String volunteer = ((TextView) findViewById(R.id.volunteerEditText)).getText().toString();
        //final String familymembers = ((EditText) findViewById(R.id.familymembersEditText)).getText().toString();
        final String locations = ((EditText) findViewById(R.id.placesEditText)).getText().toString();
        survey = (LinearLayout) findViewById(R.id.survey);
        survey.setVisibility(View.GONE);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Profile p = new Profile(-1, name, volunteer, skills, locations);
                Toast.makeText(RegisterActivity.this,
                        name, Toast.LENGTH_SHORT).show();
                Toast.makeText(RegisterActivity.this,
                        skills, Toast.LENGTH_SHORT).show();
                Toast.makeText(RegisterActivity.this,
                        locations, Toast.LENGTH_SHORT).show();

                AlertDialog alertDialog = new AlertDialog.Builder(RegisterActivity.this).create();
                alertDialog.setTitle("Thank you! Your volunteer category: ");
                alertDialog.setMessage(Category);
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();



                //TODO add p to database
            }
        });
    }

    public void addListenerOnButton(){
        radioChoice = (RadioGroup) findViewById(R.id.radioChoice);
        radioYes = (RadioButton) findViewById(R.id.radioYes);
        radioNo = (RadioButton) findViewById(R.id.radioNo);

        btnDisplay = (Button) findViewById(R.id.registerButton);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get selected radio button from radioGroup
                if(radioYes.isChecked()) {
                    selectedId = radioChoice.getCheckedRadioButtonId();
                    //find the radiobutton by returned id
                    radioChoiceButton = (RadioButton) findViewById(selectedId);
          /*          Toast.makeText(RegisterActivity.this,
                            radioChoiceButton.getText(), Toast.LENGTH_SHORT).show();*/


                }




            }
        });
        //Make a changeradiobutton
        radioChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            //Set a sum accumulator for points
            int sum = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId == R.id.radioYes){
                    //show the survey
                    msg("Starting survey..");
                    survey.setVisibility(View.VISIBLE);
                    //Start points
                    //VOLUNTEER QUESTION:
                    if(checkedId == R.id.radioVery){
                        sum += 5;
                    }
                    if(checkedId == R.id.radioMost){
                        sum += 4;
                    }
                    if(checkedId == R.id.radioSome){
                        sum += 3;
                    }
                    if(checkedId == R.id.radioNone){
                        sum += 1;
                    }
                    //Preference
                    if(checkedId == R.id.radioPatients){
                        sum += 5;
                    }
                    if(checkedId == R.id.radioSupplies){
                        sum += 3;
                    }
                    if(checkedId == R.id.radioRescue){
                        sum += 4;
                    }
                    if(checkedId == R.id.radioAny){
                        sum += 1;
                    }
                    //Physical Limitations
                    if(checkedId == R.id.radioYa){
                        sum += 1;
                    }
                    if(checkedId == R.id.radioNah){
                        sum += 3;
                    }
                    if(checkedId == R.id.radioYas){
                        sum += 1;
                    }
                    if(checkedId == R.id.radioNope) {
                        sum += 3;
                    }
                    //CHECKING SUM
                    if (sum > 15){
                        Category = "Medical Group";
                    }
                    //Supply bringer
                    if (sum < 15 && sum >= 10){
                        Category = "Seach and Rescue";
                    }
                    if (sum < 10 && sum > 5 ){
                        Category = "Supply Bringer";
                    }
                    if (sum <= 5 ){
                        Category = "Help at nearby shelter";
                    }

                }
                if(checkedId == R.id.radioNo){
                    survey.setVisibility(View.GONE);
                    //go to main menu
                }
            }
        });
        /*radioChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckChanged(RadioGroup group, @IdRes int checkedId){
                if(checkedId == R.id.radioYes){
                    //show the survey
                }
                if(checkedId == R.id.radioNo){
                    //go to main menu
                }
            }
        });*/




    }

    public void msg(String x)
    {
        Toast.makeText(this, x, Toast.LENGTH_SHORT).show();
    }
}
