package com.ecommerce.vantagetest.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;

import com.ecommerce.vantagetest.R;
import com.ecommerce.vantagetest.adapter.TabAdapter;
import com.google.android.material.tabs.TabLayout;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Method for making the statusBar explicitly colourful
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(R.color.theme_background);
        }

        // Initializing the tab layout -------------------------------------------
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Calories"));
        tabLayout.addTab(tabLayout.newTab().setText("Profile"));
        tabLayout.setSelectedTabIndicatorColor(R.color.red);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        // ------------------------------------------------------------------------


        // Calling the tab adapter from adapter package ----------------------------------------------------------------
        final TabAdapter adapter = new TabAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        // -------------------------------------------------------------------------------------------------------------


        /*Listener for selected tab operation
        * The view pager will be updated to the current position where the current tab is selected
        * */
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
        // End of listener -----------------------------------------------------------------------
    }
}