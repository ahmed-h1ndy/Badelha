package com.example.badellha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class create_new_post extends AppCompatActivity {
    String city="cairo";
    String category="Headphone";
    String image="product_1";
    String owner=User.getCurrent_user_email();
    Spinner category_spinner,city_spinner;
    EditText description_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_post);

        // get views from xml -> java to control them

         description_text_view=findViewById(R.id.product_description_post);
         category_spinner=findViewById(R.id.product_category_post);
         city_spinner=findViewById(R.id.product_city_post);

         // lets get which city the user choose and store it in our city variable

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

        // lets get which category the user choose and store it in our category variable

        category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String value = getResources().getStringArray(R.array.categories)[pos];
                category=value;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // when he pushed the create button, lets create the product
        // first add the product to our database
        // and then increase product count by one
        // adding the product to the database automatically adds it to homepage activity
        // when we go to home activity we will fin our created product

        ((Button)findViewById(R.id.create_post_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Baddelha_database db=new Baddelha_database(getApplicationContext());
                String description=description_text_view.getText().toString();
                //create post with given values
                db.create_post(owner,category,city,description,image,String.valueOf(Product.getProducts_count()+1));
                Product.setProducts_count(Product.getProducts_count()+1);
                Toast.makeText(getApplicationContext(),"Post Created!",Toast.LENGTH_SHORT).show();
                //go to home page
                Intent intent=new Intent(getApplicationContext(),Home_Activity.class);
                startActivity(intent);
            }
        });
            //default product is product_1, so i highlighted the first product by default
        TextView v=findViewById(R.id.prod_img_1);
        highlight_img(v);

    }

    // function that gets which image was chosen by user
    // we assign the on click attribute of all images to this exact function
    // and when any of them gets clicked, the function runs
    // and the switch case gets which image was clicked
    // and sets image variable to the correct value

    public void get_image(View view) {

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.product_1:
                image="product_1";
                //highlighting the product
                TextView v1=findViewById(R.id.prod_img_1);
                highlight_img(v1);
                break;
            case R.id.product_2:
                image="product_2";
                //highlighting the product
                TextView v2=findViewById(R.id.prod_img_2);
                highlight_img(v2);
                break;
            case R.id.product_3:
                image="product_3";
                //highlighting the product
                TextView v3=findViewById(R.id.prod_img_3);
                highlight_img(v3);
                break;
            case R.id.product_4:
                image="product_4";
                //highlighting the product
                TextView v4=findViewById(R.id.prod_img_4);
                highlight_img(v4);
                break;
            case R.id.product_5:
                image="product_5";
                //highlighting the product
                TextView v5=findViewById(R.id.prod_img_5);
                highlight_img(v5);
                break;
            case R.id.product_6:
                image="product_6";
                //highlighting the product
                TextView v6=findViewById(R.id.prod_img_6);
                highlight_img(v6);
                break;
            case R.id.product_7:
                image="product_7";
                //highlighting the product
                TextView v7=findViewById(R.id.prod_img_7);
                highlight_img(v7);
                break;
            case R.id.product_8:
                image="product_8";
                //highlighting the product
                TextView v8=findViewById(R.id.prod_img_8);
                highlight_img(v8);
                break;
            case R.id.product_9:
                image="product_9";
                //highlighting the product
                TextView v9=findViewById(R.id.prod_img_9);
                highlight_img(v9);
                break;
            case R.id.product_10:
                image="product_10";
                //highlighting the product
                TextView v10=findViewById(R.id.prod_img_10);
                highlight_img(v10);
                break;
        }
    }
    public void highlight_img(TextView v)
    {
        //first make all products highlight color to -> white
        ((TextView)findViewById(R.id.prod_img_1)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.prod_img_2)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.prod_img_3)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.prod_img_4)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.prod_img_5)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.prod_img_6)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.prod_img_7)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.prod_img_8)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.prod_img_9)).setBackgroundColor(Color.WHITE);
        ((TextView)findViewById(R.id.prod_img_10)).setBackgroundColor(Color.WHITE);

        //then set the background color of the chosen product to -> green
        v.setBackgroundColor(Color.GREEN);
    }
}