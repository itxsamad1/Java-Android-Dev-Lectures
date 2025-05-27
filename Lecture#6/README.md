# Lecture #6: Static Fragments

## Overview

This lecture introduces Fragments in Android development, with a specific focus on Static Fragments. Fragments represent reusable portions of your app's UI and behavior that can be combined to build a dynamic and multi-pane user interface.

### What are Fragments?
A Fragment represents a reusable portion of your app's UI. You can think of a Fragment as a modular section of an activity – it has its own lifecycle, receives its own input events, and you can add or remove fragments while the activity is running.

### Static vs Dynamic Fragments
- **Static Fragments** are defined in the activity's layout using the `<fragment>` element
- **Dynamic Fragments** are added to an activity at runtime using FragmentManager

## Topics Covered

1. **Fragment Fundamentals**
   - Fragment Lifecycle
   - Fragment Architecture
   - Fragment-Activity Communication
   - Fragment Layout Design

2. **Static Fragment Implementation**
   - XML Layout Definition
   - Fragment Class Creation
   - Fragment-Activity Integration
   - State Management

3. **Fragment Lifecycle**
   ```
   onAttach()
       ↓
   onCreate()
       ↓
   onCreateView()
       ↓
   onViewCreated()
       ↓
   onStart()
       ↓
   onResume()
       ↓
   onPause()
       ↓
   onStop()
       ↓
   onDestroyView()
       ↓
   onDestroy()
       ↓
   onDetach()
   ```

## Implementation Guide

### 1. Create Fragment Layout
```xml
<!-- fragment_example.xml -->
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:id="@+id/fragmentText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="This is a Static Fragment"
        android:textSize="20sp"/>

    <Button
        android:id="@+id/fragmentButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="Fragment Button"/>

</LinearLayout>
```

### 2. Create Fragment Class
```java
public class ExampleFragment extends Fragment {
    private TextView fragmentText;
    private Button fragmentButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_example, container, false);
        
        // Initialize views
        fragmentText = view.findViewById(R.id.fragmentText);
        fragmentButton = view.findViewById(R.id.fragmentButton);
        
        // Set click listener
        fragmentButton.setOnClickListener(v -> {
            // Handle button click
            Toast.makeText(getContext(), "Fragment Button Clicked", 
                Toast.LENGTH_SHORT).show();
        });
        
        return view;
    }
}
```

### 3. Add Fragment to Activity Layout
```xml
<!-- activity_main.xml -->
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <fragment
        android:id="@+id/example_fragment"
        android:name="com.example.app.ExampleFragment"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

</LinearLayout>
```

### 4. Activity Implementation
```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // The fragment is automatically created and managed
        // because it's defined in the layout XML
    }
}
```

## Fragment-Activity Communication

### 1. Define Interface
```java
public class ExampleFragment extends Fragment {
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String data);
    }
    
    private OnFragmentInteractionListener mListener;
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                + " must implement OnFragmentInteractionListener");
        }
    }
}
```

### 2. Implement Interface in Activity
```java
public class MainActivity extends AppCompatActivity 
        implements ExampleFragment.OnFragmentInteractionListener {
    
    @Override
    public void onFragmentInteraction(String data) {
        // Handle the interaction
        Toast.makeText(this, "Fragment sent: " + data, 
            Toast.LENGTH_SHORT).show();
    }
}
```

## Best Practices

1. **Fragment Independence**
   - Design fragments to be as independent as possible
   - Avoid direct references to parent activities
   - Use interfaces for fragment-activity communication

2. **State Management**
   - Save and restore fragment state properly
   - Use `onSaveInstanceState()` for temporary state
   - Consider using ViewModel for persistent state

3. **Lifecycle Awareness**
   - Handle lifecycle events appropriately
   - Clean up resources in `onDestroyView()`
   - Consider using Lifecycle-Aware components

4. **Layout Design**
   - Keep fragment layouts modular
   - Use ConstraintLayout for complex UIs
   - Consider different screen sizes and orientations

## Common Issues and Solutions

1. **Fragment Already Added**
   ```java
   // Check if fragment exists before adding
   Fragment fragment = getSupportFragmentManager()
       .findFragmentById(R.id.fragment_container);
   if (fragment == null) {
       // Add the fragment
   }
   ```

2. **Activity-Fragment Communication**
   ```java
   // In Fragment
   if (getActivity() != null) {
       // Interact with activity
   }
   ```

3. **State Loss Exception**
   ```java
   // Use commitAllowingStateLoss() when appropriate
   fragmentTransaction.commitAllowingStateLoss();
   ```

## Resources
- [Android Fragments Guide](https://developer.android.com/guide/fragments)
- [Fragment Lifecycle](https://developer.android.com/guide/fragments/lifecycle)
- [Fragment API Reference](https://developer.android.com/reference/androidx/fragment/app/Fragment)
- [Fragment Design Patterns](https://developer.android.com/guide/fragments/design) 