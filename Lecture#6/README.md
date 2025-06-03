# Lecture #6: Static Fragments

## Overview

Fragments are a fundamental building block in Android application architecture, representing reusable portions of your app's user interface and behavior. This lecture focuses on Static Fragments, which are defined directly in the Activity's layout using the `<fragment>` tag.

### Understanding Fragments
A Fragment represents a modular section of an activity with its own lifecycle, input events, and layout. Think of fragments as "sub-activities" that allow you to:
- Build modular UI components
- Reuse UI components across different activities
- Create multi-pane layouts
- Handle different screen sizes efficiently

### Static vs Dynamic Fragments
There are two main ways to implement fragments:

1. **Static Fragments** (Focus of this lecture)
   - Defined directly in activity's layout XML
   - Created and managed automatically by Android
   - Best for permanent UI components
   - Simpler to implement
   - Cannot be removed at runtime

2. **Dynamic Fragments** (Covered in Lecture 7)
   - Added programmatically at runtime
   - More flexible but complex
   - Can be added/removed during runtime
   - Requires FragmentManager

### Fragment Lifecycle
Understanding the fragment lifecycle is crucial for proper implementation:
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

### Key Components

1. **Fragment Class**
   - Extends `Fragment`
   - Contains fragment logic
   - Manages fragment lifecycle
   - Handles user interactions

2. **Fragment Layout**
   - XML layout file
   - Defines fragment's UI
   - Independent of activity layout
   - Can be reused in different activities

3. **Host Activity**
   - Contains fragments
   - Provides fragment container
   - Manages fragment communication
   - Handles configuration changes

### Common Use Cases
1. **Master-Detail Views**
   - List of items in one fragment
   - Details in another fragment
   - Common in tablet layouts

2. **Split-Screen Interfaces**
   - Multiple fragments side by side
   - Different content areas
   - Responsive design

3. **Reusable UI Components**
   - Header/footer fragments
   - Navigation fragments
   - Common UI elements

### Benefits of Static Fragments
1. **Simplicity**
   - Easy to implement
   - Automatically managed
   - Less boilerplate code

2. **Reliability**
   - Predictable lifecycle
   - Stable UI structure
   - Automatic state management

3. **Performance**
   - Optimized by Android
   - Reduced memory overhead
   - Efficient rendering

## Step-by-Step Implementation Guide

### 1. Create New Android Project
1. Open Android Studio
2. Click `File > New > New Project`
3. Select "Empty Views Activity"
4. Configure your project:
   - Name: "Lec6"
   - Package name: com.example.lec6
   - Language: Java
   - Minimum SDK: API 24 (Android 7.0)
5. Click "Finish"

### 2. Add Fragment Dependencies
1. Open `app/build.gradle`
2. Add in dependencies block:
   ```gradle
   implementation 'androidx.fragment:fragment:1.6.2'
   ```
3. Click "Sync Now"

### 3. Create Fragment Layouts
1. Create First Fragment Layout:
   - Right-click on `res/layout` folder
   - Select `New > Layout Resource File`
   - Name: `fragment_first.xml`
   - Root element: LinearLayout
   - Add this content:
     ```xml
     <?xml version="1.0" encoding="utf-8"?>
     <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
         android:layout_width="match_parent"
         android:layout_height="match_parent"
         android:orientation="vertical"
         android:gravity="center"
         android:background="#E8F5E9">

         <TextView
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:text="First Fragment"
             android:textSize="24sp"
             android:textStyle="bold" />

         <Button
             android:id="@+id/btnFirst"
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:text="First Fragment Button"
             android:layout_marginTop="16dp" />

     </LinearLayout>
     ```

2. Create Second Fragment Layout:
   - Create `fragment_second.xml`
   - Add similar content with different background and text

### 4. Create Fragment Classes
1. Create First Fragment:
   - Right-click on your package in `java` folder
   - Select `New > Fragment > Fragment (Blank)`
   - Name: `FirstFragment`
   - Uncheck "Include fragment factory methods"
   - Uncheck "Include interface callbacks"
   - Click Finish
   - Update the code:
     ```java
     public class FirstFragment extends Fragment {
         @Override
         public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
             View view = inflater.inflate(R.layout.fragment_first, container, false);
             
             Button btnFirst = view.findViewById(R.id.btnFirst);
             btnFirst.setOnClickListener(v -> {
                 Toast.makeText(getContext(), "First Fragment Button Clicked", 
                              Toast.LENGTH_SHORT).show();
             });
             
             return view;
         }
     }
     ```

2. Create Second Fragment:
   - Follow same steps for `SecondFragment`
   - Update code similarly

### 5. Update MainActivity Layout
1. Open `activity_main.xml`
2. Replace content with:
   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:orientation="vertical">

       <fragment
           android:id="@+id/fragmentFirst"
           android:name="com.example.lec6.FirstFragment"
           android:layout_width="match_parent"
           android:layout_height="0dp"
           android:layout_weight="1" />

       <fragment
           android:id="@+id/fragmentSecond"
           android:name="com.example.lec6.SecondFragment"
           android:layout_width="match_parent"
           android:layout_height="0dp"
           android:layout_weight="1" />

   </LinearLayout>
   ```

### 6. Update MainActivity
1. Open `MainActivity.java`
2. Update the code:
   ```java
   public class MainActivity extends AppCompatActivity {
       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
       }
   }
   ```

### 7. Run and Test
1. Click the green "Run" button (or press Shift + F10)
2. Select your device/emulator
3. Test the app:
   - Verify both fragments are visible
   - Test buttons in each fragment
   - Check fragment layouts and styling

## Common Issues and Solutions

1. **Fragment Not Showing**
   - Check fragment class name in layout matches exactly
   - Verify fragment layout is properly inflated
   - Check fragment container dimensions

2. **Resource Not Found**
   - Clean and rebuild project
   - Check resource IDs are correct
   - Verify XML syntax

3. **Fragment Lifecycle Issues**
   - Handle configuration changes properly
   - Use proper lifecycle methods
   - Save and restore state when needed

## Best Practices

1. **Fragment Management**
   - Keep fragments independent and reusable
   - Handle lifecycle events properly
   - Use proper fragment communication patterns

2. **Layout Design**
   - Use appropriate layouts for different screen sizes
   - Handle orientation changes
   - Follow Material Design guidelines

3. **Code Organization**
   - Keep fragment code modular
   - Use proper package structure
   - Follow clean code principles

## Additional Resources
- [Android Fragments Guide](https://developer.android.com/guide/fragments)
- [Fragment Lifecycle](https://developer.android.com/guide/fragments/lifecycle)
- [Fragment Communication](https://developer.android.com/guide/fragments/communicate)

## Project Structure
```
app/
├── java/
│   └── com.example.lec6/
│       ├── MainActivity.java
│       ├── FirstFragment.java
│       └── SecondFragment.java
└── res/
    └── layout/
        ├── activity_main.xml
        ├── fragment_first.xml
        └── fragment_second.xml
``` 