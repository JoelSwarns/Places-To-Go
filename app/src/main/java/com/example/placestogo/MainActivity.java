package com.example.placestogo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.libraries.places.api.Places;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener {

    HomeFragment homeFragment = new HomeFragment();
    BankFragment bankFragment = new BankFragment();
    CoffeeFragment coffeeFragment = new CoffeeFragment();
    GasFragment gasFragment = new GasFragment();
    RestaurantFragment restaurantFragment = new RestaurantFragment();
    final String placesApiKey = BuildConfig.MAPS_API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnItemSelectedListener(this);
        //defaults the button selected on app start up
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

    }


    //method passes a menu item and
    //based on the selected item it will bring up the correlating fragment
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, homeFragment).commit();
                return true;

            case R.id.navigation_bank:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, bankFragment).commit();
                return true;

            case R.id.navigation_coffee:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, coffeeFragment).commit();
                return true;

            case R.id.navigation_restaurants:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, restaurantFragment).commit();
                return true;

            case R.id.navigation_gas:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, gasFragment).commit();
                return true;
        }
        return false;
    }

    @Override
    protected void onStart() {

        super.onStart();


        //Request location permission from user
        ActivityResultLauncher<String[]> locationPermissionRequest =
                registerForActivityResult(new ActivityResultContracts
                                .RequestMultiplePermissions(), result -> {
                            Boolean fineLocationGranted = result.getOrDefault(
                                    Manifest.permission.ACCESS_FINE_LOCATION, false);
                            Boolean coarseLocationGranted = result.getOrDefault(
                                    Manifest.permission.ACCESS_COARSE_LOCATION, false);
                            if (fineLocationGranted != null && fineLocationGranted) {
                                // Initialize the SDK. Setup Places Client
                                Places.initialize(getApplicationContext(), placesApiKey);
                            } else if (coarseLocationGranted != null && coarseLocationGranted) {
                                // Only approximate location access granted.
                                Places.initialize(getApplicationContext(), placesApiKey);
                            } else {
                                // No location access granted.
                            }
                        }
                );

        locationPermissionRequest.launch(new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        });
    }


}