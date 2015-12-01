package de.tum.citywatch;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
        //TODO:: demo button action
        parkButton = (Button) view.findViewById(R.id.parkButton);
        parkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext() , "park button pressed", Toast.LENGTH_SHORT);
            }
        });
        // Perform any camera updates here
        return view;
    }
}
