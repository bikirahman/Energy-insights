package com.ecommerce.vantagetest.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.ecommerce.vantagetest.R;

public class CaloriesViewHolder extends RecyclerView.ViewHolder {

    // Declaring view objects
    TextView caloriesTimeShift, caloriesTime, caloriesBurnedValue;
    CardView caloriesRootView;

    /**
     * Constructor to pass the view and initialize the UI objects
     * @param itemView
     */
    public CaloriesViewHolder(@NonNull View itemView) {
        super(itemView);

        caloriesRootView    = itemView.findViewById(R.id.calories_root_view);
        caloriesTimeShift   = itemView.findViewById(R.id.calories_shift);
        caloriesTime        = itemView.findViewById(R.id.calories_time);
        caloriesBurnedValue = itemView.findViewById(R.id.calories_value);
    }

    // Setting the getter objects
    public TextView getCaloriesTimeShift() {
        return caloriesTimeShift;
    }

    public TextView getCaloriesTime() {
        return caloriesTime;
    }

    public TextView getCaloriesBurnedValue() {
        return caloriesBurnedValue;
    }

    public CardView getRootView() {
        return caloriesRootView;
    }
    // -----------------------------
}
