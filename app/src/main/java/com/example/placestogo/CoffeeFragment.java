package com.example.placestogo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CoffeeFragment extends Fragment {

    public CoffeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Coffee");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coffee, container, false);
    }
}