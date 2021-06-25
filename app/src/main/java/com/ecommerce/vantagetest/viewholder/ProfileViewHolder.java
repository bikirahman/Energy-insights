package com.ecommerce.vantagetest.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.vantagetest.R;

public class ProfileViewHolder extends RecyclerView.ViewHolder {

    // Declaring view objects
    TextView profileKeyData, profileKeyValue;
    CardView profileRootView;

    /**
     * Constructor to pass the view and initialize the UI objects
     * @param itemView
     */
    public ProfileViewHolder(@NonNull View itemView) {
        super(itemView);
        profileKeyData  = itemView.findViewById(R.id.profile_key);
        profileKeyValue = itemView.findViewById(R.id.profile_value);
        profileRootView = itemView.findViewById(R.id.profile_root_view);
    }

    // Setting the getter objects
    public TextView getProfileKeyData() {
        return profileKeyData;
    }

    public TextView getProfileKeyValue() {
        return profileKeyValue;
    }

    public CardView getProfileRootView() {
        return profileRootView;
    }
    //---------------------------
}
