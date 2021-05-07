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

public class UserRVAdapter extends RecyclerView.Adapter<UserRVAdapter.ViewHolder> {

    // variable for our array list and context.
    private ArrayList<UserModal> userModalArrayList;
    private Context context;

    // creating a constructor.
    public UserRVAdapter(ArrayList<UserModal> userModalArrayList, Context context) {
        this.userModalArrayList = userModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating our layout file on below line.
        View view = LayoutInflater.from(context).inflate(R.layout.user_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        // getting data from our array list in our modal class.
        UserModal userModal = userModalArrayList.get(position);

        // on the below line we are setting data to our text view.
        holder.recipeNameButton.setText(userModal.getRecipe_name());
        holder.recipeTags.setText("Dietary Tags: " + userModal.getDiet_tags());

        // on below line we are loading our image from the URL
        // in our image view using Picasso.
        //Picasso.get().load(userModal.getAvatar()).into(holder.userIV);

        holder.recipeNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, recipeDisplay.class);

                intent.putExtra("RecipeName", userModalArrayList.get(position).getRecipe_name());
                intent.putExtra("RecipeTime", userModalArrayList.get(position).getCook_time());
                intent.putExtra("RecipeServings", userModalArrayList.get(position).getServing());
                intent.putExtra("RecipeIngredients", userModalArrayList.get(position).getIngredients());
                intent.putExtra("RecipeSteps", userModalArrayList.get(position).getSteps());
                intent.putExtra("RecipeSource", userModalArrayList.get(position).getWeb_source());
                intent.putExtra("ImageURL",userModal.getImage_URL());
                intent.putExtra("DietTags",userModal.getDiet_tags());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return userModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating a variable for our text view and image view.
        private Button recipeNameButton;
        private TextView recipeTags;
        //private ImageView userIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our variables.
            recipeNameButton = itemView.findViewById(R.id.idButtonrecipeName);
            recipeTags = itemView.findViewById(R.id.idRestrictions);
        }
    }
}

