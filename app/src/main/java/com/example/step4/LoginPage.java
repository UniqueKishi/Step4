package com.example.step4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginPage extends AppCompatActivity {

    static ArrayList<Account> accounts;
    static AccountList lOA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        createDB();
    }

    public void login(View v){//login button
        EditText user=(EditText) findViewById(R.id.userN);
        EditText pass=(EditText) findViewById(R.id.pass);
        String userS=user.getText().toString();
        String passS=pass.getText().toString();//getting user and pass fields

        lOA = lOA.readAccs(getApplicationContext()); //get list of accounts
        accounts = lOA.getAccountList();

        if (userS.equals("admin")) {
            for(int i = 0; i < accounts.size() ; i++){
                //if there is already a user with the given username then don't make account and give a toast
                if(userS.equals(accounts.get(i).getUserName()) ){
                    if( passS.equals(accounts.get(i).getPassWord())){
                        Intent intent= new Intent(this, MapsActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Password is incorrect", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }else{
            for(int i = 0; i < accounts.size() ; i++){
                //check if there is a user with the username and see if it matches the given
                if(userS.equals(accounts.get(i).getUserName()) ){
                    //Check if password is equal to the one on the account with correct username
                    if( passS.equals(accounts.get(i).getPassWord())){
                        Intent intent= new Intent(this, MapsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("userN" , userS);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        return;
                    }else{
                        Toast.makeText(getApplicationContext(), "Password is incorrect", Toast.LENGTH_LONG).show();
                    }
                }
            }
            Toast.makeText(getApplicationContext(), "There is no user with given username", Toast.LENGTH_LONG).show();
        }
    }

    public void makeAcc(View v){//make account button
        EditText user=(EditText) findViewById(R.id.userN);
        EditText pass=(EditText) findViewById(R.id.pass);
        String userS=user.getText().toString();
        String passS=pass.getText().toString();//getting user and pass fields
        lOA = lOA.readAccs(getApplicationContext()); //get list of accounts
        accounts = lOA.getAccountList();
        boolean makeAcc = false;  //if set to true there is already an account with this user so don't make one


        for(int i = 0; i < accounts.size() ; i++){
            //if there is already a user with the given username then dont make account and give a toast
            if(userS.equals(accounts.get(i).getUserName())){
                Toast.makeText(getApplicationContext(), "There is already an account with the given username", Toast.LENGTH_LONG).show();
                makeAcc = true;
            }
        }

        if(userS.isEmpty()){
            Toast.makeText(getApplicationContext(), "Please enter desired information to make an account", Toast.LENGTH_LONG).show();

        } else if(makeAcc == false){
            //If there is no user with the given username than make account and log them in
            Account newA = new Account(userS, passS, false);
            accounts.add(newA);
            lOA = new AccountList(accounts);
            //rewrite the list so it saves with the new account
            lOA.writeAccToFile(lOA, getApplicationContext());
            //pass the user through to the user view
            Intent intent= new Intent(this, MapsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("userN" , userS);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }


    public void createDB() {
        accounts = new ArrayList<Account>();

        lOA = lOA.readAccs(getApplicationContext());

        ArrayList<Account> listOfAccounts;
        listOfAccounts = lOA.getAccountList();



        if(listOfAccounts == null ||listOfAccounts.isEmpty()){
            Account admin = new Account("admin", "pass", true);
            Account test = new Account("Test", "TestPass");
            accounts.add(admin);
            accounts.add(test);
            lOA = new AccountList(accounts);
            lOA.writeAccToFile(lOA, getApplicationContext());
        }
    }
}