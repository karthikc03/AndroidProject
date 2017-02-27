package com.example.karth.myapplication;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecycler extends Fragment {

    private static final String URL_DATA = "http://quocnguyen.16mb.com/products.json";
   private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<ListItem> listItems;
    final int MY_PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION = 10;


    public FragmentRecycler() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // RecyclerView recyclerView;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItems = new ArrayList<>();

        loadRecyclerViewData();
        return view;
    }
    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loadind Data....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray jsonArray = jsonObject.getJSONArray("products");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject o = jsonArray.getJSONObject(i);
                                ListItem item = new ListItem(
                                        o.getString("name"),
                                        o.getString("price"),
                                        o.getString("image"));
                                listItems.add(item);
                            }

//                            JSONObject raceTable = jsonArray.getJSONObject("RaceTable");
//                            JSONArray array = raceTable.getJSONArray("Races");
//
//                            for (int i = 0; i < array.length(); i++) {
//                                JSONObject o = array.getJSONObject(i);
//                                ListItem item = new ListItem(o.getString("raceName"),
//                                        o.getString("season"),
//                                        o.getString("url"));


                            adapter = new MyAdapter(listItems,getContext() );
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"Error",Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        requestQueue.add(stringRequest);
    }


}
