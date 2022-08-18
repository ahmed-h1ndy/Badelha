package com.example.badellha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class updated_profile_info extends AppCompatActivity {
    String username,city,email,phone_number;
    EditText username_text_view,city_text_view,email_text_view,phone_number_text_view;
    Button update_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updated_profile_info);

        //get views

        username_text_view=findViewById(R.id.update_my_username);
        city_text_view=findViewById(R.id.update_my_city);
        email_text_view=findViewById(R.id.update_my_email_address);
        phone_number_text_view=findViewById(R.id.update_my_phone_number);
        update_button=findViewById(R.id.update_button);

        //get passed data,explained before

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = extras.getString("username");
            city = extras.getString("city");
            email = extras.getString("email");
            phone_number = extras.getString("phone_number");
        }

        //set views value to our data

        username_text_view.setText(username);
        city_text_view.setText(city);
        email_text_view.setText(email);
        phone_number_text_view.setText(phone_number);


        //when update is clicked we update user info in db and then go back to profile activity

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Baddelha_database db=new Baddelha_database(getApplicationContext());

                String updated_user_name=username_text_view.getText().toString();
                String updated_city=city_text_view.getText().toString();
                String updated_email=email_text_view.getText().toString();
                String updated_phone_number=phone_number_text_view.getText().toString();

                User user=db.get_user(User.getCurrent_user_email());
                String gender=user.getUSER_GENDER();
                String password=user.getUSER_PASSWORD();
                String image=user.getUSER_IMAGE();

                db.update_profile(updated_user_name,password,updated_city,gender,updated_phone_number,image,updated_email);

                Intent i=new Intent(getApplicationContext(),my_profile.class);
                startActivity(i);
            }
        });



    }
}