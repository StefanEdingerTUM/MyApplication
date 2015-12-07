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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ibrahim on 30/11/2015.
 */
public class OffersFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offers, container,
                false);

        //Spinner Parking Size
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Small Parking Space");
        list.add("Normal Parking Space");
        list.add("Big Parking Space");
        list.add("Very Big Parking Space");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);


        //Spinner Offer type
        Spinner spinner2 = (Spinner) view.findViewById(R.id.spinner_type);
        List<String> list2 = new ArrayList<String>();
        list2.add("Money");
        list2.add("Morning Coffee");
        list2.add("Beer");
        list2.add("Coupon");
        list2.add("Paying the current parking time");
        list2.add("Others");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);

        Button timeButton = (Button) view.findViewById(R.id.timeButton);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");
            }
        });

        Button submit = (Button) view.findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DialogFragment newFragment = new TimePickerFragment();
                // newFragment.show(getFragmentManager(), "timePicker");


                AlertDialog alertDialog;
                alertDialog = new AlertDialog.Builder(view.getContext()).create();
                alertDialog.setTitle("Successful");
                alertDialog.setMessage("Your Offer has been registered!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                MainActivity.fragmentManager.beginTransaction()
                                        .replace(R.id.container, new OfferOverviewFragment())
                                        .commit();
                                dialog.dismiss();

                            }
                        });
                alertDialog.show();
            }
        });

        return view;
    }
}

