package com.ecommerce.vantagetest.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.ecommerce.vantagetest.fragments.CaloriesFragment;
import com.ecommerce.vantagetest.fragments.ProfileFragment;


@SuppressWarnings("ALL")
public class TabAdapter extends FragmentPagerAdapter {

    private Context context;
    int tabs;

    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    /**
     * Constructor that will be called in the activity to pass this given objects below
     * @param context
     * @param fm
     * @param behavior
     */
    public TabAdapter(Context context, @NonNull FragmentManager fm, int behavior) {
        super(fm);
        this.context = context;
        tabs = behavior;
    }

    /**
     * Returning the different fragment that need to kept in the view pager of the activity
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CaloriesFragment caloriesFragment = new CaloriesFragment();
                return caloriesFragment;
            case 1:
                ProfileFragment profileFragment = new ProfileFragment();
                return profileFragment;
            default:
                return null;
        }
    }

    /**
     * Returning the tabs
     * @return
     */
    @Override
    public int getCount() {
        return tabs;
    }
}
