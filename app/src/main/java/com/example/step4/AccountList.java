package com.example.step4;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AccountList implements Serializable {

    ArrayList<Account> accountList;

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public AccountList(ArrayList<Account> listOfAccounts) {

        this.accountList = listOfAccounts;
    }

    public AccountList() {
        this.accountList = null;
    }

    public void writeAccToFile(AccountList lOA, Context context) {

        //Open the file to write to
        File directory = new File(context.getFilesDir().getAbsolutePath()
                + File.separator + "serlization");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filename = "accountList.srl";
        ObjectOutput out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream(directory
                    + File.separator + filename));
            //write the objects from the lOB arraylist so they are stored in the fie
            out.writeObject(lOA);
            //close the out object output stream
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static AccountList readAccs(Context context) {
        //make the object input stream and array list, along with create a string for the file name
        ObjectInputStream input = null;
        ArrayList<AccountList> lOA = null;
        String filename = "accountList.srl";
        //open the file you will read from
        File direct = new File(context.getFilesDir().getAbsolutePath() + File.separator + "serlization");

        AccountList returnList = null;
        try {
            //declare the ObjectInputStream
            input = new ObjectInputStream(new FileInputStream(direct + File.separator + filename));

            //read the arraylist from the file and store it in return list
            returnList = (AccountList) input.readObject();
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (returnList == null) {
            //if return list is null then return a empty list
            AccountList rL2 = new AccountList();
            return rL2;
        } else {
            //else return the written list
            return returnList;
        }
    }
}




