package com.example.karth.communicatingfragments;

//import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Below lines of code can also be used to add a fragment to out activity

//        FragmentA fragmentA = new FragmentA();
//
//        getFragmentManager().beginTransaction().add(R.id.layout_main,fragmentA,"MyFragmentA").commit();
    }

    public void incrementValue(int count) {


        FragmentB fragmentb = (FragmentB) getFragmentManager().findFragmentById(R.id.fragmentb);
        fragmentb.setTheCount(count);
    }


}
