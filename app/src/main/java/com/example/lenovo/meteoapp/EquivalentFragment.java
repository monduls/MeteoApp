package com.example.lenovo.meteoapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;


public class EquivalentFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_equivalent, container, false);
        final EditText coverEdit = (EditText) v.findViewById(R.id.cover_edit);
        final EditText scaleEdit = (EditText) v.findViewById(R.id.scale_edit);
        Button count = (Button) v.findViewById(R.id.equivalent_count_bttn);
        final TextView resultView = (TextView) v.findViewById(R.id.equivalent_result_view);


        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int cover = parseInt(coverEdit.getText().toString());
                    double scale = Double.parseDouble(scaleEdit.getText().toString());
                    double result = cover/(scale/10);
                            //depositLogic.calc(amount, percent, years);

                    resultView.setText(String.format("%.2f",result));
                }catch (NumberFormatException e) {
                    resultView.setText("Błędne dane");
                }
            }
        });
        return v;
    }


}
