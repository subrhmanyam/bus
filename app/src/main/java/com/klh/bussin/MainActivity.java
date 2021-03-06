package com.klh.bussin;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.LocationCallback;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList markerPoints = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    String routeSelected=null;
    @Override
    protected void onResume() {
        Intent intent = getIntent();

        // check intent is null or not
        if(intent != null){
            routeSelected = intent.getStringExtra("ROUTE");
        }

        super.onResume();
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
        FirebaseApp.initializeApp(this);
        /*LatLng pargatinagar = new LatLng(17.5186, 78.3963);
        LatLng miyapur = new LatLng(17.4699, 78.3578);
        LatLng haffezpet = new LatLng(17.484168, 78.360294);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pargatinagar, 12));

        ArrayList<LatLng> wayPoint = new ArrayList<>();
        wayPoint.add(miyapur);*/
        RouteInfo routeInfo = null;
        if(routeSelected.equalsIgnoreCase("route1")){
            routeInfo  = RouteHelper.getRoute1Info();
        }
        if(routeSelected.equalsIgnoreCase("route2")){
            routeInfo  = RouteHelper.getRoute2Info();
        }
        if(routeSelected.equalsIgnoreCase("route3")){
            routeInfo  = RouteHelper.getRoute3Info();
        }
        if(routeSelected.equalsIgnoreCase("route4")){
            routeInfo  = RouteHelper.getRoute4Info();
        }
        if(routeSelected.equalsIgnoreCase("route5")){
            routeInfo  = RouteHelper.getRoute5Info();
        }

        new GetPathFromLocation(this, routeInfo.source, routeInfo.destination, routeInfo.wayPoint, mMap, true, false, new DirectionPointListener() {
            @Override
            public void onPath(PolylineOptions polyLine) {
                mMap.addPolyline(polyLine);
            }
        }).execute();

    }

    private void setLocationFromServer() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String db_id = "klhdb";
        DatabaseReference myRef3 = database.getReference("current");
        GeoFire geoFire = new GeoFire(myRef3);
        geoFire.getLocation(routeSelected, new LocationCallback() {
            @Override
            public void onLocationResult(String key, GeoLocation location) {
                if (location != null) {
                    System.out.println(String.format("The location for key %s is [%f,%f]", key, location.latitude, location.longitude));
                } else {
                    System.out.println(String.format("There is no location for key %s in GeoFire", key));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.err.println("There was an error getting the GeoFire location: " + databaseError);
            }
        });
    }


}

