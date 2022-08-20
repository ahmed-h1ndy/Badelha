package com.example.badellha;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class product_activity extends AppCompatActivity {

    Button delete,send_request;
    TextView category_text_view,description_text_view,owner_text_view,city_text_view;
    String category="none";
    String description ="none";
    String image;
    String owner="none";
    String city="none";
    String id="none";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity);

        //already explained in other_person_account, go back there

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            category = extras.getString("category");
            description = extras.getString("description");
            image = extras.getString("image");
            owner = extras.getString("owner");
            city = extras.getString("city");
            id=extras.getString("id");
        }

        //already explained in home_activity, go back there

        LinearLayout parent = findViewById(R.id.show_product);
        View view = LayoutInflater.from(this).inflate(R.layout.product_preview,parent,false);
        LinearLayout item = view.findViewById(R.id.show_product);
        parent.addView(view);
        Baddelha_database db=new Baddelha_database(this);

        //get views xml -> java

        delete=view.findViewById(R.id.product_delete);
        send_request=view.findViewById(R.id.send_request_button);
        category_text_view=view.findViewById(R.id.product_category);
        description_text_view=view.findViewById(R.id.product_description);
        owner_text_view=view.findViewById(R.id.product_owner);
        city_text_view=view.findViewById(R.id.product_city);

        // set views value to the product's values

        category_text_view.setText(category);
        description_text_view.setText(description);
        owner_text_view.setText(owner);
        city_text_view.setText(city);

        // already explained in home_activity, go back there
        if(image!=null) {
            int resId = getResources().getIdentifier(image, "drawable", getPackageName());
            ImageView product_image_view = view.findViewById(R.id.product_image);
            product_image_view.setImageResource(resId);
        }
        // i couldn't implement delete product and send request buttons from the product activity itself xDDD
        // so i just set them to invisible to disable their functionality
        // sorry guys xD
        //i would appreciate it if you try implement it
        send_request.setVisibility(View.INVISIBLE);
        delete.setVisibility(View.INVISIBLE);
    }
}