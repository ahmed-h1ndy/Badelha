package com.example.badellha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Registeration extends AppCompatActivity {
EditText username_input,password_input,email_input,phone_number_input;
Spinner city_spinner;
String city="cairo";
String gender="male";
String profile_image="men_avatar_1";
Button submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        city_spinner=findViewById(R.id.city_spinner);
        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String value = getResources().getStringArray(R.array.cities)[pos];
                city=value;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void go_to_home_page()
    {
        Intent home_page=new Intent(this, Home_Activity.class);
        startActivity(home_page);
    }

    public void register_fun(View v)
    {
        Baddelha_database db=new Baddelha_database(this);

        // get views
        username_input=findViewById(R.id.username_info);
        password_input=findViewById(R.id.password_info);
        email_input=findViewById(R.id.email_address_info);
        phone_number_input=findViewById(R.id.phone_number_info);

        // get info from views -> java variables

        String username=username_input.getText().toString();
        String password=password_input.getText().toString();
        String email=email_input.getText().toString();
        String phone_number=phone_number_input.getText().toString();

        //code to check validation
        if(db.register_a_user(username,password,city,gender,phone_number,email,profile_image))
        {
            go_to_home_page();
            User.setCurrent_user_email(email);
        }
        else
        {
            Toast.makeText(this, "Something went Wrong!, please register again", Toast.LENGTH_LONG).show();
        }
    }

    public void get_gender(View view) {
        // is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // check which gender was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked)
                {
                    gender="male";
                    ((LinearLayout)findViewById(R.id.men_images)).setVisibility(View.VISIBLE);
                    ((LinearLayout)findViewById(R.id.women_images)).setVisibility(View.INVISIBLE);
                    break;
                }
            case R.id.radio_female:
                if (checked)
                {
                    gender="female";
                    ((LinearLayout)findViewById(R.id.women_images)).setVisibility(View.VISIBLE);
                    ((LinearLayout)findViewById(R.id.men_images)).setVisibility(View.INVISIBLE);
                    break;
                }
        }
    }

    public void get_image(View view) {

        // check which image was clicked

        switch(view.getId()) {
            case R.id.men_image_1:
                profile_image="men_avatar_1";
                break;
            case R.id.men_image_2:
                profile_image="men_avatar_2";
                break;
            case R.id.men_image_3:
                profile_image="men_avatar_3";
                break;
            case R.id.men_image_4:
                profile_image="men_avatar_4";
                break;
            case R.id.men_image_5:
                profile_image="men_avatar_5";
                break;
            case R.id.women_image_1:
                profile_image="women_avatar_1";
                break;
            case R.id.women_image_2:
                profile_image="women_avatar_2";
                break;
            case R.id.women_image_3:
                profile_image="women_avatar_3";
                break;
            case R.id.women_image_4:
                profile_image="women_avatar_4";
                break;
            case R.id.women_image_5:
                profile_image="women_avatar_5";
                break;
        }
    }
}