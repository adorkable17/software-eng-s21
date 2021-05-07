package com.example.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class randomRecipe extends AppCompatActivity {

    // creating a variable for our array list, adapter class,
    // recycler view, progressbar, nested scroll view
    private ProgressBar loadingPB;
    ImageButton button;
    TextView instruc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_recipe);

        loadingPB = (ProgressBar) findViewById(R.id.idPBLoading1);
        instruc = (TextView) findViewById(R.id.Instructions);

        loadingPB.setVisibility(View.INVISIBLE);
        button = (ImageButton) findViewById(R.id.wheelButton);
        button.setImageResource(R.drawable.spin_wheel_color);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);

                Random rand = new Random();
                int random1 = rand.nextInt(30) + 1; //generate random numbers from 1-30

                String repId = Integer.toString(random1);

                // calling a method to load our API.
                getDataFromAPI(repId);
            }
        });

    }

    private void getDataFromAPI(String term) {

        // creating a string variable for URL.
        String url = "https://spreadsheets.google.com/feeds/list/17RXZm4dtaOq4gcVdzGk1NmaefXejd-OvECvet_CpQO4/od6/public/values?alt=json";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(com.example.loginapplication.randomRecipe.this);

        // creating a variable for our JSON object request and passing our URL to it.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                loadingPB.setVisibility(View.GONE);
                try {
                    JSONObject feedObj = response.getJSONObject("feed");
                    JSONArray entryArray = feedObj.getJSONArray("entry");
                    for(int i=0; i<entryArray.length(); i++){
                        JSONObject entryObj = entryArray.getJSONObject(i);
                        String recipeID = entryObj.getJSONObject("gsx$id").getString("$t");
                        String recipeName = entryObj.getJSONObject("gsx$recipename").getString("$t");
                        String cookTime = entryObj.getJSONObject("gsx$cooktime").getString("$t");
                        String servingSize = entryObj.getJSONObject("gsx$serving").getString("$t");
                        String ingredients = entryObj.getJSONObject("gsx$ingredients").getString("$t");
                        String web_source = entryObj.getJSONObject("gsx$websource").getString("$t");
                        String steps = entryObj.getJSONObject("gsx$steps").getString("$t");
                        String dietTags = entryObj.getJSONObject("gsx$diettags").getString("$t");
                        String imageURL = entryObj.getJSONObject("gsx$avatar").getString("$t");

                        if(recipeID.toLowerCase().contentEquals(term.toLowerCase())) {
                            Intent intent = new Intent(com.example.loginapplication.randomRecipe.this, com.example.loginapplication.recipeDisplay.class);

                            intent.putExtra("RecipeName", recipeName);
                            intent.putExtra("RecipeTime", cookTime);
                            intent.putExtra("RecipeServings", servingSize);
                            intent.putExtra("RecipeIngredients", ingredients);
                            intent.putExtra("RecipeSteps", steps);
                            intent.putExtra("RecipeSource", web_source);
                            intent.putExtra("ImageURL", imageURL);
                            intent.putExtra("DietTags", dietTags);

                            startActivity(intent);
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // handline on error listner method.
                Toast.makeText(com.example.loginapplication.randomRecipe.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
            }
        });
        // calling a request queue method
        // and passing our json object
        queue.add(jsonObjectRequest);
    }

}