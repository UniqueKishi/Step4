package com.example.step4;

import java.io.Serializable;

//This will be used to make and store information about accounts
public class Account implements Serializable{
    String userName, passWord, name, gender;
    Boolean isAdmin;

    public Account() {
        userName = null;
        passWord = null;
        name = null;
        gender = null;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    //This will be used for creating the account when the user gives information
    public Account(String userName,String passWord, String name, String gender){
        this.userName = userName;
        this.passWord = passWord;
        this.name = name;
        this.gender = gender;
        isAdmin = false;
    }

    public Account(String userName,String passWord, Boolean isAdmin){
        this.userName = userName;
        this.passWord = passWord;
        this.isAdmin = isAdmin;
    }
}
