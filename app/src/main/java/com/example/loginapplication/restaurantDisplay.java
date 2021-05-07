package com.example.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class restaurantDisplay extends AppCompatActivity {

    private TextView mRestaurantName;
    private TextView mRestaurantTags;
    private TextView mPhoneNumber;
    private TextView mAddress;
    private TextView mLatitude;
    private TextView mLongitude;
    private TextView mRestaurantSource;
    private ImageView mRestaurantImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_display);

        mRestaurantName = (TextView)findViewById(R.id.restaurantName);
        mRestaurantTags = (TextView)findViewById(R.id.restaurantTags);
        mPhoneNumber = (TextView)findViewById(R.id.restaurantPhoneNum);
        mAddress = (TextView)findViewById(R.id.restaurantAddress);
        mLatitude = (TextView)findViewById(R.id.restaurantLatitude);
        mLongitude = (TextView)findViewById(R.id.restaurantLongitude);
        mRestaurantSource = (TextView)findViewById(R.id.restaurantSource);
        mRestaurantImage = (ImageView)findViewById(R.id.restaurantImage);

        Intent intent = getIntent();
        String Name = intent.getExtras().getString("RestaurantName");
        String phoneNumber = intent.getExtras().getString("PhoneNumber");
        String address = intent.getExtras().getString("Address");
        String latitude = intent.getExtras().getString("Latitude");
        String longitude = intent.getExtras().getString("Longitude");
        String Source = intent.getExtras().getString("RestaurantSource");
        String Image = intent.getExtras().getString("RestaurantImageURL");
        String Tags = intent.getExtras().getString("RestaurantTags");

        mRestaurantName.setText(Name);
        mRestaurantTags.setText(mRestaurantTags.getText() + Tags);
        mPhoneNumber.setText(mPhoneNumber.getText() + phoneNumber);
        mAddress.setText(mAddress.getText() + address);
        mLatitude.setText(latitude);
        mLongitude.setText(longitude);
        mRestaurantSource.setText(Source);
        Picasso.get().load(Image).into(mRestaurantImage);
    }
}