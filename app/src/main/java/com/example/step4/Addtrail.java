package com.example.step4;

import static com.example.step4.LoginPage.lOB;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Addtrail extends AppCompatActivity {
EditText namee, late, lone, diste, lengthe ;
int dist;
String name, features, ease, difficulty;
Double lat, lon, review;
Spinner spinner, spinner1, spinner2;
    ArrayList<Trails> listOfTrails;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trail);
        namee = (EditText) (findViewById(R.id.editTextName));
        late = (EditText) (findViewById(R.id.editTextLat));

        lone = (EditText) (findViewById(R.id.editTextLong));
        diste = (EditText) (findViewById(R.id.editTextDist));
        spinner = (Spinner) findViewById(R.id.spinner6);
        spinner1 = (Spinner) findViewById(R.id.spinner7);
        spinner2 = (Spinner) findViewById(R.id.spinner8);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.my_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.lvl, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);
        spinner2.setAdapter(adapter2);




        lOB = lOB.read(getApplicationContext());
        listOfTrails = lOB.getTrailList();



    }

    public void back(View view){
        Intent intent= new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void submit(View view){

        review = Math.floor(Math.random() * 5);
        name = namee.getText().toString();
        features = spinner.getSelectedItem().toString();
        ease = spinner1.getSelectedItem().toString();
        difficulty = spinner2.getSelectedItem().toString();


        try {


            lat = Double.valueOf(late.getText().toString());
            lon = Double.valueOf(lone.getText().toString());
            dist = Integer.parseInt((diste.getText().toString()));



            listOfTrails.add(new Trails( name, ease, difficulty, features, review, dist, lat, lon));

            lOB = new TrailList(listOfTrails);
            lOB.writeToFile(lOB, getApplicationContext());

            Intent intent= new Intent(this, MapsActivity.class);
            startActivity(intent);
            finish();


        } catch(Exception e){
            Toast.makeText(this, "Please input a number", Toast.LENGTH_SHORT).show();
        }


    }



}