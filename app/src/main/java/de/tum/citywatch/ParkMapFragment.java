package de.tum.citywatch;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ParkMapFragment extends Fragment implements GoogleMap.OnMarkerClickListener {

    MapView mMapView;
    private GoogleMap googleMap;
    private Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflat and return the layout
        View view = inflater.inflate(R.layout.fragment_map, container,
                false);
        context = view.getContext();
        mMapView = (MapView) view.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();
        // latitude and longitude
        googleMap.setOnMarkerClickListener(this);
        //@tum 48.263130, 11.670211
        double latitude = 48.262773;
        double longitude = 11.669932;

        // create marker
        for (int i = 0; i < 10; i++) {
            MarkerOptions marker = new MarkerOptions()
                .position(new LatLng(latitude + (i * 0.0001), longitude + (i * 0.0001)))
                .title("spot" + (i + 1))
                .snippet("free in " + (i + 1)+ "0 min")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.park));
            googleMap.addMarker(marker);
        }

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(48.263130, 11.670211)).zoom(18).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);


        // Getting LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) mMapView.getContext().getSystemService(mMapView.getContext().LOCATION_SERVICE);

        // Creating a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Getting the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Getting Current Location
        Location location = locationManager.getLastKnownLocation(provider);

        if(location!=null) {
            // Getting latitude of the current location
            double latitude2 = location.getLatitude();

            // Getting longitude of the current location
            double longitude2 = location.getLongitude();

            // Creating a LatLng object for the current location
            LatLng latLng = new LatLng(latitude2, longitude2);

            googleMap.addMarker(new MarkerOptions().position(latLng).title("Start"));
        }
        // Perform any camera updates here
        return view;
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        //TODO
        Intent i = new Intent(context, SpotActivity.class);
        //i.putExtra("some_key", someData);
        startActivity(i);

        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}