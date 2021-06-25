package com.ecommerce.vantagetest.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.vantagetest.R;
import com.ecommerce.vantagetest.adapter.CaloriesAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class CaloriesFragment extends Fragment {

    // Declaring the objects -------------------------------------------------------
    private final ArrayList<Integer> caloriesBurnedID     = new ArrayList<Integer>();
    private final ArrayList<String> timeShiftArray        = new ArrayList<String>();
    private final ArrayList<String> timeArray             = new ArrayList<String>();
    private final ArrayList<String> caloriesBurnedArray   = new ArrayList<String>();

    private RecyclerView        caloriesRecycleView;
    private LinearLayoutManager linearLayoutManager;
    private TextView            todayTextView, caloriesTextView;
    private DateFormat          dateFormat;
    private Date                date;
    private String[]            caloriesCount;
    private int                 tempVal = 0;
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
        return inflater.inflate(R.layout.calories, container, false);
    }



    /**
     * Initialising the declaring objects and view objects
     * @param view
     * @param savedInstanceState
     */
    @SuppressLint("SimpleDateFormat")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        caloriesRecycleView     = view.findViewById(R.id.calories_recycle_view);
        linearLayoutManager     = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false );
        caloriesRecycleView     . setHasFixedSize(true);
        caloriesRecycleView     . setNestedScrollingEnabled(false);
        caloriesRecycleView     . setLayoutManager(linearLayoutManager);
        todayTextView           = view.findViewById(R.id.today);
        caloriesTextView        = view.findViewById(R.id.calories_amount);
        dateFormat              = new SimpleDateFormat("dd/MM/yyyy");
        date                    = new Date();

        todayTextView.setText("today "+"("+dateFormat.format(date)+")");

        caloriesBurnedID.add(1);
        timeShiftArray.add("Morning");
        timeArray.add("9am - noon");
        caloriesBurnedArray.add("200 kcal");

        caloriesBurnedID.add(2);
        timeShiftArray.add("Afternoon");
        timeArray.add("Noon - 4pm");
        caloriesBurnedArray.add("120 kcal");

        caloriesBurnedID.add(3);
        timeShiftArray.add("Evening");
        timeArray.add("4pm - 9pm");
        caloriesBurnedArray.add("222 kcal");

        caloriesBurnedID.add(4);
        timeShiftArray.add("Night");
        timeArray.add("9pm - midnight");
        caloriesBurnedArray.add("192 kcal");

        caloriesBurnedID.add(5);
        timeShiftArray.add("Mid-morning");
        timeArray.add("5am - 8am");
        caloriesBurnedArray.add("152 kcal");



        // Calculating the total value for calories burned and displaying in text view -----------------------------------------
        for (int i = 0; i < caloriesBurnedArray.size() ; i++) {
            tempVal += Integer.parseInt(caloriesBurnedArray.get(i).substring(0, caloriesBurnedArray.get(i).indexOf(" ")));
        }
        caloriesTextView.setText(tempVal+" kcals");
        //

        // Calling the adapter to pass the value objects
        CaloriesAdapter caloriesAdapter = new CaloriesAdapter(caloriesBurnedID, timeShiftArray, timeArray, caloriesBurnedArray);
        caloriesRecycleView.setAdapter(caloriesAdapter);
    }
}
