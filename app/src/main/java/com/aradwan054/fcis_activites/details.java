package com.aradwan054.fcis_activites;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class details extends AppCompatActivity {
    ImageView backgroundd;
    TextView mvision, mmission, myear;
Context context;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        backgroundd = findViewById(R.id.background);
        mvision = findViewById(R.id.vision);
        context=details.this;
        mmission = findViewById(R.id.mission);
        myear = findViewById(R.id.year);

        Intent intent = getIntent();
        if (intent != null) {
            String vision = intent.getStringExtra("activityVision");
            String poster2 = intent.getStringExtra("activitybackground");
            String mission = intent.getStringExtra("activityMission");
            int year = intent.getIntExtra("activityYear",2007);

            if(vision != null)
                mvision.setText(vision);
            else mvision.setText("vision vision vision vision ");

            if(mission != null)
                mmission.setText(mission);
            else mmission.setText("vision vision vision vision vision ");

            if(year != 2007)
                myear.setText("We were founded in "+Integer.toString(year));

            if (poster2 != null)
                Glide.with(this).load(poster2).into(backgroundd);
            else
                Glide.with(context).load(R.drawable.poster).into((ImageView) backgroundd);
        }
    }
}
