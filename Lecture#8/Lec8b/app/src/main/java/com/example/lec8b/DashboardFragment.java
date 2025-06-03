package com.example.lec8b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/**
 * DashboardFragment represents the dashboard screen of the application
 * This fragment will be displayed when the dashboard navigation item is selected
 */
public class DashboardFragment extends Fragment {

    /**
     * Required empty public constructor
     */
    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Creates and returns the view hierarchy associated with the fragment
     * @param inflater Used to inflate the fragment layout
     * @param container Parent view that the fragment's UI should be attached to
     * @param savedInstanceState Previous state of the fragment if available
     * @return The View for the fragment's UI
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }
} 