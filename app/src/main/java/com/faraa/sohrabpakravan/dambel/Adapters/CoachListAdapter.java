package com.faraa.sohrabpakravan.dambel.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.faraa.sohrabpakravan.dambel.Activities.CoachProfile;
import com.faraa.sohrabpakravan.dambel.Models.Coaches;
import com.faraa.sohrabpakravan.dambel.R;


import java.util.ArrayList;

public class CoachListAdapter extends RecyclerView.Adapter<CoachListAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Coaches> coachData;
    private CoachListAdapter.ItemClickListener mClickListener;

    public CoachListAdapter(Context _context, ArrayList<Coaches> _data) {

       this. context = _context;
        this.coachData = _data;

    }

    @Override
    public CoachListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coach_list_layout, null);

        CoachListAdapter.MyViewHolder viewHolder = new CoachListAdapter.MyViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(CoachListAdapter.MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        Coaches coaches = coachData.get(position);

        holder.mImageView.setImageResource(coaches.getImage());
        holder.name.setText(coaches.getName());
        holder.speciality.setText(coaches.getSpeciality());
        holder.price.setText(coaches.getPrice());



    }

    @Override
    public int getItemCount() {
        return (null != coachData ? coachData.size() : 0);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        protected ImageView mImageView;
        protected TextView name;
        protected TextView speciality;
        protected TextView price;


        MyViewHolder(View itemView) {
            super(itemView);
            this.mImageView = itemView.findViewById(R.id.coach_picture);
            this.name = itemView.findViewById(R.id.coach_name);
            this.speciality = itemView.findViewById(R.id.coach_speciality);
            this.price = itemView.findViewById(R.id.session_price);


            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, CoachProfile.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
     Coaches getItem(int id) {

        return coachData.get(id);
    }

    // allows clicks events to be caught
     void setClickListener(CoachListAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
