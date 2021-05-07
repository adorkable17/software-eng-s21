package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class AppHomePage extends AppCompatActivity {

    private ImageButton recipeButton;
    private ImageButton profileButton;
    private ImageButton socialButton;
    private ImageButton mapsButton;
    private ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home_page);

        recipeButton = (ImageButton) findViewById(R.id.buttonRecipe);
        profileButton = (ImageButton) findViewById(R.id.buttonProfile);
        socialButton = (ImageButton) findViewById(R.id.buttonSocial);
        mapsButton = (ImageButton) findViewById(R.id.buttonMaps);
        logoImage = (ImageView) findViewById(R.id.logoImage);

        recipeButton.setImageResource(R.drawable.recipepage);
        profileButton.setImageResource(R.drawable.profilepage);
        socialButton.setImageResource(R.drawable.socialpage);
        mapsButton.setImageResource(R.drawable.mapspage);
        logoImage.setImageResource(R.drawable.logoimage);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppHomePage.this, ProfilePageActivity.class);
                startActivity(intent);
            }
        });

        recipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppHomePage.this, RecipeMain.class);
                startActivity(intent);
            }
        });

        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppHomePage.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        socialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppHomePage.this, SocialMain.class);
                startActivity(intent);
            }
        });

    }
}