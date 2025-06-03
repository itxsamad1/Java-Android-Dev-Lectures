package com.example.lec8b;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * MainActivity that hosts the bottom navigation and manages fragment transactions
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created
     * Initializes the bottom navigation and sets up fragment handling
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize bottom navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            // Handle navigation item selection
            Fragment selectedFragment = null;

            // Determine which fragment to load based on the selected item
            if (item.getItemId() == R.id.navigation_home) {
                selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.navigation_dashboard) {
                selectedFragment = new DashboardFragment();
            } else if (item.getItemId() == R.id.navigation_notifications) {
                selectedFragment = new NotificationsFragment();
            }

            // Perform the fragment transaction
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });

        // Set default fragment (Home)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }
    }
}