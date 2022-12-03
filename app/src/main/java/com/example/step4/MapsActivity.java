package com.example.step4;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.step4.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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
        LatLng kelowna = new LatLng(49.86335622106017, -119.46068117860816);

        LatLng knox = new LatLng(49.908668262677146, -119.49113849753516);
        mMap.addMarker(new MarkerOptions().position(knox).title("Knox Mountain"));
        LatLng crawfordFalls = new LatLng(49.80493723366214, -119.45185181481705);
        mMap.addMarker(new MarkerOptions().position(crawfordFalls).title("Crawford Falls"));
        LatLng missionCreek = new LatLng(49.87877512092104, -119.43010895713549);
        mMap.addMarker(new MarkerOptions().position(missionCreek).title("Mission Creek Regional Park"));
        LatLng kloRegional = new LatLng(49.83039927921141, -119.3673504955017);
        mMap.addMarker(new MarkerOptions().position(kloRegional).title("KLO Creek Regional Park"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(kelowna));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(kelowna, 11));
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }
}