package com.ecommerce.vantagetest.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.vantagetest.R;
import com.ecommerce.vantagetest.adapter.ProfileAdapter;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    // Declaring the objects -------------------------------------------------------
    private ArrayList<Integer> profileID            = new ArrayList<Integer>();
    private ArrayList<String> bodySpecsArray        = new ArrayList<String>();
    private ArrayList<String> bodySpecsValueArray   = new ArrayList<String>();

    private RecyclerView        profileRecycleView;
    private LinearLayoutManager linearLayoutManager;
    // --------------------------------------------------------------------------------


    /**
     * Inflating the layout for view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile, container, false);
    }


    /**
     * Initialising the declaring objects and view objects
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profileRecycleView      = view.findViewById(R.id.profile_recycle_view);
        linearLayoutManager     = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false );
        profileRecycleView      . setHasFixedSize(true);
        profileRecycleView      . setLayoutManager(linearLayoutManager);

        profileID.add(1);
        bodySpecsArray.add("Height");
        bodySpecsValueArray.add("172 cm");

        profileID.add(2);
        bodySpecsArray.add("Weight");
        bodySpecsValueArray.add("65kg");

        profileID.add(3);
        bodySpecsArray.add("DOB");
        bodySpecsValueArray.add("19/06/1995");

        profileID.add(4);
        bodySpecsArray.add("Gender");
        bodySpecsValueArray.add("Male");

        profileID.add(5);
        bodySpecsArray.add("Oxygen level");
        bodySpecsValueArray.add("97");

        // Calling the adapter to pass the value objects
        ProfileAdapter profileAdapter = new ProfileAdapter(profileID, bodySpecsArray, bodySpecsValueArray);
        profileRecycleView.setAdapter(profileAdapter);
    }
}
