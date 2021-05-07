package com.example.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeMain extends AppCompatActivity {

    private ImageButton searchButton;
    private ImageButton randomButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_main);

        searchButton = (ImageButton) findViewById(R.id.buttonSearch);
        randomButton = (ImageButton) findViewById(R.id.buttonRandom);

        searchButton.setImageResource(R.drawable.search_icon);
        randomButton.setImageResource(R.drawable.spin_wheel_bw);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.loginapplication.RecipeMain.this, RecipeSearch.class);
                startActivity(intent);
            }
        });

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(com.example.loginapplication.RecipeMain.this, com.example.loginapplication.randomRecipe.class);
                startActivity(intent2);
            }
        });

    }
}