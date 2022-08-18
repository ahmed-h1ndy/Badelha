package com.example.badellha;

public class Request
{
    //attributes

    private String REQUEST_SENDER;
    private String REQUEST_RECEIVER;
    private String REQUEST_PRODUCT_ID;

    //constructor

    public Request(String sender,String receiver,String id)
    {
        REQUEST_SENDER=sender;
        REQUEST_RECEIVER=receiver;
        REQUEST_PRODUCT_ID=id;
    }
    //getters and setters

    public String getREQUEST_SENDER() {
        return REQUEST_SENDER;
    }

    public String getREQUEST_RECEIVER() {
        return REQUEST_RECEIVER;
    }

    public String getREQUEST_PRODUCT_ID() {
        return REQUEST_PRODUCT_ID;
    }

    public void setREQUEST_SENDER(String REQUEST_SENDER) {
        this.REQUEST_SENDER = REQUEST_SENDER;
    }

    public void setREQUEST_RECEIVER(String REQUEST_RECEIVER) {
        this.REQUEST_RECEIVER = REQUEST_RECEIVER;
    }

    public void setREQUEST_PRODUCT_ID(String REQUEST_PRODUCT_ID) {
        this.REQUEST_PRODUCT_ID = REQUEST_PRODUCT_ID;
    }

}
