package com.example.lenovo.meteoapp;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TemperatureFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewTemp = inflater.inflate(R.layout.fragment_temperature, container, false);
        final TextView tempSumView = (TextView) viewTemp.findViewById(R.id.temperature_sum_view);
        final TextView tempAvgView = (TextView) viewTemp.findViewById(R.id.temperature_av_view);
        final EditText temp7Edit = (EditText) viewTemp.findViewById(R.id.temp7_edit);
        final EditText temp19Edit = (EditText) viewTemp.findViewById(R.id.temp19_edit);
        final EditText tempMaxEdit = (EditText) viewTemp.findViewById(R.id.temp_max_edit);
        final EditText tempMinEdit = (EditText) viewTemp.findViewById(R.id.temp_min_edit);
        Button countTemp = (Button) viewTemp.findViewById(R.id.temperature_count_bttn);

        countTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    double temp7 = Double.parseDouble(temp7Edit.getText().toString());
                    double temp19 = Double.parseDouble(temp19Edit.getText().toString());
                    double tempMax = Double.parseDouble(tempMaxEdit.getText().toString());
                    double tempMin = Double.parseDouble(tempMinEdit.getText().toString());

                    double resultSum = temp7+temp19+tempMax+tempMin;
                    tempSumView.setText("Suma temperatur: " + String.format("%.2f", resultSum));

                    double resultAvg = resultSum/4;
                    tempAvgView.setText("Średnia temperatura: " + String.format("%.2f", resultAvg));

                }catch (NumberFormatException e) {
                    tempSumView.setText("Błędne dane");
                }
            }
        });
        return viewTemp;
    }

}
