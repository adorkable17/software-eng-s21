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

public class RestaurantSearch extends AppCompatActivity {

    // creating a variable for our array list, adapter class,
    // recycler view, progressbar, nested scroll view
    private ArrayList<RestaurantModal> restaurantModalArrayList;
    private RestaurantRVAdapter restaurantRVAdapter;
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
        setContentView(R.layout.activity_restaurant_search);

        searchInput = (EditText) findViewById(R.id.searchInputRest);
        loadingPB = (ProgressBar) findViewById(R.id.idPBLoading);
        restaurantModalArrayList = new ArrayList<RestaurantModal>();

        loadingPB.setVisibility(View.INVISIBLE);

        button = (ImageButton) findViewById(R.id.buttonR);
        button.setImageResource(R.drawable.search_icon);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);
                searchTerm = searchInput.getText().toString();
                TextView tV2 = findViewById(R.id.SearchImg);
                String disp = "Results for: " + searchTerm.toLowerCase();
                tV2.setText(disp);
                // creating a new array list.
                restaurantModalArrayList = new ArrayList<>();

                // initializing our views.
                userRV = findViewById(R.id.idRVRestaurants);

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
        String url = "https://spreadsheets.google.com/feeds/list/17RXZm4dtaOq4gcVdzGk1NmaefXejd-OvECvet_CpQO4/3/public/full?alt=json";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(RestaurantSearch.this);

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
                        String restaurantName = entryObj.getJSONObject("gsx$restaurantname").getString("$t");
                        String phoneNumber = entryObj.getJSONObject("gsx$phno").getString("$t");
                        String address = entryObj.getJSONObject("gsx$address").getString("$t");
                        String latitude = entryObj.getJSONObject("gsx$lat").getString("$t");
                        String web_source = entryObj.getJSONObject("gsx$websource").getString("$t");
                        String longitude = entryObj.getJSONObject("gsx$lng").getString("$t");
                        String dietTags = entryObj.getJSONObject("gsx$diettags").getString("$t");
                        String imageURL = entryObj.getJSONObject("gsx$avatar").getString("$t");

                        if(restaurantName.toLowerCase().contains(term.toLowerCase()) || dietTags.toLowerCase().contains(term.toLowerCase())) {
                            restaurantModalArrayList.add(new RestaurantModal(restaurantName, phoneNumber, address, latitude, longitude, web_source, dietTags, imageURL));

                            // passing array list to our adapter class.
                            restaurantRVAdapter = new RestaurantRVAdapter(restaurantModalArrayList, RestaurantSearch.this);

                            // setting layout manager to our recycler view.
                            userRV.setLayoutManager(new LinearLayoutManager(RestaurantSearch.this));

                            // setting adapter to our recycler view.
                            userRV.setAdapter(restaurantRVAdapter);
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
                Toast.makeText(RestaurantSearch.this, "Fail to get data..", Toast.LENGTH_SHORT).show();
            }
        });
        // calling a request queue method
        // and passing our json object
        queue.add(jsonObjectRequest);
    }
}
