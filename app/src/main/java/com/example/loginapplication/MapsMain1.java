package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MapsMain1 extends AppCompatActivity {

    private ImageView mapsScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_main1);

        mapsScreen = (ImageView) findViewById(R.id.mScreenImage);

        mapsScreen.setImageResource(R.drawable.mapsstart);
    }
}