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
<<<<<<< HEAD
=======
        parkButton = (Button) view.findViewById(R.id.parkButton);
        parkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ParkFragment.this.getActivity().getApplicationContext() , "park button pressed", Toast.LENGTH_SHORT);
            }
        });
>>>>>>> b473f6d4c5f4667e2b88c041adc8bf897f21070c
        // Perform any camera updates here
        return view;
    }
}
