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
import android.widget.TextView;
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
        TextView men_img=findViewById(R.id.img_1);
        highlight_img(men_img);

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
                    String profile_image="men_avatar_1";
                    TextView men_img=findViewById(R.id.img_1);
                    highlight_img(men_img);
                    break;
                }
            case R.id.radio_female:
                if (checked)
                {
                    gender="female";
                    ((LinearLayout)findViewById(R.id.women_images)).setVisibility(View.VISIBLE);
                    ((LinearLayout)findViewById(R.id.men_images)).setVisibility(View.INVISIBLE);
                    String profile_image="women_avatar_1";
                    TextView women_img=findViewById(R.id.img_1);
                    highlight_img(women_img);
                    break;
                }
        }
    }

    public void get_image(View view) {

        // check which image was clicked

        switch(view.getId()) {
            case R.id.men_image_1:
                profile_image="men_avatar_1";
                //highlighting the pic chosen
                TextView v1=findViewById(R.id.img_1);
                highlight_img(v1);
                Toast.makeText(getApplicationContext(),"Nice Choice!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.men_image_2:
                profile_image="men_avatar_2";
                //highlighting the pic chosen
                TextView v2=findViewById(R.id.img_2);
                highlight_img(v2);
                Toast.makeText(getApplicationContext(),"Nice Choice!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.men_image_3:
                profile_image="men_avatar_3";
                //highlighting the pic chosen
                TextView v3=findViewById(R.id.img_3);
                highlight_img(v3);
                Toast.makeText(getApplicationContext(),"Nice Choice!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.men_image_4:
                profile_image="men_avatar_4";
                //highlighting the pic chosen
                TextView v4=findViewById(R.id.img_4);
                highlight_img(v4);
                Toast.makeText(getApplicationContext(),"Nice Choice!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.men_image_5:
                profile_image="men_avatar_5";
                //highlighting the pic chosen
                TextView v5=findViewById(R.id.img_5);
                highlight_img(v5);
                Toast.makeText(getApplicationContext(),"Nice Choice!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.women_image_1:
                profile_image="women_avatar_1";
                //highlighting the pic chosen
                TextView v6=findViewById(R.id.img_1);
                highlight_img(v6);
                Toast.makeText(getApplicationContext(),"Nice Choice!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.women_image_2:
                profile_image="women_avatar_2";
                //highlighting the pic chosen
                TextView v7=findViewById(R.id.img_2);
                highlight_img(v7);
                Toast.makeText(getApplicationContext(),"Nice Choice!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.women_image_3:
                profile_image="women_avatar_3";
                //highlighting the pic chosen
                TextView v8=findViewById(R.id.img_3);
                highlight_img(v8);
                Toast.makeText(getApplicationContext(),"Nice Choice!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.women_image_4:
                profile_image="women_avatar_4";
                //highlighting the pic chosen
                TextView v9=findViewById(R.id.img_4);
                highlight_img(v9);
                Toast.makeText(getApplicationContext(),"Nice Choice!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.women_image_5:
                profile_image="women_avatar_5";
                //highlighting the pic chosen
                TextView v10=findViewById(R.id.img_5);
                highlight_img(v10);
                Toast.makeText(getApplicationContext(),"Nice Choice!",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void highlight_img(TextView v)
    {
        //first set all profile pics highlighting to -> white
        ((TextView)findViewById(R.id.img_1)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.img_2)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.img_3)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.img_4)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.img_5)).setBackgroundColor(Color.WHITE);

        //then set the chosen pic highlight to -> green
        v.setBackgroundColor(Color.GREEN);

    }
}