package com.denis.cobagooglemaps;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.denis.cobagooglemaps.databinding.ActivityMapsBinding;

import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-7.3305, 110.5084);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15.0f));

        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        mMap.addMarker(new MarkerOptions().position(latLng).title("New Marker"));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        mMap.addMarker(new MarkerOptions().position(latLng).title("New LongClick Marker"));

        getCompleteAddressString(latLng);
    }

    private String getCompleteAddressString(LatLng latLng) {
        String ret = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
                    stringBuilder.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                ret = stringBuilder.toString();
                Log.w("Current location", ret);
            } else {
                Log.w("Current location", "No Address returned!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.w("Current location", "Can't get Address!");
        }
        return ret;
    }

}