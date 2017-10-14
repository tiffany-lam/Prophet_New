package com.prophet.prophets.prophet;

import android.content.DialogInterface;
import android.content.Intent;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
       // addListenerOnButton();

        Button registerButton = (Button) findViewById(R.id.registerButton);
        final EditText name = ((EditText) findViewById(R.id.nameEditText));
        final EditText skills = ((EditText) findViewById(R.id.skillsEditText));
        //final EditText volunteer = ((TextView) findViewById(R.id.volunteerEditText));
        //final String familymembers = ((EditText) findViewById(R.id.familymembersEditText)).getText().toString();
        final EditText locations = ((EditText) findViewById(R.id.placesEditText));
        survey = (LinearLayout) findViewById(R.id.survey);
        survey.setVisibility(View.GONE);
        radioChoice = (RadioGroup) findViewById(R.id.radioChoice);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String naam = name.getText().toString();
                String skillz = skills.getText().toString();
                String locationz = locations.getText().toString();



                Random rand = new Random();

                int  n = rand.nextInt(50) + 1;
                Profile p = new Profile(n, naam, "", skillz, locationz);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Profile");


                DatabaseReference usersRef = myRef.child("Profile"+n);
                Map<String, Profile> users = new HashMap<String, Profile>();

                users.put(""+naam+n, p);
                //users.put("Tiffanny34", new Profile(68, "Tiff", "HP, Iphone", "Green, Yellow, Red", "133.32, 189.23"));

                usersRef.setValue(users);


                Toast.makeText(RegisterActivity.this,
                        naam, Toast.LENGTH_SHORT).show();
                //Toast.makeText(RegisterActivity.this,
                  //      skills, Toast.LENGTH_SHORT).show();
               // Toast.makeText(RegisterActivity.this,
                 //       locations, Toast.LENGTH_SHORT).show();

                if(selectedId == 1) {
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
                }
                Intent i = new Intent(RegisterActivity.this, MainMenu.class);
                startActivity(i);


                //TODO add p to database
            }
        });


 //   public void addListenerOnButton() {
   //     radioChoice = (RadioGroup) findViewById(R.id.radioChoice);
     //   radioYes = (RadioButton) findViewById(R.id.radioYes);
       // radioNo = (RadioButton) findViewById(R.id.radioNo);


    //}
    //}
        /*
        btnDisplay = (Button) findViewById(R.id.registerButton);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get selected radio button from radioGroup

          /        Toast.makeText(RegisterActivity.this,
                            radioChoiceButton.getText(), Toast.LENGTH_SHORT).show();*/








       // });
        //Make a changeradiobutton


        radioChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            //Set a sum accumulator for points
            int sum = 0;
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId == R.id.radioYes){
                    selectedId = 1;
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
                    selectedId = 0;
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
