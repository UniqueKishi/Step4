package com.example.step4;

import java.io.Serializable;

//This will be used to make and store information about accounts
public class Account implements Serializable{
    String userName, passWord;
    Boolean isAdmin;

    public Account() {
        userName = null;
        passWord = null;
        isAdmin = false;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    //This will be used for creating the account when the user gives information
    public Account(String userName,String passWord){
        this.userName = userName;
        this.passWord = passWord;
        isAdmin = false;
    }

    public Account(String userName,String passWord, Boolean isAdmin){
        this.userName = userName;
        this.passWord = passWord;
        this.isAdmin = isAdmin;
    }
}
