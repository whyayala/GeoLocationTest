package com.example.jacobi.geolocationtest;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Use the LocationManager class to obtain GPS locations
        LocationManager mlocManager =
                (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        // Location Listener for each time the GPS senses new location.
        LocationListener mlocListener = new MyLocationListener();
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);

        // Class My Location Listener
        public class MyLocationListener implements LocationListener {

            @Override
            public void onLocationChanged(Location loc) {
                loc.getLatitude();
                loc.getLongitude();
                String Text = "My current location is: " +
                        "Latitude = " + loc.getLatitude() +
                        "Longitude = " + loc.getLongitude();
                Toast.makeText(
                        getApplicationContext(),
                        Text,
                        Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onProviderDisabled(String provider) {
                Toast.makeText(
                        getApplicationContext(),
                        "Gps Disabled",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProviderEnabled(String provider){
                Toast.makeText(
                        getApplicationContext(),
                        "Gps Enabled",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras){}

        }
        //End My Location Listener
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
