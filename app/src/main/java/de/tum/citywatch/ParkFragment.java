package de.tum.citywatch;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ibrahim on 30/11/2015.
 */
public class ParkFragment extends Fragment {

    private Button parkButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflat and return the layout
        final View view = inflater.inflate(R.layout.fragment_park, container,
                false);

        //Country Spinner
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner_country);
        List<String> list = new ArrayList<String>();
        list.add("Germany");
        list.add("USA");
        list.add("Japan");
        list.add("China");
        list.add("France");
        list.add("Brasil");
        list.add("England");
        list.add("Italy");
        list.add("Russia");
        list.add("Canada");
        list.add("India");
        list.add("Australia");
        list.add("Mexico");
        list.add("South Korea");
        list.add("Indonesia");
        list.add("Turky");
        list.add("Saudi Arabia");
        list.add("Argentina");
        list.add("South Africa");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        //City Spinner
        Spinner spinner2 = (Spinner) view.findViewById(R.id.spinner_city);
        List<String> list2 = new ArrayList<String>();
        list2.add("Berlin");
        list2.add("Hamburg");
        list2.add("München");
        list2.add("Köln");
        list2.add("Frankfurt am Main");
        list2.add("Stuttgart");
        list2.add("Düsseldorf");
        list2.add("Dortmund");
        list2.add("Essen");
        list2.add("Bremen");
        list2.add("Leipzig");
        list2.add("Hannover");
        list2.add("Nürnberg");
        list2.add("Duisburg");
        list2.add("Bochum");
        list2.add("Wuppertal");
        list2.add("Bielefeld");
        list2.add("Bonn");
        list2.add("Münster");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);


        Button submit = (Button) view.findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DialogFragment newFragment = new TimePickerFragment();
                // newFragment.show(getFragmentManager(), "timePicker");


                AlertDialog alertDialog;
                alertDialog = new AlertDialog.Builder(view.getContext()).create();
                alertDialog.setTitle("Successful");
                alertDialog.setMessage("Your Park Space has been registered!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                alertDialog.show();
            }
        });


        Button timeButton_begin = (Button) view.findViewById(R.id.begin_time);
        timeButton_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");


            }
        });

        Button timeButton_end = (Button) view.findViewById(R.id.end_time);
        timeButton_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");

            }
        });



        return view;
    }
}
