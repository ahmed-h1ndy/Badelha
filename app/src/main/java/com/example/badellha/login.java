package com.example.badellha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
EditText email_textView,password_textView;
ImageView visible_imageView;
Button login_button,register_button;
TextView forgot_password_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // get views from xml -> java

        email_textView=findViewById(R.id.email_input);
        password_textView=findViewById(R.id.password_input);
        visible_imageView=findViewById(R.id.visible);
        login_button=findViewById(R.id.login_button);
        register_button=findViewById(R.id.go_to_register_button);
        forgot_password_button=findViewById(R.id.forget);
    }

    // when you click register button this function executes

    public void register(View v)
    {
        Intent register_page=new Intent(this,Registeration.class);
        startActivity(register_page);
    }

    // when you click login button this function executes

    public void login(View v)
    {
        Baddelha_database db=new Baddelha_database(this);
        //code to get info from edit texts

        String email_info=email_textView.getText().toString();
        String password_info=password_textView.getText().toString();

        //code to check the validation of the info
        if(db.login(email_info,password_info))
        {
            go_to_home_page();
            User.setCurrent_user_email(email_info);
        }
        else
        {
            Toast.makeText(this, "Something went wrong, Please try again!", Toast.LENGTH_SHORT).show();
        }


        //code to login/error


    }

    // if you registered/loged in successfully you will go to home page

    public void go_to_home_page()
    {
        Intent home_page=new Intent(this, Home_Activity.class);
        startActivity(home_page);
    }
}