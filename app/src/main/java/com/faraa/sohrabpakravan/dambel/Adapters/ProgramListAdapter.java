package com.faraa.sohrabpakravan.dambel.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.faraa.sohrabpakravan.dambel.Activities.DailyProgramActivity;
import com.faraa.sohrabpakravan.dambel.Models.ProgramListModel;
import com.faraa.sohrabpakravan.dambel.R;

import java.util.ArrayList;

public class ProgramListAdapter extends RecyclerView.Adapter<ProgramListAdapter.MyViewHolder> {
    private ArrayList<ProgramListModel> programeList;
    private Context mContext;
    private ItemClickListener mClickListener;


    public ProgramListAdapter(Context context, ArrayList<ProgramListModel> _programList) {
        this.programeList = _programList;
        this.mContext = context;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ProgramListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_list_layout, null);

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        ProgramListModel program = programeList.get(position);

        holder.coachPic.setImageResource(program.getCoachImage());
        holder.coachName.setText(program.getName());
        holder.coachSpeciality.setText(program.getSpeciality());
        holder.ProgramIcon.setImageResource(program.getProgramImage());
        holder.programText.setText(program.getProgramType());



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return (null != programeList ? programeList.size() : 0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        protected ImageView coachPic;
        protected ImageView ProgramIcon;
        protected TextView coachName;
        protected TextView coachSpeciality;
        protected TextView programText;


        MyViewHolder(View itemView) {
            super(itemView);
            this.coachPic = (ImageView) itemView.findViewById(R.id.coach_picture);
            this.ProgramIcon = (ImageView) itemView.findViewById(R.id.iv_program);
            this.coachName = (TextView) itemView.findViewById(R.id.coach_name);
            this.coachSpeciality = (TextView) itemView.findViewById(R.id.coach_speciality);
            this.programText = (TextView) itemView.findViewById(R.id.tv_program);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, DailyProgramActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }
            });

            //itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    ProgramListModel getItem(int id) {

        return programeList.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}


