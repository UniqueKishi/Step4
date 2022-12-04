package com.example.step4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class AddTrail extends AppCompatActivity {

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trail);



        Intent receiveIntent = new Intent(Intent.ACTION_GET_CONTENT);
        receiveIntent.setType("*/*");
        String[] mimetypes = {"application/vnd.google-earth.kml+xml"};
        receiveIntent.putExtra(Intent.EXTRA_MIME_TYPES, mimetypes);
        receiveIntent.addCategory(Intent.CATEGORY_OPENABLE);

        //set choosen file name
        TextView KmlFileName = (TextView) findViewById(R.id.KMLfileDescript);



        //Add KML file button
         Button add= (Button)findViewById(R.id.AddKMLfile);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //startActivity(KMLIntent);
                startActivity(receiveIntent);
                //File newKML = new File(receiveIntent.getExtras());
                //receiveIntent.getExtras();
//                finish();
//                Uri uri= receiveIntent.getData();
//                File file= new File(uri.getPath());

//                InputStream what =ContentResolver.openOutputStream(receiveIntent.getData());
//                  KmlFileName.setText(file.getName());
//
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                KmlFileName.setText("KnoxMountain.kml");





            }
        });


        Button Submit = (Button)findViewById(R.id.SubmitButt);
        Submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //save


                finish();
            }
        });

    }
}