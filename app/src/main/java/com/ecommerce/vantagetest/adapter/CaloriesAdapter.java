package com.ecommerce.vantagetest.adapter;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.vantagetest.R;
import com.ecommerce.vantagetest.viewholder.CaloriesViewHolder;
import com.ecommerce.vantagetest.viewholder.ProfileViewHolder;

import java.util.ArrayList;

public class CaloriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // Arrays for storing the data which will be coming through constructor
    private ArrayList<Integer> caloriesBurnedID     = new ArrayList<Integer>();
    private ArrayList<String> timeShiftArray        = new ArrayList<String>();
    private ArrayList<String> timeArray             = new ArrayList<String>();
    private ArrayList<String> caloriesBurnedArray   = new ArrayList<String>();
    // --------------------------------------------------------------------

    /**
     * Initializing the constructor
     * @param caloriesBurnedID
     * @param timeShiftArray
     * @param timeArray
     * @param caloriesBurnedArray
     */
    public CaloriesAdapter(ArrayList<Integer> caloriesBurnedID, ArrayList<String> timeShiftArray, ArrayList<String> timeArray, ArrayList<String> caloriesBurnedArray) {
        this.caloriesBurnedID       = caloriesBurnedID;
        this.timeShiftArray         = timeShiftArray;
        this.timeArray              = timeArray;
        this.caloriesBurnedArray    = caloriesBurnedArray;
    }

    /**
     * Inflating the view in this method with the layout
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder recyclerViewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View caloriesView       = layoutInflater.inflate(R.layout.calories_content_view, parent, false);
        recyclerViewHolder      = new CaloriesViewHolder(caloriesView);

        return recyclerViewHolder;
    }

    /**
     * Binding the view holder to call the UI objects
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CaloriesViewHolder caloriesViewHolder = (CaloriesViewHolder) holder;

        if (caloriesBurnedID.get(position)%2==0){
            caloriesViewHolder.getRootView().setCardBackgroundColor(Color.parseColor("#D6E2F2"));
            caloriesViewHolder.getCaloriesTimeShift().setText(timeShiftArray.get(position));
            caloriesViewHolder.getCaloriesTime().setText(timeArray.get(position));
            caloriesViewHolder.getCaloriesBurnedValue().setText(caloriesBurnedArray.get(position));
        }
        else {
            caloriesViewHolder.getCaloriesTimeShift().setText(timeShiftArray.get(position));
            caloriesViewHolder.getCaloriesTime().setText(timeArray.get(position));
            caloriesViewHolder.getCaloriesBurnedValue().setText(caloriesBurnedArray.get(position));
        }
    }

    /**
     * This method will return the number of data objects
     * @return
     */
    @Override
    public int getItemCount() {
        return caloriesBurnedID.size();
    }
}
