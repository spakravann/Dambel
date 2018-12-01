package com.faraa.sohrabpakravan.dambel.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.faraa.sohrabpakravan.dambel.Adapters.ProgramExpandableAdapter;
import com.faraa.sohrabpakravan.dambel.Models.ProgramChildModel;
import com.faraa.sohrabpakravan.dambel.Models.ProgramGroupModel;
import com.faraa.sohrabpakravan.dambel.R;
import com.thoughtbot.expandablerecyclerview.listeners.GroupExpandCollapseListener;
import com.thoughtbot.expandablerecyclerview.listeners.OnGroupClickListener;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class DailyProgramActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<ProgramGroupModel> group;
    private ArrayList<ProgramChildModel> child;
    ProgramExpandableAdapter programExpandableAdapter;

    private int lastExpandedPosition = -1;
    private boolean isClicked = false;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/IRANYekanRegular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );



        group = new ArrayList<ProgramGroupModel>();


        child = new ArrayList<ProgramChildModel>();

        child.add(new ProgramChildModel("کششی", "3 دقیقه"));
        child.add(new ProgramChildModel("کششی", "2 دقیقه"));
        child.add(new ProgramChildModel("کششی", "5 دقیقه"));
        child.add(new ProgramChildModel("کششی", "6 دقیقه"));
        child.add(new ProgramChildModel("کششی", "3 دقیقه"));

        ProgramGroupModel company = new ProgramGroupModel("40%","روز اول", child);
        group.add(company);


        child = new ArrayList<ProgramChildModel>();


        child.add(new ProgramChildModel("استقامتی", "3 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "2 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "5 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "6 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "3 دقیقه"));

        ProgramGroupModel company2 = new ProgramGroupModel("90%","روز دوم", child);
        group.add(company2);

        child = new ArrayList<ProgramChildModel>();


        child.add(new ProgramChildModel("استقامتی", "3 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "2 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "5 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "6 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "3 دقیقه"));

        ProgramGroupModel company3 = new ProgramGroupModel("60%","روز سوم", child);
        group.add(company3);

        child = new ArrayList<ProgramChildModel>();


        child.add(new ProgramChildModel("استقامتی", "3 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "2 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "5 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "6 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "3 دقیقه"));

        ProgramGroupModel company4 = new ProgramGroupModel("30%","روز چهارم", child);
        group.add(company4);

        child = new ArrayList<ProgramChildModel>();


        child.add(new ProgramChildModel("استقامتی", "3 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "2 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "5 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "6 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "3 دقیقه"));

        ProgramGroupModel company5 = new ProgramGroupModel("30%","روز پنجم", child);
        group.add(company5);

        child = new ArrayList<ProgramChildModel>();


        child.add(new ProgramChildModel("استقامتی", "3 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "2 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "5 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "6 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "3 دقیقه"));

        ProgramGroupModel company6 = new ProgramGroupModel("30%","روز ششم", child);
        group.add(company6);

        child = new ArrayList<ProgramChildModel>();


        child.add(new ProgramChildModel("استقامتی", "3 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "2 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "5 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "6 دقیقه"));
        child.add(new ProgramChildModel("استقامتی", "3 دقیقه"));

        ProgramGroupModel company7 = new ProgramGroupModel("30%","روز هفتم", child);
        group.add(company7);
        group.add(company7);


        mRecyclerView = findViewById(R.id.programm_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //mRecyclerView.setNestedScrollingEnabled(false);

        final ProgramExpandableAdapter programExpandableAdapter = new ProgramExpandableAdapter(group);

        programExpandableAdapter.setOnGroupClickListener(new OnGroupClickListener() {
            @Override
            public boolean onGroupClick(int flatPos) {

                //programExpandableAdapter.onGroupCollapsed(flatPos,child.size());

//                if (lastExpandedPosition != -1
//                        && flatPos != lastExpandedPosition) {
//
//                    programExpandableAdapter.onGroupCollapsed(lastExpandedPosition,child.size());
//                    //lv.collapseGroup(lastExpandedPosition);
//                }
//                lastExpandedPosition = flatPos;

//                if(!isClicked) {
//                    RelativeLayout.LayoutParams lp =
//                            new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, child.size() * childItemHeight);
//                    mRecyclerView.setLayoutParams(lp);
//
//                    isClicked = true;
//                } else {
//
//                    RelativeLayout.LayoutParams lp =
//                            new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, mRecyclerView.getMeasuredHeight());
//                    mRecyclerView.setLayoutParams(lp);
//
//                    isClicked = false;
//                }
                return false;
            }
        });
        programExpandableAdapter.setOnGroupExpandCollapseListener(new GroupExpandCollapseListener() {
            @Override
            public void onGroupExpanded(ExpandableGroup group) {
                Log.i("Sohrab ", "GROUP : EXPANDED");
                //mRecyclerView.setNestedScrollingEnabled(true);

            }

            @Override
            public void onGroupCollapsed(ExpandableGroup group) {
                Log.i("Sohrab ", "GROUP : Collapsed");
               // mRecyclerView.setNestedScrollingEnabled(false);
//                RelativeLayout.LayoutParams lp =
//                        new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, mRecyclerView.getMeasuredHeight());
//                mRecyclerView.setLayoutParams(lp);

            }
        });


        mAdapter = new ProgramExpandableAdapter(group);
        mRecyclerView.setAdapter(programExpandableAdapter);
    }

    public static boolean setListViewHeightBasedOnItems(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, listView);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getDividerHeight() *
                    (numberOfItems - 1);

            // Set list height.
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight;
            listView.setLayoutParams(params);
            listView.requestLayout();

            return true;

        } else {
            return false;
        }
    }


}
