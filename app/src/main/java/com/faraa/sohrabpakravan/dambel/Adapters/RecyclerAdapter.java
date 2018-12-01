package com.faraa.sohrabpakravan.dambel.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.faraa.sohrabpakravan.dambel.Models.MoveImageData;
import com.faraa.sohrabpakravan.dambel.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<MoveImageData> moveImageList;
    private Context mContext;
    private ItemClickListener mClickListener;


    public RecyclerAdapter(Context context, ArrayList<MoveImageData> _moveImageList) {
        this.moveImageList = _moveImageList;
        this.mContext = context;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.moves_list_layout, null);

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        MoveImageData movesItems = moveImageList.get(position);

        holder.firstImageView.setImageResource(movesItems.getImageOne());
        holder.secondImageView.setImageResource(movesItems.getImageTwo());
        holder.thirdImageView.setImageResource(movesItems.getImageThree());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return (null != moveImageList ? moveImageList.size() : 0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        protected ImageView firstImageView;
        protected ImageView secondImageView;
        protected ImageView thirdImageView;

        MyViewHolder(View itemView) {
            super(itemView);
            this.firstImageView = (ImageView) itemView.findViewById(R.id.first_move_image);
            this.secondImageView = (ImageView) itemView.findViewById(R.id.second_move_image);
            this.thirdImageView = (ImageView) itemView.findViewById(R.id.third_move_image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    MoveImageData getItem(int id) {

        return moveImageList.get(id);
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


