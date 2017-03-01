package com.example.karth.myapplication;

import android.*;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

   final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragmentRecycler = getFragmentManager().findFragmentById(R.id.fragment);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_races) {

            startActivity(new Intent(this,Race_Activity.class));


        }



        if (id == R.id.action_mapactivity) {

            //startActivity(new Intent(this,Map_Activity.class));
            Toast.makeText(this,"You entered map activity",Toast.LENGTH_SHORT).show();
           manageMapActivity();

        }
        return super.onOptionsItemSelected(item);
    }
    //Marshmellow permissions

    private void manageMapActivity() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION);
        } else {
            readLocation();
        }

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void readLocation() {
        startActivity(new Intent(this,Map_Activity.class));

        // Toast.makeText(this, "Accessing Location", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    readLocation();
                else {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_EXTERNAL_STORAGE))
                    {
                        new AlertDialog.Builder(this).
                                setTitle("Access Location").
                                setMessage("You NEED to Grant Permission to Access Location").show();

                    }else {
                        new AlertDialog.Builder(this).
                                setTitle("Access Location_PERMISSION Denied").
                                setMessage("To use Maps Please provide permssions to access Maps.").show();

                    }


                }
                break;
        }



    }

}
