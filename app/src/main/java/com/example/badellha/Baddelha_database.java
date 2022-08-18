package com.example.badellha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Baddelha_database extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DATABASE_NAME="baddelha.db";

    private static final String TABLE_USER="user";
    private static final String TABLE_PRODUCT="product";
    private static final String TABLE_REQUEST="request";

    private static final String USER_NAME="name";
    private static final String USER_PASSWORD="password";
    private static final String USER_PHONE_NUMBER="phone_number";
    private static final String USER_EMAIL="email";
    private static final String USER_CITY="city";
    private static final String USER_GENDER="gender";
    private static final String USER_IMAGE="image";

    private static final String PRODUCT_CATEGORY="category";
    private static final String PRODUCT_DESCRIPTION="description";
    private static final String PRODUCT_IMAGE="image";
    private static final String PRODUCT_OWNER="owner";
    private static final String PRODUCT_CITY="city";
    private static final String PRODUCT_ID="id";

    private static final String REQUEST_SENDER="sender";
    private static final String REQUEST_RECEIVER="receiver";
    private static final String REQUEST_PRODUCT_ID="product_id";


    public Baddelha_database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE="CREATE TABLE "+TABLE_USER+"("
                +USER_EMAIL+" TEXT PRIMARY KEY,"
                +USER_NAME+" TEXT,"
                +USER_PASSWORD+" TEXT,"
                +USER_PHONE_NUMBER+" TEXT,"
                +USER_CITY+" TEXT,"
                +USER_GENDER+" TEXT,"
                +USER_IMAGE+" TEXT"+")";

        String CREATE_PRODUCT_TABLE="CREATE TABLE "+TABLE_PRODUCT+"("
                +PRODUCT_ID+" TEXT PRIMARY KEY,"
                +PRODUCT_CATEGORY+" TEXT,"
                +PRODUCT_DESCRIPTION+" TEXT,"
                +PRODUCT_IMAGE+" TEXT,"
                +PRODUCT_OWNER+" TEXT,"
                +PRODUCT_CITY+" TEXT"+")";

        String CREATE_REQUEST_TABLE="CREATE TABLE "+TABLE_REQUEST+"("
                +REQUEST_PRODUCT_ID+" TEXT PRIMARY KEY,"
                +REQUEST_SENDER+" TEXT,"
                +REQUEST_RECEIVER+" TEXT"+")";


        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_PRODUCT_TABLE);
        db.execSQL(CREATE_REQUEST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_PRODUCT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_REQUEST);
        onCreate(db);
    }

        //fetch function ( database -> cursor )

    public Cursor fetch_table(String table_name)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String FETCH_TABLE="SELECT * FROM "+table_name;
        Cursor values;
        values=db.rawQuery(FETCH_TABLE,null);
        values.moveToFirst();
        db.close();
        return values;
    }

    //fetch function ( database -> cursor )

    public Cursor fetch_user(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String FETCH_USER="SELECT * FROM "+TABLE_USER+" WHERE "+USER_EMAIL+" LIKE ?";
        Cursor user;
        user=db.rawQuery(FETCH_USER,new String[]{email});
        return user;
    }

    //fetch function ( database -> cursor )

    public Cursor fetch_product(String product_id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String FETCH_PRODUCT="SELECT * FROM "+TABLE_PRODUCT+" WHERE "+PRODUCT_ID+" LIKE ?";
        Cursor product;
        product=db.rawQuery(FETCH_PRODUCT,new String[]{product_id});
        return product;
    }

    //fetch function ( database -> cursor )

    public Cursor fetch_request(String request_product_id)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String FETCH_REQUEST="SELECT * FROM "+TABLE_REQUEST+" WHERE "+REQUEST_PRODUCT_ID+" LIKE ?";
        Cursor request;
        request=db.rawQuery(FETCH_REQUEST,new String[]{request_product_id});
        return request;
    }


    // useful function for register function
    // we want to be sure that no email is used twice ( unique email for each user )

    public boolean this_user_exists(String email)
    {
        Cursor values=fetch_table(TABLE_USER);
        String db_emails;
        if(values.moveToFirst())
        {
            do
            {
                db_emails=values.getString(0);
                if(db_emails.equals(email))
                    return true;

            }   while(values.moveToNext());

        }
        return false;
    }

    // register function
    // first check if the email is used before
    // if not insert into the user table a new user
    // if registration were completed a true will be returned
    // else a false will be returned

     public boolean register_a_user(String name,String password,String city,String gender,String phone_number,String email,String image)
     {
         if(this_user_exists(email))
             return false;
         else
         {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(USER_NAME,name);
             values.put(USER_PASSWORD,password);
             values.put(USER_CITY,city);
             values.put(USER_GENDER,gender);
             values.put(USER_PHONE_NUMBER,phone_number);
             values.put(USER_EMAIL,email);
             values.put(USER_IMAGE,image);
             db.insert(TABLE_USER,null,values);
             db.close();
             return true;
         }
     }

     // login function
     // compares email,string passed as parameters to database values
     // if a matching occurs the user logs in and the function returns true
     // else the function returns false

    public boolean login(String email,String password)
    {
        Cursor values=fetch_table(TABLE_USER);
        String db_emails,db_passwords;
        if(values.moveToFirst())
        {
            do
            {
                db_emails=values.getString(0);
                db_passwords=values.getString(2);
                if(email.equals(db_emails)&&password.equals(db_passwords))
                {
                    return true;
                }

            }while(values.moveToNext());
        }
        return false;
    }

    // function that returns all products in the database

    public ArrayList<Product> get_all_products()
    {
        ArrayList products_list=new ArrayList<Product>();
         String PRODUCT_CATEGORY;
         String PRODUCT_DESCRIPTION;
         String PRODUCT_IMAGE;
         String PRODUCT_OWNER;
         String PRODUCT_CITY;
         String PRODUCT_ID;
         Cursor values=fetch_table(TABLE_PRODUCT);

         if(values.moveToFirst())
         {
             do
             {
                 PRODUCT_ID=values.getString(0);
                 PRODUCT_CATEGORY=values.getString(1);
                 PRODUCT_DESCRIPTION=values.getString(2);
                 PRODUCT_IMAGE=values.getString(3);
                 PRODUCT_OWNER=values.getString(4);
                 PRODUCT_CITY=values.getString(5);
                 Product product=new Product(PRODUCT_CATEGORY,PRODUCT_DESCRIPTION,PRODUCT_IMAGE,PRODUCT_OWNER,PRODUCT_CITY,PRODUCT_ID);
                 products_list.add(product);
             }while(values.moveToNext());
         }
         return products_list;
    }

    // function that returns all requests in the database

    public ArrayList<Request> get_all_requests(String email,String password)
    {
        ArrayList requests_list=new ArrayList<Request>();
            String REQUEST_PRODUCT_ID;
            String REQUEST_SENDER;
            String REQUEST_RECEIVER;
            Cursor values=fetch_table(TABLE_REQUEST);
            if(values.moveToFirst())
            {
                do
                {
                    REQUEST_PRODUCT_ID=values.getString(0);
                    REQUEST_SENDER=values.getString(1);
                    REQUEST_RECEIVER=values.getString(2);
                    if(email.equals(REQUEST_SENDER)||email.equals(REQUEST_RECEIVER))
                    {
                        Request request=new Request(REQUEST_SENDER,REQUEST_RECEIVER,REQUEST_PRODUCT_ID);
                        requests_list.add(request);
                    }
                }while(values.moveToNext());
            }
            return requests_list;
    }

    // function to send a request ( inserts a new request in the database )


    public void send_request(String product_id,String receiver,String sender)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(REQUEST_PRODUCT_ID,product_id);
        values.put(REQUEST_SENDER,sender);
        values.put(REQUEST_RECEIVER,receiver);
        db.insert(TABLE_REQUEST,null,values);
        db.close();
    }

    // function to create new post (product in home page)

    public void create_post(String owner,String category,String city,String description,String image,String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(PRODUCT_OWNER,owner);
        values.put(PRODUCT_CATEGORY,category);
        values.put(PRODUCT_CITY,city);
        values.put(PRODUCT_DESCRIPTION,description);
        values.put(PRODUCT_IMAGE,image);
        values.put(PRODUCT_ID,id);
        db.insert(TABLE_PRODUCT,null,values);
        db.close();
    }

    //function to update your profile

    public void update_profile(String name,String password,String city,String gender,String phone_number,String image,String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(USER_NAME,name);
        values.put(USER_PASSWORD,password);
        values.put(USER_CITY,city);
        values.put(USER_GENDER,gender);
        values.put(USER_PHONE_NUMBER,phone_number);
        values.put(USER_EMAIL,email);
        values.put(USER_IMAGE,image);
        db.update(TABLE_USER,values,USER_EMAIL+" like ?",new String[]{email});
    }

    public void delete_post(String product_id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_PRODUCT,PRODUCT_ID+" like ?",new String[]{product_id});
    }

    public void delete_request(String request_product_id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_REQUEST,REQUEST_PRODUCT_ID+" like ?",new String[]{request_product_id});
    }

    // function to fetch data from ( user table -> cursor )
    // and then from ( cursor -> User class reference ) and returns the user
    // it needs user_email to get the user ( because user_email  is a primary key in user table )

    public User get_user(String email)
    {

        Cursor values=fetch_user(email);

        if(values.moveToFirst())

        {String USER_EMAIL=values.getString(0);
                String USER_NAME=values.getString(1);
                String USER_PASSWORD=values.getString(2);
                String USER_PHONE_NUMBER=values.getString(3);
                String USER_CITY=values.getString(4);
                String USER_GENDER=values.getString(5);
                String USER_IMAGE=values.getString(6);
            User user=new User(USER_NAME,USER_PASSWORD,USER_PHONE_NUMBER,USER_EMAIL,USER_CITY,USER_GENDER,USER_IMAGE);
            return user;
        }
        return null;




    }

    // function to fetch data from ( products table -> cursor )
    // and then from ( cursor -> Product class reference ) and returns the product
    // it needs product id to get the product ( because product id is a primary key in product table )

    public Product get_product(String product_id)
    {
        Cursor values=fetch_product(product_id);
        values.moveToFirst();
        String PRODUCT_ID=values.getString(0);
        String PRODUCT_CATEGORY=values.getString(1);
        String PRODUCT_DESCRIPTION=values.getString(2);
        String PRODUCT_IMAGE=values.getString(3);
        String PRODUCT_OWNER=values.getString(4);
        String PRODUCT_CITY=values.getString(5);
        Product product=new Product(PRODUCT_CATEGORY,PRODUCT_DESCRIPTION,PRODUCT_IMAGE,PRODUCT_OWNER,PRODUCT_CITY,PRODUCT_ID);
        return product;



    }

    // function to fetch data from ( requests table -> cursor )
    // and then from ( cursor -> Request class reference ) and returns the request
    // it needs product id to get the request
    // ( because product id is a primary key in request table as well as product table )

    public Request get_request(String request_product_id)
    {
        Cursor values=fetch_product(request_product_id);
        values.moveToFirst();
        String REQUEST_PRODUCT_ID=values.getString(0);
        String REQUEST_SENDER=values.getString(1);
        String REQUEST_RECEIVER=values.getString(2);
        Request request =new Request(REQUEST_SENDER,REQUEST_RECEIVER,REQUEST_PRODUCT_ID);
        return request;
    }

    //function that returns number of products

    public int get_products_count()
    {
        Cursor count=fetch_table(TABLE_PRODUCT);
        return count.getCount();
    }

    //function that returns the biggest id (we will use it later when we create new products)
    public int get_highest_id()
    {
        ArrayList<Product> product_list=get_all_products();
        int highest=-1;
        for(int i=0;i<product_list.size();i++)
        {
            if(Integer.parseInt(product_list.get(i).getPRODUCT_ID())>highest)
                highest=Integer.parseInt(product_list.get(i).getPRODUCT_ID());
        }
        return highest;
    }
}
