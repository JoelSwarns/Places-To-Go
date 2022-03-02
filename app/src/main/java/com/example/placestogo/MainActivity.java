package com.example.placestogo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    TextView banksTextView;
    TextView coffeeTextView;
    TextView gasStationsTextView;
    TextView hospitalsTextView;
    TextView hotelsTextView;
    TextView movieTheatersTextView;
    TextView pharmacyTextView;
    TextView restaurantsTextView;
    TextView supermarketsTextView;

    Intent banksActivityIntent = new Intent(MainActivity.this, BanksActivity.class);
    Intent coffeeActivityIntent = new Intent(MainActivity.this, CoffeeActivity.class);
    Intent gasActivityIntent = new Intent(MainActivity.this, GasStationsActivity.class);
    Intent hospitalsActivityIntent = new Intent(MainActivity.this, HospitalsActivity.class);
    Intent hotelsActivityIntent = new Intent(MainActivity.this, HotelsActivity.class);
    Intent movieTheatersActivityIntent = new Intent(MainActivity.this, MovieTheatersActivity.class);
    Intent pharmacyActivityIntent = new Intent(MainActivity.this, PharmacyActivity.class);
    Intent restaurantsActivityIntent = new Intent(MainActivity.this, RestaurantsActivity.class);
    Intent supermarketsActivityIntent = new Intent(MainActivity.this, SupermarketsActivity.class);

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

        banksTextView.setOnClickListener(this);
        coffeeTextView.setOnClickListener(this);
        gasStationsTextView.setOnClickListener(this);
        hospitalsTextView.setOnClickListener(this);
        hotelsTextView.setOnClickListener(this);
        movieTheatersTextView.setOnClickListener(this);
        pharmacyTextView.setOnClickListener(this);
        restaurantsTextView.setOnClickListener(this);
        supermarketsTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.banksTextView:
                startActivity(banksActivityIntent);
                break;
            case R.id.coffeeTextView:
                startActivity(coffeeActivityIntent);
                break;
            case R.id.gasStationTextView:
                startActivity(gasActivityIntent);
                break;
            case R.id.hospitalsTextView:
                startActivity(hospitalsActivityIntent);
                break;
            case R.id.hotelsTextView:
                startActivity(hotelsActivityIntent);
                break;
            case R.id.movieTheatersTextView:
                startActivity(movieTheatersActivityIntent);
                break;
            case R.id.pharmacyTextView:
                startActivity(pharmacyActivityIntent);
                break;
            case R.id.restaurantsTextView:
                startActivity(restaurantsActivityIntent);
                break;
            case R.id.supermarketTextView:
                startActivity(supermarketsActivityIntent);
                break;

        }
    }


}