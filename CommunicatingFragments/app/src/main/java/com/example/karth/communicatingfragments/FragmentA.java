package com.example.karth.communicatingfragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {
int count =0;

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(savedInstanceState != null){

            count = savedInstanceState.getInt("mycount");

        }
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                count ++;

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.incrementValue(count);
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mycount",count);
    }



}
