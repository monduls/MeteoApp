package com.example.lenovo.meteoapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CloudFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewCloud = inflater.inflate(R.layout.fragment_cloud, container, false);

        final TextView metersBaseView = (TextView) viewCloud.findViewById(R.id.cloud_base_meters_view);
        final TextView feetBaseView = (TextView) viewCloud.findViewById(R.id.cloud_base_feet_view);
        final EditText temperatureEdit = (EditText) viewCloud.findViewById(R.id.temperature_edit);
        final EditText dewPointEdit = (EditText) viewCloud.findViewById(R.id.dew_point_edit);
        Button cloudCount = (Button) viewCloud.findViewById(R.id.cloud_count_bttn);

        cloudCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double temp = Double.parseDouble(temperatureEdit.getText().toString());
                    double dew = Double.parseDouble(dewPointEdit.getText().toString());
                    if(dew>temp){
                        metersBaseView.setText("Temp. punktu rosy wyższa niż temperatura powietrza");
                        feetBaseView.setText("Wprowadź poprawne dane");
                    }
                    else {
                    double cloudBase = (temp-dew)*125;
                    metersBaseView.setText("Podstawa chmur: " + String.format("%.2f", cloudBase)+ " m");

                    double cloudBaseFeet = cloudBase*0.33;
                    feetBaseView.setText("Podstawa chmur: " + String.format("%.2f", cloudBaseFeet) + " ft");}


                } catch (NumberFormatException e) {
                    metersBaseView.setText("Błędne dane");
                }
            }
        });

        return viewCloud;
    }
}
