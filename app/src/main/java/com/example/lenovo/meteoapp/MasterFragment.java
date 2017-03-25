package com.example.lenovo.meteoapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static com.example.lenovo.meteoapp.R.id.equivalent_bttn;


public class MasterFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_master, container, false);
        Button equivalentButton = (Button)view.findViewById(equivalent_bttn);
        Button temperatureButton = (Button)view.findViewById(R.id.temperature_bttn);
        Button humidityButton = (Button) view.findViewById(R.id.humidity_bttn);
        Button cloudButton = (Button) view.findViewById(R.id.cloud_bttn);
        final MainActivity activity = (MainActivity) getActivity();

        equivalentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.showEquivalentView();
            }
        });

        temperatureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.showTemperatureView();
            }
        });

        humidityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.showHumidityView();
            }
        });

        cloudButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.showCloudView();
            }
        });

        return view;
    }

}
