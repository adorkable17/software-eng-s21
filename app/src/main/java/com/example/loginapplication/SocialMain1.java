package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class SocialMain1 extends AppCompatActivity {

    private ImageView socImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_main1);

        socImage = (ImageView) findViewById(R.id.mSocScreenImage);

        socImage.setImageResource(R.drawable.socialstart);
    }
}