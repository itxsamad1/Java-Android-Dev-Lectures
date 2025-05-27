# Lecture #7: Dynamic Fragments (WhatsApp-like Interface)

## Overview

This lecture demonstrates how to implement Dynamic Fragments in Android, creating a WhatsApp-like interface where fragments are loaded and switched dynamically based on user interaction.

## Step-by-Step Implementation Guide

### 1. Create New Android Project
1. Open Android Studio
2. Click `File > New > New Project`
3. Select "Empty Views Activity"
4. Configure your project:
   - Name: "Lec7"
   - Package name: com.example.lec7
   - Language: Java
   - Minimum SDK: API 24 (Android 7.0)
5. Click "Finish"

### 2. Add Dependencies
1. Open `app/build.gradle`
2. Add in dependencies block:
   ```gradle
   implementation 'com.google.android.material:material:1.11.0'
   implementation 'androidx.fragment:fragment:1.6.2'
   ```
3. Click "Sync Now"

### 3. Create Layout Files
1. Create Main Activity Layout:
   - Right-click `res/layout` > New > Layout Resource File
   - Name: `activity_main.xml`
   - Root element: ConstraintLayout
   - Add this content:
     ```xml
     <?xml version="1.0" encoding="utf-8"?>
     <androidx.constraintlayout.widget.ConstraintLayout
         android:layout_width="match_parent"
         android:layout_height="match_parent">
         
         <LinearLayout
             android:id="@+id/buttonContainer"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:orientation="horizontal"
             app:layout_constraintTop_toTopOf="parent">
             
             <Button
                 android:id="@+id/btnChat"
                 android:layout_width="0dp"
                 android:layout_height="wrap_content"
                 android:layout_weight="1"
                 android:text="Chat" />
             
             <Button
                 android:id="@+id/btnStatus"
                 android:layout_width="0dp"
                 android:layout_height="wrap_content"
                 android:layout_weight="1"
                 android:text="Status" />
             
             <Button
                 android:id="@+id/btnCall"
                 android:layout_width="0dp"
                 android:layout_height="wrap_content"
                 android:layout_weight="1"
                 android:text="Call" />
         </LinearLayout>
         
         <FrameLayout
             android:id="@+id/fragmentContainer"
             android:layout_width="match_parent"
             android:layout_height="0dp"
             app:layout_constraintTop_toBottomOf="@id/buttonContainer"
             app:layout_constraintBottom_toBottomOf="parent" />
             
     </androidx.constraintlayout.widget.ConstraintLayout>
     ```

2. Create Fragment Layouts:
   - Create `fragment_chat.xml`:
     ```xml
     <?xml version="1.0" encoding="utf-8"?>
     <LinearLayout
         android:layout_width="match_parent"
         android:layout_height="match_parent"
         android:orientation="vertical"
         android:gravity="center">
         
         <TextView
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:text="Chat Fragment"
             android:textSize="24sp" />
     </LinearLayout>
     ```
   - Similarly create `fragment_status.xml` and `fragment_call.xml`

### 4. Create Fragment Classes
1. Create Chat Fragment:
   - Right-click on your package > New > Fragment > Fragment (Blank)
   - Name: `ChatFragment`
   - Uncheck both checkboxes
   - Click Finish
   - Update the code:
     ```java
     public class ChatFragment extends Fragment {
         @Override
         public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
             return inflater.inflate(R.layout.fragment_chat, container, false);
         }
     }
     ```

2. Similarly create `StatusFragment` and `CallFragment`

### 5. Update MainActivity
1. Open `MainActivity.java`
2. Add fragment management code:
   ```java
   public class MainActivity extends AppCompatActivity {
       private FragmentManager fragmentManager;
       
       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
           
           fragmentManager = getSupportFragmentManager();
           
           // Load default fragment
           if (savedInstanceState == null) {
               loadFragment(new ChatFragment());
           }
           
           // Set up button click listeners
           findViewById(R.id.btnChat).setOnClickListener(v -> loadFragment(new ChatFragment()));
           findViewById(R.id.btnStatus).setOnClickListener(v -> loadFragment(new StatusFragment()));
           findViewById(R.id.btnCall).setOnClickListener(v -> loadFragment(new CallFragment()));
       }
       
       private void loadFragment(Fragment fragment) {
           FragmentTransaction transaction = fragmentManager.beginTransaction();
           transaction.replace(R.id.fragmentContainer, fragment);
           transaction.addToBackStack(null);
           transaction.commit();
       }
   }
   ```

### 6. Run and Test
1. Click the green "Run" button (or press Shift + F10)
2. Select your device/emulator
3. Test the app:
   - Click each button to switch between fragments
   - Verify that fragments change correctly
   - Test back button behavior

## Common Issues and Solutions

1. **Fragment Not Showing**
   - Check if fragmentContainer ID matches in layout and code
   - Verify fragment layout is properly inflated
   - Ensure transaction is committed

2. **Back Stack Issues**
   - Use `addToBackStack(null)` for proper back navigation
   - Consider implementing custom back stack behavior

3. **Layout Issues**
   - Verify ConstraintLayout constraints are properly set
   - Check fragment container height/width settings
   - Ensure buttons are properly aligned

## Best Practices

1. **Fragment Management**
   - Always use FragmentManager from support library
   - Handle configuration changes properly
   - Consider using Fragment factory pattern

2. **Memory Management**
   - Clean up resources in onDestroyView()
   - Handle fragment lifecycle properly
   - Avoid storing context in fragments

3. **User Experience**
   - Add smooth transitions between fragments
   - Implement proper back stack behavior
   - Save and restore fragment state

## Additional Resources
- [Android Fragments Guide](https://developer.android.com/guide/fragments)
- [Fragment Lifecycle](https://developer.android.com/guide/fragments/lifecycle)
- [Fragment Transactions](https://developer.android.com/guide/fragments/transactions)

## Project Structure
```
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── MainActivity.java
│   │   │   ├── fragments/
│   │   │   │   ├── chatFragment.java
│   │   │   │   ├── StatusFragment.java
│   │   │   │   └── callFragment.java
│   │   └── res/
│   │       ├── layout/
│   │       │   ├── activity_main.xml
│   │       │   ├── fragment_chat.xml
│   │       │   ├── fragment_status.xml
│   │       │   └── fragment_call.xml
│   │       └── values/
│   │           └── strings.xml
└── build.gradle
```

## Resources
- [Android Fragments Guide](https://developer.android.com/guide/fragments)
- [Fragment Transactions & Activity State Loss](https://www.androiddesignpatterns.com/2013/08/fragment-transaction-commit-state-loss.html)
- [Fragment Manager](https://developer.android.com/reference/androidx/fragment/app/FragmentManager) 