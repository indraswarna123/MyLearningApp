package com.example.mylearningapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_list);

        ArrayList humans = new ArrayList<Human>();
        humans.add(new Human("ADD USER", "", "", R.drawable.ic_android_black_24dp));
        humans.add(new Human("CREATE USER", "", "", R.drawable.ic_android_black_24dp));
        humans.add(new Human("LOG OUT", "", "", R.drawable.ic_android_black_24dp));

        RecyclerView recyclerView = findViewById(R.id.recycler_view); //Recycler View Only
        recyclerView.setAdapter(new HumanListAdapter(humans, this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

    }

    class HumanListAdapter extends RecyclerView.Adapter<HumanViewHolder>{

        private ArrayList<Human> humans;
        private Context context;

        public HumanListAdapter(ArrayList<Human> humans, Context context) {
            this.humans = humans;
            this.context = context;
        }

        @NonNull
        @Override
        public HumanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            Context context = viewGroup.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.row_second_list_view, viewGroup, false); //DISPLAY LIST
            return new HumanViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull HumanViewHolder humanViewHolder, int position) {
            Human h = humans.get(position);
            humanViewHolder.nameView.setText(h.getName());
            humanViewHolder.addressView.setText(h.getAddress());
            humanViewHolder.idView.setText(h.getId());

            humanViewHolder.imageView.setImageDrawable(context.getDrawable(h.getImageresourceId()));
            //humanViewHolder.imageView.setImageResource(h.getImageresourceId());

            //humanViewHolder.imageView.setOnClickListener();
        }

        @Override
        public int getItemCount() {
            return humans.size();
        }
    }

    class HumanViewHolder extends RecyclerView.ViewHolder{

        protected ImageView imageView;
        protected TextView nameView;
        protected TextView addressView;
        protected TextView idView;


        public HumanViewHolder(@NonNull View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.imageid);
            nameView = itemView.findViewById(R.id.humanid);
            addressView = itemView.findViewById(R.id.addressid);
            idView = itemView.findViewById(R.id.normalid);
        }
    }

    class Human{

        String name;
        String id;
        String address;

        int imageresourceId = R.drawable.fahrplan;


        public Human(String name, String id, String address, int imageresourceId) {
            this.name = name;
            this.id = id;
            this.address = address;
            this.imageresourceId = imageresourceId;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public String getAddress() {
            return address;
        }

        public int getImageresourceId() {
            return imageresourceId;
        }
    }
}
