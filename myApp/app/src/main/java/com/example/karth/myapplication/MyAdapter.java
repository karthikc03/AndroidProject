package com.example.karth.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.example.karth.myapplication.R.id.imageView;
import static com.example.karth.myapplication.R.id.imageView2;

/**
 * Created by karth on 2/23/2017.
 */



    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private ArrayList<ListItem> listItems;
        private Context context;
        int resource;

        public MyAdapter(ArrayList<ListItem> listItems, Context context) {
            this.listItems = listItems;
            this.context = context;

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ViewHolder(v,context,listItems);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            ListItem listItem = listItems.get(position);
            holder.textviewHead.setText(listItem.getHead());
            holder.textViewDesc.setText(listItem.getDesc());
            Picasso.with(context).load(listItem.getImageUrl()).into(holder.imageView);

        }

        @Override
        public int getItemCount() {
            return listItems.size();
        }

        public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {

            public TextView textviewHead;
            public TextView textViewDesc;
            public ImageView imageView;
            List<ListItem> items = new ArrayList<>();
            Context context;

            public ViewHolder(View itemView, Context context, ArrayList<ListItem> items) {
                super(itemView);
                this.items=items;
                this.context = context;
                itemView.setOnClickListener(this);
                textviewHead = (TextView) itemView.findViewById(R.id.textViewHead);
                textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
                imageView=(ImageView) itemView.findViewById(imageView2);

            }

            @Override
            public void onClick(View v) {

                int position = getAdapterPosition();
                ListItem item = this.items.get(position);
                Intent intent = new Intent (this.context,Details.class);
                intent.putExtra("imgid",item.getImageUrl());
                intent.putExtra("head",item.getHead());
                intent.putExtra("desc",item.getDesc());
                this.context.startActivity(intent);
            }
        }
    }

