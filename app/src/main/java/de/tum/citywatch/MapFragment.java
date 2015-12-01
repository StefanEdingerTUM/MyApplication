package de.tum.citywatch;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

/**
 * A fragment that launches other parts of the demo application.
 */
public class MapFragment extends com.google.android.gms.maps.MapFragment {

<<<<<<< HEAD

=======
    MapView mMapView;
    private GoogleMap googleMap;
>>>>>>> b473f6d4c5f4667e2b88c041adc8bf897f21070c

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container,
                false);
<<<<<<< HEAD
=======
        mMapView = (MapView) view.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
>>>>>>> b473f6d4c5f4667e2b88c041adc8bf897f21070c

        // Perform any camera updates here
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
<<<<<<< HEAD

=======
        mMapView.onResume();
        if(mMapView != null) {
            googleMap = mMapView.getMap();
            if (googleMap != null) {
                googleMap.getUiSettings().setMyLocationButtonEnabled(true);
                googleMap.setMyLocationEnabled(true);
                googleMap.getUiSettings().setZoomControlsEnabled(true);
            }
        }
>>>>>>> b473f6d4c5f4667e2b88c041adc8bf897f21070c
    }

    @Override
    public void onPause() {
        super.onPause();
<<<<<<< HEAD
=======
        mMapView.onPause();
>>>>>>> b473f6d4c5f4667e2b88c041adc8bf897f21070c
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
<<<<<<< HEAD
=======
        mMapView.onDestroy();
>>>>>>> b473f6d4c5f4667e2b88c041adc8bf897f21070c
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
<<<<<<< HEAD
=======
        mMapView.onLowMemory();
>>>>>>> b473f6d4c5f4667e2b88c041adc8bf897f21070c
    }
}