package com.aradwan054.fcis_activites;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context context;
    ArrayList<Activity> activities;


    public RecyclerViewAdapter(ArrayList<Activity> activitieList, Context context) {
        this.activities = activitieList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        final DB_SQL db = new DB_SQL(context);
        final Activity activity = activities.get(position);
        holder.Aname.setText(activities.get(position).getActivity_name());
        if (activity.getActivity_foreGround() != null)
            Glide.with(context).load(activity.getActivity_foreGround()).into(holder.Aposter);
        else Glide.with(context).load(R.drawable.fcis).into(holder.Aposter);
        holder.Adetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, details.class);
                intent.putExtra("activityName", activity.getActivity_name());
                intent.putExtra("activityVision", activity.getActivity_vision());
                intent.putExtra("activityMission", activity.getActivity_mission());
                intent.putExtra("activitybackground", activity.getActivity_backGround());
                intent.putExtra("activityforeground", activity.getActivity_foreGround());
                intent.putExtra("activityYear", activity.getActivity_year());
                context.startActivity(intent);
            }
        });
        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertData(activity.getActivity_name());

            }
        });


    }

    @Override
    public int getItemCount() {
        if (activities == null) return 0;
        return activities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Aname;
        ImageView Aposter, fav;
        Button Adetails;


        public MyViewHolder(View view) {
            super(view);
            Aname = view.findViewById(R.id.ActivityName);
            Aposter = view.findViewById(R.id.poster);
            Adetails = view.findViewById(R.id.btnDetails);
            fav = view.findViewById(R.id.favorite);
        }
    }
}
