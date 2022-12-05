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
import java.util.Locale;

public class Search extends AppCompatActivity {
    ArrayList<Trails> listofTrails;
    TableLayout displayTrails;
    TrailList lOT = new TrailList();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Spinner searchCond=(Spinner) findViewById(R.id.searchCond);
        EditText search=(EditText) findViewById(R.id.inputSearch);
        String searchCondSelect=searchCond.getSelectedItem().toString();

        lOT= lOT.read(getApplicationContext());
        listofTrails = lOT.getTrailList();
        displayTrails= (TableLayout) findViewById(R.id.displayTrails);//casting table

        for(int i=0;i<listofTrails.size();i++) {//creating table

            Trails fill = listofTrails.get(i);//iterating through trails
            TableRow row = new TableRow(this);//creating row

                String name = fill.name;
                TextView titleView = new TextView(this);
                titleView.setText("" + name);
                titleView.setTextSize(8*getResources().getDisplayMetrics().density);
                titleView.setClickable(true);
                titleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        advancedTrailView(fill);
                    }
                });


                row.addView(titleView);
                displayTrails.addView(row);

            }
        }

    public void startSearch(View v){

        EditText searchobj=(EditText) findViewById(R.id.inputSearch);
        String search=searchobj.getText().toString();
        Spinner searchCond=(Spinner) findViewById(R.id.searchCond);
        String searchCondSelect=searchCond.getSelectedItem().toString();


        lOT.read(getApplicationContext());
        listofTrails = lOT.getTrailList();
        displayTrails= (TableLayout) findViewById(R.id.displayTrails);//casting table
        displayTrails.removeAllViews();//clearing table
        System.out.println(searchCondSelect);

        if(search.isEmpty()){//if no search terms are entered
            for(int i=0;i<listofTrails.size();i++) {//creating table

                Trails fill = listofTrails.get(i);
                TableRow row = new TableRow(this);//creating row

                String name = fill.name;//creating name view
                TextView titleView = new TextView(this);
                titleView.setText("" + name);
                titleView.setTextSize(8*getResources().getDisplayMetrics().density);
                titleView.setClickable(true);
                titleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        advancedTrailView(fill);
                    }
                });

                row.addView(titleView);
                displayTrails.addView(row);


            }
        } else{//if search terms are entered
            if(searchCondSelect.contains("Ease")){//if searching ease
                for(int i=0;i<listofTrails.size();i++) {//creating table

                    Trails fill = listofTrails.get(i);
                    TableRow row = new TableRow(this);//creating row
                    if (fill.ease.toLowerCase(Locale.ROOT).contains(search.toLowerCase(Locale.ROOT))) {

                        String name = fill.name;//creating name view
                        TextView titleView = new TextView(this);
                        titleView.setText("" + name);
                        titleView.setTextSize(8*getResources().getDisplayMetrics().density);

                        titleView.setClickable(true);
                        titleView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v){
                                advancedTrailView(fill);
                            }
                        });

                        row.addView(titleView);
                        displayTrails.addView(row);

                    }
                }
            };
            if(searchCondSelect.contains("Difficulty")){//if searching difficulty
                for(int i=0;i<listofTrails.size();i++) {//creating table

                    Trails fill = listofTrails.get(i);
                    TableRow row = new TableRow(this);//creating row
                    if (fill.difficulty.toLowerCase(Locale.ROOT).contains(search.toLowerCase(Locale.ROOT))) {

                        String name = fill.name;//creating name view
                        TextView titleView = new TextView(this);
                        titleView.setText("" + name);
                        titleView.setTextSize(8*getResources().getDisplayMetrics().density);

                        titleView.setClickable(true);
                        titleView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v){
                                advancedTrailView(fill);
                            }
                        });

                        row.addView(titleView);
                        displayTrails.addView(row);

                    }
                }
            };
            if(searchCondSelect.contains("Features")){//if searching features
                for(int i=0;i<listofTrails.size();i++) {//creating table

                    Trails fill = listofTrails.get(i);
                    TableRow row = new TableRow(this);//creating row
                    if (fill.features.toLowerCase(Locale.ROOT).contains(search.toLowerCase(Locale.ROOT))) {

                        String name = fill.name;//creating name view
                        TextView titleView = new TextView(this);
                        titleView.setText("" + name);
                        titleView.setTextSize(8*getResources().getDisplayMetrics().density);

                        titleView.setClickable(true);
                        titleView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v){
                                advancedTrailView(fill);
                            }
                        });

                        row.addView(titleView);
                        displayTrails.addView(row);

                    }
                }
            };if(searchCondSelect.contains("Length")){//if searching features
                for(int i=0;i<listofTrails.size();i++) {//creating table

                    Trails fill = listofTrails.get(i);
                    TableRow row = new TableRow(this);//creating row
                    if (fill.length >= Integer.parseInt(String.valueOf(Locale.ROOT))-2 && fill.length <= Integer.parseInt(String.valueOf(Locale.ROOT))+2) {

                        String name = fill.name;//creating name view
                        TextView titleView = new TextView(this);
                        titleView.setText("" + name);
                        titleView.setTextSize(8*getResources().getDisplayMetrics().density);

                        titleView.setClickable(true);
                        titleView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v){
                                advancedTrailView(fill);
                            }
                        });

                        row.addView(titleView);
                        displayTrails.addView(row);

                    }
                }
            };

        };
    }

    public void advancedTrailView(Trails trail){

        Intent intent=new Intent(this, trail_Description.class);
        Bundle bundle=new Bundle();
        bundle.putString("name",trail.name);
        bundle.putString("ease",trail.ease);
        bundle.putString("diff",trail.difficulty);
        bundle.putString("feats",trail.features);
        bundle.putDouble("rev",trail.review);
        bundle.putInt("length", trail.length);

        intent.putExtras(bundle);
        startActivity(intent);//starting activity

    }

    public void back(View view){
        Intent intent= new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

}