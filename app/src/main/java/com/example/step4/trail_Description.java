package com.example.step4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class trail_Description extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_description);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();//getting descriptions

        TextView name= (TextView) findViewById(R.id.name);
        name.setText("Name: "+bundle.getString("name"));

        TextView rating=(TextView) findViewById(R.id.rating);
        rating.setText("Rating: "+bundle.getDouble("rev") + " /5");

        TextView len=(TextView) findViewById(R.id.length);
        len.setText("Length: "+bundle.getInt("length") +" KM");

        TextView feat=(TextView) findViewById(R.id.feats);
        feat.setText("Features: "+bundle.getString("feats"));

        TextView ease=(TextView) findViewById(R.id.ease);
        ease.setText("Ease of Access: "+bundle.getString("ease"));

        TextView diff=(TextView) findViewById(R.id.diff);
        diff.setText("Difficulty: "+bundle.getString("diff"));

    }

    public void back(View view){
        finish();
    }
}