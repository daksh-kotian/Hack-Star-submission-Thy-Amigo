package com.example.thy_amigo_forever;

//this took a hell lot of my brain-cells to sort !

import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.thy_amigo_forever.databinding.ActivityMapsBinding;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.thy_amigo_forever.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsActivity";

    private static final int ERROR_DIALOG_REQUEST= 9001;

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

        //vc
        if(isServicesOK()){
            init();
        }

    }

    //VIDEO CODE BEGINS
    private void init(){


    }
    public boolean isServicesOK() {
        Log.d(TAG, "isServicesOK: checking google serivces version");

        int available= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MapsActivity.this);

        if(available == ConnectionResult.SUCCESS){
            // everything is good and user can make request
            Log.d(TAG, "isServicesOK: working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            // an error occ but can be resolved jab version galat hoga toh aega ye
            Log.d(TAG, "isServicesOK: error occ but kr lenge");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MapsActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else {
            Toast.makeText(this, "we can't make map request ",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    //video code ends
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
        LatLng taj= new LatLng(28.67625369360164, 77.46850753684167);
        // mMap.addMarker(new MarkerOptions().position(target).title("Marker in Sydney"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(target));
        LatLng ghaziabad = new LatLng(28.676791, 77.471661);
        LatLng mrk1 = new LatLng(28.67607776808457, 77.46248892938947);
        LatLng mrk2 = new LatLng(28.6751289996994, 77.46392087896069);
        LatLng mrk3 = new LatLng(28.67442192026655, 77.45558446124551);
        LatLng mrk4 = new LatLng(28.673951068455715, 77.46664113295182);



        ArrayList<LatLng> list = new ArrayList<>();
        list.add(new LatLng(28.675526090562418, 77.4551268536893));
        mMap.addMarker(new MarkerOptions().position(new LatLng(28.675526090562418, 77.4551268536893)).title("Marker in Sydney")
                // below line is use to add custom marker on our map.
                .icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_baseline_airport_shuttle_24)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(28.675526090562418, 77.4551268536893)));
        list.add(new LatLng(28.674227247362342, 77.45542859228355));
        list.add(new LatLng( 28.676487, 77.470494));
        list.add(new LatLng(28.678740, 77.484555));
        mMap.addMarker(new MarkerOptions().position(new LatLng(28.678740, 77.484555)).title("Marker in Sydney")
                // below line is use to add custom marker on our map.
                .icon(BitmapFromVector(getApplicationContext(), R.drawable.iclocal_hospital)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(28.678740, 77.484555)));

        PolylineOptions options = new PolylineOptions().geodesic(true);
        for (int z = 0; z < list.size(); z++) {
            LatLng point = list.get(z);
            options.add(point);
        }
        mMap.addPolyline(options);
        CameraPosition cameraPosition;
        // cameraPosition = new CameraPosition.Builder().target(new LatLng(28.6786445,77.4685118)).zoom(15).build();

        // mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        //main marker and zoom function and restrictions
        boolean isOnRoute = PolyUtil.isLocationOnEdge(taj,list, false, 10.0f);
        if(isOnRoute) {
            mMap.addMarker(new MarkerOptions().position(ghaziabad).title("Marker in Sydney")
                    // below line is use to add custom marker on our map.
                    .icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_local_police)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ghaziabad));

            mMap.addMarker(new MarkerOptions().position(mrk2).title("Marker in Sydney")
                    // below line is use to add custom marker on our map.
                    .icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_local_police)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mrk2));

            mMap.addMarker(new MarkerOptions().position(mrk3).title("Marker in Sydney")
                    // below line is use to add custom marker on our map.
                    .icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_local_police)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mrk3));

            cameraPosition = new CameraPosition.Builder().target(new LatLng(28.6795104,77.4758446)).zoom(15).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            Toast.makeText(this, "Officer 1,Providing ON-ROUTE ASSISTANCE ",Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Officer 3,Providing ON-ROUTE ASSISTANCE ",Toast.LENGTH_SHORT).show();

        }
        else{
            cameraPosition = new CameraPosition.Builder().target(new LatLng(28.6786445,77.4685118)).zoom(15).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));




        }
        boolean isOnRoute2 = PolyUtil.isLocationOnEdge(ghaziabad,list, false, 100.0f);
        if(isOnRoute2) {
            mMap.addMarker(new MarkerOptions().position(mrk1).title("Marker in Sydney")
                    .icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_denial_police)) );
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mrk1));

            mMap.addMarker(new MarkerOptions().position(mrk4).title("Marker in Sydney")
                    .icon(BitmapFromVector(getApplicationContext(), R.drawable.ic_denial_police)) );
            mMap.moveCamera(CameraUpdateFactory.newLatLng(mrk4));

            cameraPosition = new CameraPosition.Builder().target(new LatLng(28.6786445,77.4685118)).zoom(15).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            Toast.makeText(this, "Officer 2,Out of range ",Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Officer 4,Out of range ",Toast.LENGTH_SHORT).show();

        }
        else{
            cameraPosition = new CameraPosition.Builder().target(new LatLng(28.6786445,77.4685118)).zoom(15).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            Toast.makeText(this, "2nd point out of range ",Toast.LENGTH_SHORT).show();

        }





    }
    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        // below line is use to generate a drawable.
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);

        // below line is use to set bounds to our vector drawable.
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());

        // below line is use to create a bitmap for our
        // drawable which we have added.
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        // below line is use to add bitmap in our canvas.
        Canvas canvas = new Canvas(bitmap);

        // below line is use to draw our
        // vector drawable in canvas.
        vectorDrawable.draw(canvas);

        // after generating our bitmap we are returning our bitmap.
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

}