package com.example.placestogo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.libraries.places.api.Places;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView banksTextView;
    private TextView coffeeTextView;
    private TextView gasStationsTextView;
    private TextView hospitalsTextView;
    private TextView hotelsTextView;
    private TextView movieTheatersTextView;
    private TextView pharmacyTextView;
    private TextView restaurantsTextView;
    private TextView supermarketsTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar = findViewById(R.id.mainAppBar);
        banksTextView = findViewById(R.id.banksTextView);
        coffeeTextView = findViewById(R.id.coffeeTextView);
        gasStationsTextView = findViewById(R.id.gasStationTextView);
        hospitalsTextView = findViewById(R.id.hospitalsTextView);
        hotelsTextView = findViewById(R.id.hotelsTextView);
        movieTheatersTextView = findViewById(R.id.movieTheatersTextView);
        pharmacyTextView = findViewById(R.id.pharmacyTextView);
        restaurantsTextView = findViewById(R.id.restaurantsTextView);
        supermarketsTextView = findViewById(R.id.supermarketTextView);

        banksTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent banksActivityIntent = new Intent(MainActivity.this, BanksActivity.class);
                startActivity(banksActivityIntent);
            }
        });

        coffeeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent coffeeActivityIntent = new Intent(MainActivity.this, CoffeeActivity.class);
                startActivity(coffeeActivityIntent);
            }
        });

        gasStationsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gasActivityIntent = new Intent(MainActivity.this, GasStationsActivity.class);
                startActivity(gasActivityIntent);
            }
        });

        hospitalsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent hospitalsActivityIntent = new Intent(MainActivity.this, HospitalsActivity.class);
                startActivity(hospitalsActivityIntent);
            }
        });

        hotelsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent hotelsActivityIntent = new Intent(MainActivity.this, HotelsActivity.class);
                startActivity(hotelsActivityIntent);
            }
        });

        movieTheatersTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent movieTheatersActivityIntent = new Intent(MainActivity.this, MovieTheatersActivity.class);
                startActivity(movieTheatersActivityIntent);
            }
        });

        pharmacyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pharmacyActivityIntent = new Intent(MainActivity.this, RestaurantsActivity.class);
                startActivity(pharmacyActivityIntent);
            }
        });

        restaurantsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restaurantsActivityIntent = new Intent(MainActivity.this, RestaurantsActivity.class);
                startActivity(restaurantsActivityIntent);
            }
        });

        supermarketsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent supermarketsActivityIntent = new Intent(MainActivity.this, SupermarketsActivity.class);
                startActivity(supermarketsActivityIntent);
            }
        });


    }


    @Override
    protected void onStart() {

        super.onStart();

        final String apiKey = BuildConfig.MAPS_API_KEY;

        //Request location permission from user
        ActivityResultLauncher<String[]> locationPermissionRequest =
                registerForActivityResult(new ActivityResultContracts
                                .RequestMultiplePermissions(), result -> {
                            Boolean fineLocationGranted = result.getOrDefault(
                                    Manifest.permission.ACCESS_FINE_LOCATION, false);
                            Boolean coarseLocationGranted = result.getOrDefault(
                                    Manifest.permission.ACCESS_COARSE_LOCATION,false);
                            if (fineLocationGranted != null && fineLocationGranted) {
                                // Initialize the SDK. Setup Places Client
                                Places.initialize(getApplicationContext(), apiKey);
                            } else if (coarseLocationGranted != null && coarseLocationGranted) {
                                // Only approximate location access granted.
                                Places.initialize(getApplicationContext(), apiKey);
                            } else {
                                // No location access granted.
                            }
                        }
                );

        locationPermissionRequest.launch(new String[] {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        });
    }

}