package com.example.jacobi.geolocationtest;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by jacobi on 9/14/15.
 */
// Class My Location Listener
public class MyLocationListener implements LocationListener {

    // Constructor that accepts Context as a param
    // Needed since MyLocationListener was moved outside of an Activity
    Context c;
    public MyLocationListener(Context context)
    {
        c = context;
    }

    @Override
    public void onLocationChanged(Location loc) {
        loc.getLatitude();
        loc.getLongitude();
        String Text =
                "My current location is: " + '\n' +
                        "Latitude = " + loc.getLatitude() + '\n' +
                        "Longitude = " + loc.getLongitude();
        Toast.makeText(
                c,
                Text,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(
                c,
                "Gps Disabled",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String provider){
        Toast.makeText(
                c,
                "Gps Enabled",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras){}

}
//End My Location Listener