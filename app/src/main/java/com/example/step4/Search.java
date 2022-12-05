package com.example.step4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    ArrayList<Trails> listofTrails;
    TableLayout displayTrails;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Spinner searchCond=(Spinner) findViewById(R.id.searchCond);
        EditText search=(EditText) findViewById(R.id.inputSearch);
        String searchCondSelect=searchCond.getSelectedItem().toString();

        TrailList lOT = new TrailList();

        lOT.read(getApplicationContext());
        listofTrails = lOT.getTrailList();
        displayTrails= (TableLayout) findViewById(R.id.displayTrails);//casting table

        for(int i=0;i<listofTrails.size();i++) {//creating table

            Trails fill = listofTrails.get(i);//iterating through trails
            TableRow row = new TableRow(this);//creating row

                String name = fill.name;//creating title view
                TextView titleView = new TextView(this);
                titleView.setText("" + name);
                titleView.setClickable(true);//set the title text to clickable
                titleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        
                    }
                });


                row.addView(titleView);//adding both bits to table
                displayTrails.addView(row);

            }
        }


    public void back(View view){
        Intent intent= new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

}