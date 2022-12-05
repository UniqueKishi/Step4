package com.example.step4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Addtrail extends AppCompatActivity {
EditText namee, late, lone, diste;
String name;
Double lat, lon, dist;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trail);
        namee = (EditText) (findViewById(R.id.editTextName));
        late = (EditText) (findViewById(R.id.editTextLat));
        lone = (EditText) (findViewById(R.id.editTextLong));
        diste = (EditText) (findViewById(R.id.editTextDist));




    }

    public void submit(View view){

        name = namee.getText().toString();
        try {


            lat = Double.valueOf(late.getText().toString());
            lon = Double.valueOf(lone.getText().toString());
            dist = Double.valueOf(diste.getText().toString());
        } catch(Exception e){
            Toast.makeText(this, "Incorrect input", Toast.LENGTH_SHORT).show();
        }


    }



}