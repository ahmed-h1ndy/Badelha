package com.example.badellha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class my_profile extends AppCompatActivity {
TextView username,city,email,phone_number;
Button edit_button;
ImageView profile_picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        Baddelha_database db=new Baddelha_database(this);

        // get views from xml -> java
        username=findViewById(R.id.my_username);
        city=findViewById(R.id.my_city);
        email=findViewById(R.id.my_email_address);
        phone_number=findViewById(R.id.my_phone_number);
        profile_picture=findViewById(R.id.my_profile_picture);
        edit_button=findViewById(R.id.edit_button);

        // set the views values to the user's information
        String current_user_email=User.getCurrent_user_email();
        User user=db.get_user(current_user_email);
        username.setText(user.getUSER_NAME());
        city.setText(user.getUSER_CITY());
        email.setText(user.getUSER_EMAIL());
        phone_number.setText(user.getUSER_PHONE_NUMBER());

        //already explained in home activity
        // go back to home_activity if you don't understand what these lines do

        int resId = getResources().getIdentifier("ic_"+user.getUSER_IMAGE(), "drawable", getPackageName());
        profile_picture.setImageResource(resId);

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), updated_profile_info.class);
                i.putExtra("username",user.getUSER_NAME());
                i.putExtra("city",user.getUSER_CITY());
                i.putExtra("email",user.getUSER_EMAIL());
                i.putExtra("phone_number",user.getUSER_PHONE_NUMBER());
                startActivity(i);
            }
        });
    }
}