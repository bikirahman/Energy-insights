package com.ecommerce.vantagetest.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.vantagetest.R;
import com.ecommerce.vantagetest.viewholder.ProfileViewHolder;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // Arrays for storing the data which will be coming through constructor
    private ArrayList<Integer> profileID            = new ArrayList<Integer>();
    private ArrayList<String> bodySpecsArray        = new ArrayList<String>();
    private ArrayList<String> bodySpecsValueArray   = new ArrayList<String>();
    // --------------------------------------------------------------------

    /**
     * Initializing the constructor
     * @param profileID
     * @param bodySpecsArray
     * @param bodySpecsValueArray
     */
    public ProfileAdapter(ArrayList<Integer> profileID, ArrayList<String> bodySpecsArray, ArrayList<String> bodySpecsValueArray) {
        this.profileID = profileID;
        this.bodySpecsArray = bodySpecsArray;
        this.bodySpecsValueArray = bodySpecsValueArray;
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

        View profileView        = layoutInflater.inflate(R.layout.profile_content_view, parent, false);
        recyclerViewHolder      = new ProfileViewHolder(profileView);
        return recyclerViewHolder;
    }

    /**
     * Binding the view holder to call the UI objects
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProfileViewHolder profileViewHolder = (ProfileViewHolder) holder;

        if (profileID.get(position)%2==0) {
            profileViewHolder.getProfileRootView().setCardBackgroundColor(Color.parseColor("#D6E2F2"));
            profileViewHolder.getProfileKeyData().setText(bodySpecsArray.get(position));
            profileViewHolder.getProfileKeyValue().setText(bodySpecsValueArray.get(position));
        }
        else {
            profileViewHolder.getProfileKeyData().setText(bodySpecsArray.get(position));
            profileViewHolder.getProfileKeyValue().setText(bodySpecsValueArray.get(position));
        }
    }

    /**
     * This method will return the number of data objects
     * @return
     */
    @Override
    public int getItemCount() {
        return profileID.size();
    }
}
