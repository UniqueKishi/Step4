package com.example.step4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Account_info extends AppCompatActivity {
String username, name, gender;
TextView u, n,g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        username = bundle.getString("username");
        name = bundle.getString("name");
        gender = bundle.getString("gender");
        u= (TextView) findViewById(R.id.username);
        n= (TextView) findViewById(R.id.nametxt);
        g= (TextView) findViewById(R.id.gendertxt);
        u.setText(username);
        n.setText(name);
        g.setText(gender);
    }
    public void back(View view){
        Intent intent= new Intent(this, MapsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("username" , username);
        bundle.putString("name",name);
        bundle.putString("gender",gender);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}