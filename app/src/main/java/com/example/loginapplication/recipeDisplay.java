package com.example.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class recipeDisplay extends AppCompatActivity {

    private TextView mRecipeName;
    private TextView mRecipeTags;
    private TextView mRecipeCookTime;
    private TextView mRecipeServings;
    private TextView mRecipeIngredients;
    private TextView mRecipeSteps;
    private TextView mRecipeSource;
    private ImageView mRecipeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_display);

        mRecipeName = (TextView)findViewById(R.id.recipeName);
        mRecipeTags = (TextView)findViewById(R.id.recipeTags);
        mRecipeCookTime = (TextView)findViewById(R.id.recipeTime);
        mRecipeServings = (TextView)findViewById(R.id.recipeServing);
        mRecipeIngredients = (TextView)findViewById(R.id.recipeIngredients);
        mRecipeSteps = (TextView)findViewById(R.id.recipeSteps);
        mRecipeSource = (TextView)findViewById(R.id.recipeSource);
        mRecipeImage = (ImageView)findViewById(R.id.recipeImage);

        Intent intent = getIntent();
        String Name = intent.getExtras().getString("RecipeName");
        String Time = intent.getExtras().getString("RecipeTime");
        String Servings = intent.getExtras().getString("RecipeServings");
        String Ingredients = intent.getExtras().getString("RecipeIngredients");
        String Steps = intent.getExtras().getString("RecipeSteps");
        String Source = intent.getExtras().getString("RecipeSource");
        String Image = intent.getExtras().getString("ImageURL");
        String Tags = intent.getExtras().getString("DietTags");

        mRecipeName.setText(Name);
        mRecipeTags.setText(mRecipeTags.getText() + Tags);
        mRecipeCookTime.setText(mRecipeCookTime.getText() + Time);
        mRecipeServings.setText(mRecipeServings.getText() + Servings);
        mRecipeIngredients.setText(Ingredients);
        mRecipeSteps.setText(Steps);
        mRecipeSource.setText(Source);
        Picasso.get().load(Image).into(mRecipeImage);
    }
}