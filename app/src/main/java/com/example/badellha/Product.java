package com.example.badellha;

public class Product
{
    //attributes
    private static int products_count=0;

    private String PRODUCT_CATEGORY;
    private String PRODUCT_DESCRIPTION;
    private String PRODUCT_IMAGE;
    private String PRODUCT_OWNER;
    private String PRODUCT_CITY;
    private String PRODUCT_ID;


    //constructor

    public Product(String category,String description,String image,String owner,String city,String id)
    {
        PRODUCT_CATEGORY=category;
        PRODUCT_DESCRIPTION=description;
        PRODUCT_IMAGE=image;
        PRODUCT_OWNER=owner;
        PRODUCT_CITY=city;
        PRODUCT_ID=id;
    }

    //getters and setters

    public String getPRODUCT_CATEGORY() {
        return PRODUCT_CATEGORY;
    }

    public String getPRODUCT_DESCRIPTION() {
        return PRODUCT_DESCRIPTION;
    }

    public String getPRODUCT_IMAGE() {
        return PRODUCT_IMAGE;
    }

    public String getPRODUCT_OWNER() {
        return PRODUCT_OWNER;
    }

    public String getPRODUCT_CITY() {
        return PRODUCT_CITY;
    }

    public String getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public static int getProducts_count() {
        return products_count;
    }

    public void setPRODUCT_CATEGORY(String PRODUCT_CATEGORY) {
        this.PRODUCT_CATEGORY = PRODUCT_CATEGORY;
    }

    public void setPRODUCT_DESCRIPTION(String PRODUCT_DESCRIPTION) {
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
    }

    public void setPRODUCT_IMAGE(String PRODUCT_IMAGE) {
        this.PRODUCT_IMAGE = PRODUCT_IMAGE;
    }

    public void setPRODUCT_OWNER(String PRODUCT_OWNER) {
        this.PRODUCT_OWNER = PRODUCT_OWNER;
    }

    public void setPRODUCT_CITY(String PRODUCT_CITY) {
        this.PRODUCT_CITY = PRODUCT_CITY;
    }

    public void setPRODUCT_ID(String PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public static void setProducts_count(int products_count) {
        Product.products_count = products_count;
    }
}
