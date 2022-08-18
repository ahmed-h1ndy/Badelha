package com.example.badellha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class other_person_account extends AppCompatActivity {

    String username="null";
    String image="null";
    String city="null";
    String email="null";
    String phone_number="null";
    TextView username_text_view,city_text_view,email_text_view,phone_number_text_view;
    ImageView profile_picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_person_account);

        //get views xml -> java
        username_text_view=findViewById(R.id.his_name);
        city_text_view=findViewById(R.id.his_city);
        email_text_view=findViewById(R.id.his_email_address);
        phone_number_text_view=findViewById(R.id.his_phone_number);
        profile_picture=findViewById(R.id.his_profile_picture);

        // if you clicked on other person's profile we open his profile activity
        // but before we open it .. we pass to it all the values related to that user
        // and here we retrieve the sent data to this activity

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = extras.getString("username");
            image = extras.getString("image");
            city = extras.getString("city");
            email = extras.getString("email");
            phone_number = extras.getString("phone_number");
        }

        // lets set the views value to that other person's profile information

        username_text_view.setText(username);
        city_text_view.setText(city);
        email_text_view.setText(email);
        phone_number_text_view.setText(phone_number);

        //already explained in home_activity, go back there

        int resId = getResources().getIdentifier("ic_"+image, "drawable", getPackageName());
        profile_picture.setImageResource(resId);

    }
}