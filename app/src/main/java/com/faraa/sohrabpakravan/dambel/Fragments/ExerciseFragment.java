package com.faraa.sohrabpakravan.dambel.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faraa.sohrabpakravan.dambel.Adapters.ExerciseAdapter;
import com.faraa.sohrabpakravan.dambel.Models.MoveImageData;
import com.faraa.sohrabpakravan.dambel.R;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ExerciseFragment extends Fragment {

    ArrayList<MoveImageData> data;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

//    private OnFragmentInteractionListener mListener;

    public ExerciseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_moves, container, false);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/IRANYekanRegular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        data = new ArrayList<MoveImageData>();

        data.add(new MoveImageData(R.drawable.workout,R.drawable.workout,R.drawable.workout));
        data.add(new MoveImageData(R.drawable.workout,R.drawable.workout,R.drawable.workout));
        data.add(new MoveImageData(R.drawable.workout,R.drawable.workout,R.drawable.workout));
        data.add(new MoveImageData(R.drawable.workout,R.drawable.workout,R.drawable.workout));
        data.add(new MoveImageData(R.drawable.workout,R.drawable.workout,R.drawable.workout));
        data.add(new MoveImageData(R.drawable.workout,R.drawable.workout,R.drawable.workout));




        mRecyclerView = view.findViewById(R.id.moves_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new ExerciseAdapter(getActivity(),data);
        mRecyclerView.setAdapter(mAdapter);



        return view;
    }

//    // TODO: Rename method, update argument and hook method into UI event
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
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}