package com.example.lenovo.meteoapp;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class HumidityFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewHumid =  inflater.inflate(R.layout.fragment_humidity, container, false);
        final EditText humidity7Edit = (EditText) viewHumid.findViewById(R.id.humidity7_edit);
        final EditText humidity13Edit = (EditText) viewHumid.findViewById(R.id.humidity13_edit);
        final EditText humidity19Edit = (EditText) viewHumid.findViewById(R.id.humidity19_edit);
        Button count = (Button) viewHumid.findViewById(R.id.humidity_count_bttn);
        final TextView humiditySumView = (TextView) viewHumid.findViewById(R.id.humidity_sum_view);
        final TextView humidityAvgView = (TextView) viewHumid.findViewById(R.id.humidity_avg_view);

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    double humidity7 = Double.parseDouble(humidity7Edit.getText().toString());
                    double humidity13 = Double.parseDouble(humidity13Edit.getText().toString());
                    double humidity19 = Double.parseDouble(humidity19Edit.getText().toString());

                    double resultSum = humidity7*2+humidity13+humidity19;
                    humiditySumView.setText("Suma wilgotności: " + String.format("%.2f", resultSum));

                    double resultAvg = resultSum/4;
                    humidityAvgView.setText("Średnia wilgotność: " + String.format("%.2f", resultAvg));

                }catch (NumberFormatException e) {
                    humiditySumView.setText("Błędne dane");
                }
            }
        });

        return viewHumid;
    }

}
