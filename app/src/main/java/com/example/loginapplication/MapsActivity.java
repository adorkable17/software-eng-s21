package com.example.loginapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Switch currentLocationSwitch;
    private Switch keywordSwitch;
    /*private ArrayList<UserModal> userModalArrayList;
    private UserRVAdapter userRVAdapter;
    private RecyclerView userRV;*/

   // private FusedLocationProviderClient fusedLocationClient;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        currentLocationSwitch = findViewById(R.id.currentLocationSwitch);
        currentLocationSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentLocation();
            }
        });
        currentLocationSwitch.setChecked(false);

        keywordSwitch = findViewById(R.id.searchToggle);
        keywordSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                keywordSearch();
            }
        });
        currentLocationSwitch.setChecked(false);
       /* if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        } */

        /*
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                // Got last known location. In some rare situations this can be null.
                if (location != null) {
                    // Logic to handle location object
                }
            }
        });*/

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    private void currentLocation()
    {
        Intent intent = new Intent(this, currentLocation.class);
        startActivity(intent);
    }
    private void keywordSearch()
    {
        Intent intent = new Intent(this, RestaurantMain.class);
        startActivity(intent);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)  {
        mMap = googleMap;

        // Add a marker in New Brunswick (40.4862N, 74.4518W) and move the camera
        LatLng rutNewBrunswick = new LatLng(40.5008,-74.4474);
        LatLng tacoria = new LatLng(40.4977,	-74.4489);
        LatLng efes = new LatLng(40.4974,	-74.448);
        LatLng hg = new LatLng(40.4991,	-74.4481);
        LatLng hanselngriddle = new LatLng(40.4992,	-74.4528);
        LatLng panera = new LatLng(40.5027,	-74.4516);
        LatLng harvestMoon = new LatLng(40.4962,	-74.4443);

        mMap.addMarker(new MarkerOptions().position(rutNewBrunswick).title("Welcome to Rutgers-New Brunswick!"));
        Marker mtacoria = mMap.addMarker(new MarkerOptions().position(tacoria).title("Tacoria"));
        Marker mEfes = mMap.addMarker(new MarkerOptions().position(efes).title("Efes"));
        Marker mHG = mMap.addMarker(new MarkerOptions().position(hg).title("honeygrow"));
        Marker mHanselngriddle = mMap.addMarker(new MarkerOptions().position(hanselngriddle).title("Hansel N Griddle"));
        Marker mPanera = mMap.addMarker(new MarkerOptions().position(panera).title("Panera"));
        Marker mHarvestMoon = mMap.addMarker(new MarkerOptions().position(harvestMoon).title("Harvest Moon Brewery"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(rutNewBrunswick));
        mMap.setMinZoomPreference(15);

    }
}

