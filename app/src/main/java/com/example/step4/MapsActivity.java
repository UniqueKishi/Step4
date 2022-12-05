package com.example.step4;

import static com.example.step4.LoginPage.lOB;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.step4.databinding.ActivityMapsBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        Map<String,String> mMarkerMap = new HashMap<>();


        lOB = lOB.read(getApplicationContext());

        ArrayList<Trails> t = new ArrayList<Trails>();
        ArrayList<Trails> listOfTrails;
        listOfTrails = lOB.getTrailList();
        if (listOfTrails == null || listOfTrails.isEmpty()) {

            Trails t1 = new Trails( "Knox Mountain", "Easy", "Easy", "Mountains", 4.5, 4, 49.908668262677146, -119.46068117860816);
            Trails t2 = new Trails( "Crawford Falls", "Easy", "Medium", "Waterfall", 5, 2, 49.80493723366214, -119.45185181481705);
            Trails t3 = new Trails( "Mission Creek Regional Park", "Easy", "Easy", "River", 4, 17, 49.87877512092104, -119.43010895713549);
            Trails t4 = new Trails( "KLO Creek Regional Park", "Easy", "Easy", "Mountains", 4.3, 3, 49.83039927921141, -119.3673504955017);
            t.add(t1);
            t.add(t2);
           t.add(t3);
            t.add(t4);

            lOB = new TrailList(t);

            lOB.writeToFile(lOB, getApplicationContext());

        }



        // Add a marker in Sydney and move the camera
        LatLng kelowna = new LatLng(49.86335622106017, -119.46068117860816);


        for (int i = 0; i < listOfTrails.size(); i++) {
            double lattemp, lontemp;
            String nametemp;
            Trails tempTrail = listOfTrails.get(i);

            lattemp = tempTrail.getLat();
            lontemp = tempTrail.getLon();
            nametemp = tempTrail.getName();

            LatLng temp = new LatLng(lattemp, lontemp);
            Marker marker = mMap.addMarker(new MarkerOptions().position(temp).title(nametemp));
            mMarkerMap.put(marker.getId(), tempTrail.getName());

        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kelowna));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(kelowna, 11));
        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                Trails trail = null;
                for(int i = 0; i < listOfTrails.size(); i++){
                    trail = listOfTrails.get(i);
                    if(trail.name.equals(marker.getTitle())){
                        break;
                    }
                }
                advancedTrailView(trail);
                return true;
            }
        });

    }

    public void search(View view){
        Intent intent= new Intent(this, Search.class);
        startActivity(intent);
    }

    public void logout(View view){
        Intent intent= new Intent(this, LoginPage.class);
        startActivity(intent);
        finish();
    }

    public void addtrail(View view){
        Intent intent= new Intent(this, Addtrail.class);
        startActivity(intent);


    }

    public void advancedTrailView(Trails trail){

        Intent intent=new Intent(this, trail_Description.class);
        Bundle bundle=new Bundle();
        bundle.putString("name",trail.name);
        bundle.putString("ease",trail.ease);
        bundle.putString("diff",trail.difficulty);
        bundle.putString("feats",trail.features);
        bundle.putDouble("rev",trail.review);
        bundle.putInt("length", trail.length);

        intent.putExtras(bundle);
        startActivity(intent);//starting activity

    }
}