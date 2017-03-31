package com.example.karth.communicatingfragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {

int count;

    TextView textview;
    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_b, container, false);
        textview = (TextView) view.findViewById(R.id.textview);

        if(savedInstanceState != null){

            count = savedInstanceState.getInt("mycount");
            textview.setText("Count :"+count);

        }
        return view;
    }

    public void setTheCount(int count) {
        this.count = count;

         textview.setText("Count :"+count);


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mycount",count);
    }
}
