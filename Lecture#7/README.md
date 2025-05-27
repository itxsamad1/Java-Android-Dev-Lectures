# Lecture #7: Dynamic Fragments

## Overview

This lecture focuses on implementing Dynamic Fragments in Android, building upon the static fragments covered in Lecture 6. We'll create a WhatsApp-like interface where fragments are loaded dynamically based on user interaction.

## Topics Covered

### 1. Dynamic Fragment Fundamentals
- Understanding Fragment Manager
- Fragment Transactions
- Adding vs Replacing Fragments
- Fragment Backstack Management

### 2. Implementation Components
- **FragmentManager**: Manages fragments in an activity
- **FragmentTransaction**: Handles fragment operations
- **FrameLayout**: Container for dynamic fragments
- **Fragment Communication**: Between activity and fragments

### 3. WhatsApp-like Interface Implementation

1. **Setup Layout with Fragment Container**
   ```xml
   <FrameLayout
       android:id="@+id/fragcontainer"
       android:layout_width="match_parent"
       android:layout_height="match_parent"/>
   ```

2. **Create Navigation Buttons**
   ```xml
   <Button
       android:id="@+id/btnchat"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="Chat"/>

   <Button
       android:id="@+id/btnstatus"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="Status"/>

   <Button
       android:id="@+id/btncall"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="Call"/>
   ```

3. **Fragment Classes Implementation**
   ```java
   public class chatFragment extends Fragment {
       @Override
       public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
           return inflater.inflate(R.layout.fragment_chat, container, false);
       }
   }

   // Similar implementation for StatusFragment and CallFragment
   ```

4. **Dynamic Fragment Loading**
   ```java
   public void loadFragment(Fragment fragment, int flag) {
       FragmentManager fm = getSupportFragmentManager();
       FragmentTransaction ft = fm.beginTransaction();
       if (flag == 0)
           ft.add(R.id.fragcontainer, fragment);
       else
           ft.replace(R.id.fragcontainer, fragment);
       ft.commit();
   }
   ```

5. **Button Click Handlers**
   ```java
   Chat.setOnClickListener(view -> {
       loadFragment(new chatFragment(), 1);
   });

   Status.setOnClickListener(view -> {
       loadFragment(new StatusFragment(), 1);
   });

   Call.setOnClickListener(view -> {
       loadFragment(new callFragment(), 1);
   });
   ```

### 4. Best Practices
- Initialize default fragment on activity creation
- Handle fragment lifecycle properly
- Manage fragment backstack when needed
- Use proper fragment transaction flags
- Clean up resources when fragments are destroyed

### 5. Common Pitfalls
1. Fragment transaction after activity saved state
2. Not handling configuration changes
3. Memory leaks in fragments
4. Improper fragment communication
5. Not using fragment manager correctly

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