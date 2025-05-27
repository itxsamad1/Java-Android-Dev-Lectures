package com.example.lec8c;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * Adapter class for ViewPager2 that manages the tab fragments
 */
public class ViewPagerAdapter extends FragmentStateAdapter {

    // Number of tabs to display
    private static final int TAB_COUNT = 3;

    /**
     * Constructor for the adapter
     * @param fragmentActivity The activity that hosts the ViewPager
     */
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /**
     * Returns the total number of pages/tabs
     */
    @Override
    public int getItemCount() {
        return TAB_COUNT;
    }

    /**
     * Creates a new Fragment for a given position
     * @param position The position of the tab
     * @return A new instance of TabFragment
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Create a new TabFragment with the position
        return TabFragment.newInstance(position);
    }
} 