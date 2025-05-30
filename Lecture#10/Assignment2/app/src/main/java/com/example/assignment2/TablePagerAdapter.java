package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TablePagerAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 4;

    public TablePagerAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new CourseFragment();
            case 1:
                return new EnrollmentFragment();
            case 2:
                return new StudentFragment();
            case 3:
                return new TeacherFragment();
            default:
                return new CourseFragment();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
} 