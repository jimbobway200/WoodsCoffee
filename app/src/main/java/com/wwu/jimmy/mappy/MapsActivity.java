package com.wwu.jimmy.mappy;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Spinner unitTypeSpinner;


    //Location GPS Cords
    static final LatLng Pos1 = new LatLng(48.801021, -122.486544); // Woods Coffee Guide Meridian
    static final LatLng Pos2 = new LatLng(48.790391, -122.496157); // Woods Coffee BakerView
    static final LatLng Pos3 = new LatLng(48.769465, -122.448264); // Woods Coffee Barkley Village
    static final LatLng Pos4 = new LatLng(48.755886, -122.464228); // Woods Coffee James St
    static final LatLng Pos5 = new LatLng(48.752264, -122.480364); // Woods Coffee Flatiron
    static final LatLng Pos6 = new LatLng(48.748190, -122.480879); // Woods Coffee Railroad Ave
    static final LatLng Pos7 = new LatLng(48.745586, -122.464228); // Woods Coffee Lakeway
    static final LatLng Pos8 = new LatLng(48.732001, -122.471438); // Woods Coffee Sehome
    static final LatLng Pos9 = new LatLng(48.730416, -122.503710); // Woods Coffee Boulevard Park
    static final LatLng Pos10 = new LatLng(48.452357, -122.336641); // Woods Coffee Burlington
    static final LatLng Pos11 = new LatLng(48.435618, -122.341877); // Woods Coffee Mount Vernon
    static final LatLng home = new LatLng(48.738794, -122.484656); // WWU
    static final String Pos1_string = "Guide Meridian";
    static final String Pos2_string = "BakerView";
    static final String Pos3_string = "Barkley Village";
    static final String Pos4_string = "James St";
    static final String Pos5_string = "Flatiron";
    static final String Pos6_string = "Railroad Ave";
    static final String Pos7_string = "Lakeway";
    static final String Pos8_string = "Sehome";
    static final String Pos9_string = "Boulevard Park";
    static final String Pos10_string = "Burlington";
    static final String Pos11_string = "Mount Vernon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        addListenerForSpinner();
        setUpMapIfNeeded();
//        centerOnPoint(50);
    }

    private void addListenerForSpinner() {

        unitTypeSpinner = (Spinner) findViewById(R.id.unit_Place_Spinner);
        unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                centerOnPoint(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                centerOnPoint(50);
            }
        });
    }

    private void centerOnPoint(int position) {
            switch (position){
                case 0:
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(home));
                    break;
                case 1:
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(Pos2));
                    break;
                case 2:
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(Pos3));
                    break;
                case 3:
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(Pos4));
                    break;
                case 4:
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(Pos5));
                    break;
                default:
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(home));

            }
            mMap.animateCamera(CameraUpdateFactory.zoomTo(13));

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 14.0f));
//        mMap.animateCamera(CameraUpdateFactory.zoomTo(13));

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.addMarker(new MarkerOptions().position(Pos1).title(Pos1_string));
        mMap.addMarker(new MarkerOptions().position(Pos2).title(Pos2_string));
        mMap.addMarker(new MarkerOptions().position(Pos3).title(Pos3_string));
        mMap.addMarker(new MarkerOptions().position(Pos4).title(Pos4_string));
        mMap.addMarker(new MarkerOptions().position(Pos5).title(Pos5_string));
        mMap.addMarker(new MarkerOptions().position(Pos6).title(Pos6_string));
        mMap.addMarker(new MarkerOptions().position(Pos7).title(Pos7_string));
        mMap.addMarker(new MarkerOptions().position(Pos8).title(Pos8_string));
        mMap.addMarker(new MarkerOptions().position(Pos9).title(Pos9_string));
        mMap.addMarker(new MarkerOptions().position(Pos10).title(Pos10_string));
        mMap.addMarker(new MarkerOptions().position(Pos11).title(Pos11_string));


//        centerOnPoint(50); //will tell it to focus on WWU as default


    }
}
