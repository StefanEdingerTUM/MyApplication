package de.tum.citywatch;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ibrahim on 30/11/2015.
 */
public class OffersFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflat and return the layout
        View view = inflater.inflate(R.layout.fragment_offers, container,
                false);

        // Perform any camera updates here
        return view;
    }
}

