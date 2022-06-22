package com.example.placestogo;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;

import android.os.Bundle;

import java.util.Collections;
import java.util.List;

public class CoffeeActivity extends AppCompatActivity {

    private PlacesClient placesClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        placesClient = Places.createClient(this);

        List<Place.Field> placeFields = Collections.singletonList(Place.Field.NAME);

    }


}