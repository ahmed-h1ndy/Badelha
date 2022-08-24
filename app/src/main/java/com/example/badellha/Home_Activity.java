package com.example.badellha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity {

    Button delete,send_request_button;
    TextView category_text_view,description_text_view,owner_text_view,city_text_view;
    String id,category,description,image,owner,city;
    ImageView product_image_view;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize_products_from_db();
    }

    public void initialize_products_from_db()
    {
        Baddelha_database db=new Baddelha_database(this);

        ArrayList<Product> product_list=db.get_all_products();
        for(int i=0;i<product_list.size();i++)
        {
            category=product_list.get(i).getPRODUCT_CATEGORY();
            description=product_list.get(i).getPRODUCT_DESCRIPTION();
            image=product_list.get(i).getPRODUCT_IMAGE();
            owner=product_list.get(i).getPRODUCT_OWNER();
            city=product_list.get(i).getPRODUCT_CITY();
            id=product_list.get(i).getPRODUCT_ID();
            add_product_from_db(category,description,image,owner,city,id);
        }
        Product.setProducts_count(db.get_highest_id());
    }

    public void add_product_from_db(String category,String description,String image,String owner,String city,String id)
    {

        // these are dynamic views lines
        // first we get parent layout
        // then the child that we want to add
        // and we add that child to parent
        GridLayout parent = findViewById(R.id.products_grid);
        View view = LayoutInflater.from(this).inflate(R.layout.product,parent,false);
        parent.addView(view);

        //get views
         product_image_view=view.findViewById(R.id.product_image);
         category_text_view=view.findViewById(R.id.product_category);
         description_text_view=view.findViewById(R.id.product_description);
         owner_text_view=view.findViewById(R.id.product_owner);
         city_text_view=view.findViewById(R.id.product_city);

         //set their value to the user's choices
         category_text_view.setText(category);
         description_text_view.setText(description);
         owner_text_view.setText(owner);
         city_text_view.setText(city);

         // these two lines set the product image to an image named with the string we gave
         // if we gave it (picture_1) it will look the drawable file for an image called picture_1
        // and then set the product image to that image

        int resId = getResources().getIdentifier(image, "drawable", getPackageName());
        product_image_view.setImageResource(resId);



        //buttons on click (they are self explanatory i wont explain what they do guys xD

        owner_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_to_owner_profile(owner);
            }
        });


        product_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_to_product_activity(category,description,image,owner,city,id);
            }
        });


        delete=view.findViewById(R.id.product_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete_my_post(id);
            }
        });


        send_request_button=view.findViewById(R.id.send_request_button);
        send_request_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send_request(id,owner);
            }
        });

        city_text_view.setTextColor(Color.RED);

    }

    public void go_to_owner_profile(String owner)
    {
        // explained before
        Baddelha_database db=new Baddelha_database(getApplicationContext());
        Intent go_to_his_profile=new Intent(getApplicationContext(),other_person_account.class);
        User user=db.get_user(owner);
        go_to_his_profile.putExtra("username",user.getUSER_NAME());
        go_to_his_profile.putExtra("city",user.getUSER_CITY());
        go_to_his_profile.putExtra("email",user.getUSER_EMAIL());
        go_to_his_profile.putExtra("phone_number",user.getUSER_PHONE_NUMBER());
        go_to_his_profile.putExtra("image",user.getUSER_IMAGE());
        startActivity(go_to_his_profile);
    }
    public void go_to_product_activity(String category,String description,String image,String owner,String city,String id)
    {
        //pass information to the product activity

        Intent i=new Intent(getApplicationContext(), product_activity.class);
        i.putExtra("category",category);
        i.putExtra("description",description);
        i.putExtra("image",image);
        i.putExtra("owner",owner);
        i.putExtra("city",city);
        i.putExtra("id",id);
        startActivity(i);
    }
    public void send_request(String id,String owner) {
        Baddelha_database db=new Baddelha_database(getApplicationContext());
        String sender=User.getCurrent_user_email();
        String receiver=owner;
        String product_id=id;
        db.send_request(product_id,receiver,sender);

    }
    public void delete_my_post(String id) {
        Baddelha_database db=new Baddelha_database(getApplicationContext());
        db.delete_post(id);
        db.delete_request(id);
        recreate();
    }
}