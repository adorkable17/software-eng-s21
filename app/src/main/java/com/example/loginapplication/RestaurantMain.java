package com.example.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RestaurantMain extends AppCompatActivity {

    private ImageButton searchButton;
    private ImageButton randomButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_search);
        Intent intent = new Intent(RestaurantMain.this, RestaurantSearch.class);
        startActivity(intent);
        //searchButton = (ImageButton) findViewById(R.id.buttonSearch);
        //randomButton = (ImageButton) findViewById(R.id.buttonRandom);

        //searchButton.setImageResource(R.drawable.search_icon);
        //randomButton.setImageResource(R.drawable.spin_wheel_bw);

        /*
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(RecipeMain.this, com.example.sheetstest.randomRecipe.class);
                startActivity(intent2);
            }
        });*/

    }
}