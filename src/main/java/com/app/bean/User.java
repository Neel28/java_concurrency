package com.app.bean;

public class User {

    private int id;
    private String name;
    private String emailAddress;

    public int getId(){ return id;}
    public String getName(){return name;}
    public String getEmailAddress(){return emailAddress;}

    public void setId(int id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setEmailAddress(String emailAddress){this.emailAddress = emailAddress;}
}
