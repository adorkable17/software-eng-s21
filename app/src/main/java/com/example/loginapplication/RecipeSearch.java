package com.example.loginapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecipeSearch extends AppCompatActivity {

    // creating a variable for our array list, adapter class,
    // recycler view, progressbar, nested scroll view
    private ArrayList<UserModal> userModalArrayList;
    private com.example.loginapplication.UserRVAdapter userRVAdapter;
    private RecyclerView userRV;
    private ProgressBar loadingPB;
    String searchTerm;
    EditText searchInput;
    ImageButton button;

    //Button recipeButton;

    //public static final String EXTRA_MESSAGE = "com.example.sheetstest.MESSAGE";

    String recipeNamePass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_search);

        searchInput = (EditText) findViewById(R.id.searchInput);
        loadingPB = (ProgressBar) findViewById(R.id.idPBLoading);
        userModalArrayList = new ArrayList<UserModal>();

        loadingPB.setVisibility(View.INVISIBLE);

        button = (ImageButton) findViewById(R.id.button);
        button.setImageResource(R.drawable.search_icon);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);
                searchTerm = searchInput.getText().toString();
                TextView tV2 = findViewById(R.id.Search);
                String disp = "Search for: " + searchTerm.toLowerCase();
                tV2.setText(disp);
                // creating a new array list.
                userModalArrayList = new ArrayList<>();

                // initializing our views.
                userRV = findViewById(R.id.idRVUsers);

                // calling a method to load our API.
                getDataFromAPI(searchTerm);
            }
        });


        //recipeButton = (Button) findViewById(R.id.idButtonrecipeName);
        //recipeButton.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View v) {
               // recipeNamePass = recipeButton.getText().toString();
                //Intent intent = new Intent(MainActivity.this,
                 //       com.example.sheetstest.recipeDisplay.class);
                //intent.putExtra(EXTRA_MESSAGE, recipeNamePass);
                //startActivity(intent);
            //}
        //});
    }

    private void getDataFromAPI(String term) {

        // creating a string variable for URL.
        String url = "https://spreadsheets.google.com/feeds/list/17RXZm4dtaOq4gcVdzGk1NmaefXejd-OvECvet_CpQO4/od6/public/values?alt=json";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(com.example.loginapplication.RecipeSearch.this);

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
                        String recipeName = entryObj.getJSONObject("gsx$recipename").getString("$t");
                        String cookTime = entryObj.getJSONObject("gsx$cooktime").getString("$t");
                        String servingSize = entryObj.getJSONObject("gsx$serving").getString("$t");
                        String ingredients = entryObj.getJSONObject("gsx$ingredients").getString("$t");
                        String web_source = entryObj.getJSONObject("gsx$websource").getString("$t");
                        String steps = entryObj.getJSONObject("gsx$steps").getString("$t");
                        String dietTags = entryObj.getJSONObject("gsx$diettags").getString("$t");
                        String imageURL = entryObj.getJSONObject("gsx$avatar").getString("$t");

                        if(recipeName.toLowerCase().contains(term.toLowerCase()) || dietTags.toLowerCase().contains(term.toLowerCase())) {
                            userModalArrayList.add(new UserModal(recipeName, cookTime, servingSize, ingredients, steps, web_source, dietTags, imageURL));

                            // passing array list to our adapter class.
                            userRVAdapter = new com.example.loginapplication.UserRVAdapter(userModalArrayList, com.example.loginapplication.RecipeSearch.this);

                            // setting layout manager to our recycler view.
                            userRV.setLayoutManager(new LinearLayoutManager(com.example.loginapplication.RecipeSearch.this));

                            // setting adapter to our recycler view.
                            userRV.setAdapter(userRVAdapter);
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
                Toast.makeText(com.example.loginapplication.RecipeSearch.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
            }
        });
        // calling a request queue method
        // and passing our json object
        queue.add(jsonObjectRequest);
    }
}
