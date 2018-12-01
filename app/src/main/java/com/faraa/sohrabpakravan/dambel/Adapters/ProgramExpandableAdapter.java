package com.faraa.sohrabpakravan.dambel.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;


import com.faraa.sohrabpakravan.dambel.Models.ProgramChildModel;
import com.faraa.sohrabpakravan.dambel.Models.ProgramGroupModel;
import com.faraa.sohrabpakravan.dambel.R;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class ProgramExpandableAdapter extends ExpandableRecyclerViewAdapter<ProgramExpandableAdapter.ProgramGroupViewHolder, ProgramExpandableAdapter.ProgramChildViewHolder> {
    private int lastExpandedPosition = -1;
    public static int childItemHeight = 0;



    public ProgramExpandableAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ProgramGroupViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_group_items_layout, parent, false);
        return new ProgramGroupViewHolder(v);
    }

    @Override
    public ProgramChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_child_items_layout, parent, false);

        //childItemHeight = parent.getMeasuredHeight();
        //v.setMinimumHeight(childItemHeight);

        return new ProgramChildViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(ProgramChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final ProgramChildModel product = (ProgramChildModel) group.getItems().get(childIndex);
        holder.bind(product);

    }

    @Override
    public void onBindGroupViewHolder(ProgramGroupViewHolder holder, int flatPosition, ExpandableGroup group) {
        final ProgramGroupModel company = (ProgramGroupModel) group;
        holder.bind(company);




    }

    public class ProgramChildViewHolder extends ChildViewHolder {

        private TextView moveTime;
        private TextView moveTypes;

        public ProgramChildViewHolder(View itemView) {
            super(itemView);
            moveTime = itemView.findViewById(R.id.tv_move_time);
            moveTypes = itemView.findViewById(R.id.tv_move_type);
        }

        public void bind(ProgramChildModel product) {
            moveTypes.setText(product.type);
            moveTime.setText(product.time);
        }
    }

    public class ProgramGroupViewHolder extends GroupViewHolder {

        private TextView day;
        private TextView progress;
        private ImageView arrow;

        public ProgramGroupViewHolder(View itemView) {
            super(itemView);

            day = itemView.findViewById(R.id.tv_day);
            progress = itemView.findViewById(R.id.txtProgress);
            arrow = itemView.findViewById(R.id.iv_arrow);


        }

        public void bind(ProgramGroupModel company) {
            day.setText(company.getTitle());
            progress.setText(company.getProgress());
        }

        @Override
        public void expand() {
            animateExpand();

        }

        @Override
        public void collapse() {
            animateCollapse();
        }

        private void animateExpand() {
            RotateAnimation rotate =
                    new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            arrow.setAnimation(rotate);
        }

        private void animateCollapse() {
            RotateAnimation rotate =
                    new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(300);
            rotate.setFillAfter(true);
            arrow.setAnimation(rotate);
        }
    }

}
