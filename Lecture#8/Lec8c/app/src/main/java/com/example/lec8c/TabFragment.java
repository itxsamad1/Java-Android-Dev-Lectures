package com.example.lec8c;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Fragment class that represents the content of each tab
 */
public class TabFragment extends Fragment {

    // Key for the position argument
    private static final String ARG_POSITION = "position";

    /**
     * Creates a new instance of TabFragment with the given position
     * @param position The position of the tab
     * @return A new instance of TabFragment
     */
    public static TabFragment newInstance(int position) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                           @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
        // Create a TextView to display the tab content
        TextView textView = new TextView(requireContext());
        
        // Get the position from arguments
        Bundle args = getArguments();
        int position = args != null ? args.getInt(ARG_POSITION, 0) : 0;
        
        // Set different background colors and text for each tab
        switch (position) {
            case 0:
                textView.setBackgroundColor(Color.rgb(255, 200, 200)); // Light Red
                textView.setText("Welcome to Tab 1!\nThis is the first tab content.");
                break;
            case 1:
                textView.setBackgroundColor(Color.rgb(200, 255, 200)); // Light Green
                textView.setText("Hello from Tab 2!\nExploring the second tab.");
                break;
            case 2:
                textView.setBackgroundColor(Color.rgb(200, 200, 255)); // Light Blue
                textView.setText("You're in Tab 3!\nThis is the last tab content.");
                break;
        }
        
        // Style the TextView
        textView.setTextSize(24);
        textView.setTextColor(Color.BLACK);
        textView.setPadding(40, 40, 40, 40);
        textView.setGravity(Gravity.CENTER);
        textView.setLineSpacing(10, 1); // Add some line spacing for better readability
        
        return textView;
    }
} 