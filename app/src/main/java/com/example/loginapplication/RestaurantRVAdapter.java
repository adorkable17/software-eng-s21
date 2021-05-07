package com.example.loginapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//import com.squareup.picasso.Picasso;

public class RestaurantRVAdapter extends RecyclerView.Adapter<RestaurantRVAdapter.ViewHolder> {

    // variable for our array list and context.
    private ArrayList<RestaurantModal> restaurantModalArrayList;
    private Context context;

    // creating a constructor.
    public RestaurantRVAdapter(ArrayList<RestaurantModal> restaurantModalArrayList, Context context) {
        this.restaurantModalArrayList = restaurantModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating our layout file on below line.
        View view = LayoutInflater.from(context).inflate(R.layout.restaurant_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        // getting data from our array list in our modal class.
        RestaurantModal restaurantModal = restaurantModalArrayList.get(position);

        // on the below line we are setting data to our text view.
        holder.recipeNameButton.setText(restaurantModal.getRestaurant_name());
        holder.recipeTags.setText("Dietary Tags: " + restaurantModal.getDiet_tags());

        // on below line we are loading our image from the URL
        // in our image view using Picasso.
        //Picasso.get().load(userModal.getAvatar()).into(holder.userIV);

        holder.recipeNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, restaurantDisplay.class);

                intent.putExtra("RestaurantName", restaurantModalArrayList.get(position).getRestaurant_name());
                intent.putExtra("PhoneNumber", restaurantModalArrayList.get(position).getPhone_number());
                intent.putExtra("Address", restaurantModalArrayList.get(position).getAddress());
                intent.putExtra("Latitude", restaurantModalArrayList.get(position).getLatitude());
                intent.putExtra("Longitude", restaurantModalArrayList.get(position).getLongitude());
                intent.putExtra("RestaurantSource", restaurantModalArrayList.get(position).getWeb_source());
                intent.putExtra("RestaurantImageURL", restaurantModal.getImage_URL());
                intent.putExtra("RestaurantTags", restaurantModal.getDiet_tags());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return restaurantModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating a variable for our text view and image view.
        private Button recipeNameButton;
        private TextView recipeTags;
        //private ImageView userIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our variables.
            recipeNameButton = itemView.findViewById(R.id.idButtonRestaurantName);
            recipeTags = itemView.findViewById(R.id.idTags);
        }
    }
}

