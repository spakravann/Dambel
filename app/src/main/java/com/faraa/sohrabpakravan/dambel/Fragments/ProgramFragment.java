package com.faraa.sohrabpakravan.dambel.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faraa.sohrabpakravan.dambel.Adapters.ProgramListAdapter;
import com.faraa.sohrabpakravan.dambel.Models.ProgramListModel;
import com.faraa.sohrabpakravan.dambel.R;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ProgramFragment extends Fragment {


    //  private OnFragmentInteractionListener mListener;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<ProgramListModel> programModel;


    public ProgramFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_program, container, false);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/IRANYekanRegular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        //

        programModel = new ArrayList<ProgramListModel>();

        programModel.add(new ProgramListModel("سهراب پاکروان", "یوگا", "انلاین", R.drawable.sylv, R.drawable.ic_online_mobile));
        programModel.add(new ProgramListModel("سهراب پاکروان", "یوگا", "حضوری", R.drawable.arnold_schwarzenegger, R.drawable.ic_shape));
        programModel.add(new ProgramListModel("سهراب پاکروان", "یوگا", "انلاین", R.drawable.sylv, R.drawable.ic_online_mobile));
        programModel.add(new ProgramListModel("سهراب پاکروان", "یوگا", "حضوری", R.drawable.arnold_schwarzenegger, R.drawable.ic_shape));
        programModel.add(new ProgramListModel("سهراب پاکروان", "یوگا", "انلاین", R.drawable.sylv, R.drawable.ic_online_mobile));
        programModel.add(new ProgramListModel("سهراب پاکروان", "یوگا", "حضوری", R.drawable.arnold_schwarzenegger, R.drawable.ic_shape));
        programModel.add(new ProgramListModel("سهراب پاکروان", "یوگا", "انلاین", R.drawable.sylv, R.drawable.ic_online_mobile));


        //


        mRecyclerView = view.findViewById(R.id.programm_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ProgramListAdapter(getActivity(), programModel);
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof BlankFragment.OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
