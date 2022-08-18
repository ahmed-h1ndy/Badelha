package com.example.badellha;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Requests_activity extends AppCompatActivity {
    String sender,product_id,category,description,image;
    TextView category_text_view,description_text_view;
    Button request_button;
    ImageView request_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        Baddelha_database db=new Baddelha_database(this);
        User user=db.get_user(User.getCurrent_user_email());

        ArrayList<Request> requests_list=db.get_all_requests(user.getUSER_EMAIL(),user.getUSER_PASSWORD());
        for(int i=0;i<requests_list.size();i++)
        {
             sender=requests_list.get(i).getREQUEST_SENDER();
             product_id=requests_list.get(i).getREQUEST_PRODUCT_ID();
             add_request(sender,product_id);
        }
    }


    public void add_request(String sender, String product_id)
    {
        Baddelha_database db=new Baddelha_database(getApplicationContext());

        //already explained in home_activity, go back there

        LinearLayout parent = findViewById(R.id.requests);
        View view = LayoutInflater.from(this).inflate(R.layout.request,parent,false);
        LinearLayout item = view.findViewById(R.id.requests);
        parent.addView(view);

        //get product data

        Product p=db.get_product(product_id);
        category=p.getPRODUCT_CATEGORY();
        description=p.getPRODUCT_DESCRIPTION();
        image=p.getPRODUCT_IMAGE();

        //get views data from xml

        category_text_view=view.findViewById(R.id.request_category);
        description_text_view=view.findViewById(R.id.request_description);
        request_button=view.findViewById(R.id.request_accept);
        request_image=view.findViewById(R.id.request_image);

        //set request values from the given data

        category_text_view.setText(category);
        description_text_view.setText(description);

        //already explained in home_activity

        int resId = getResources().getIdentifier(image, "drawable", getPackageName());
        request_image.setImageResource(resId);

        //if the user has sent the request he can cancel it only
        //if he received it he can accept it only
        //that's actually dum, if you guys can change it that would be really great xDDDD

        if(sender.equals(User.getCurrent_user_email()))
        {
            request_button.setText("Cancel");
            request_button.setBackgroundColor(Color.RED);
        }

        //send request button

        request_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.delete_request(product_id);
                recreate();
            }
        });

    }
}