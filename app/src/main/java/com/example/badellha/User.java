package com.example.badellha;

public class User
{
    //attributes

    private static String current_user_email;

    private String USER_NAME;
    private String USER_PASSWORD;
    private String USER_PHONE_NUMBER;
    private String USER_EMAIL;
    private String USER_CITY;
    private String USER_GENDER;
    private String USER_IMAGE;

    //constructor

    public User(String name, String password, String phone_number, String email, String city, String gender, String image)
    {
        USER_NAME=name;
        USER_PASSWORD=password;
        USER_EMAIL=email;
        USER_PHONE_NUMBER=phone_number;
        USER_CITY=city;
        USER_GENDER=gender;
        USER_IMAGE=image;
    }
    //getters and setters

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public String getUSER_PHONE_NUMBER() {
        return USER_PHONE_NUMBER;
    }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public String getUSER_CITY() {
        return USER_CITY;
    }

    public String getUSER_IMAGE() {
        return USER_IMAGE;
    }

    public static String getCurrent_user_email() {
        return current_user_email;
    }

    public String getUSER_GENDER() {
        return USER_GENDER;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public void setUSER_PHONE_NUMBER(String USER_PHONE_NUMBER) {
        this.USER_PHONE_NUMBER = USER_PHONE_NUMBER;
    }

    public void setUSER_EMAIL(String USER_EMAIL) {
        this.USER_EMAIL = USER_EMAIL;
    }

    public void setUSER_CITY(String USER_CITY) {
        this.USER_CITY = USER_CITY;
    }

    public void setUSER_GENDER(String USER_GENDER) {
        this.USER_GENDER = USER_GENDER;
    }

    public void setUSER_IMAGE(String USER_IMAGE) {
        this.USER_IMAGE = USER_IMAGE;
    }

    public static void setCurrent_user_email(String current_user_email) {
        User.current_user_email = current_user_email;
    }
}
