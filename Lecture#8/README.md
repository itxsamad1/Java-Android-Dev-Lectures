# Lecture #8: Navigation Components

## Overview

This lecture covers four different types of navigation components in Android:
1. Bottom Navigation Menu
2. Top TabLayout
3. Bottom TabLayout
4. Navigation Drawer

Each component is implemented in separate projects to demonstrate their unique characteristics and use cases.

## Project Structure
- `Lec8b/` - Bottom Navigation Menu implementation
- `Lec8c/` - Top TabLayout implementation
- `Lec8d/` - Bottom TabLayout implementation
- `Lec8/` - Navigation Drawer implementation

## Step-by-Step Implementation Guides

### Bottom Navigation Menu (Lec8b)

#### 1. Create New Project
1. Open Android Studio
2. Click `File > New > New Project`
3. Select "Empty Views Activity"
4. Configure project:
   - Name: "Lec8b"
   - Package name: com.example.lec8b
   - Language: Java
   - Minimum SDK: API 24

#### 2. Add Dependencies
1. Open `app/build.gradle`
2. Add dependencies:
   ```gradle
   implementation 'com.google.android.material:material:1.11.0'
   implementation 'androidx.navigation:navigation-fragment:2.7.7'
   implementation 'androidx.navigation:navigation-ui:2.7.7'
   ```
3. Click "Sync Now"

#### 3. Create Navigation Graph
1. Right-click `res` > New > Android Resource File
2. Configure:
   - Name: nav_graph
   - Resource type: Navigation
3. Add destinations in `nav_graph.xml`:
   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <navigation xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       android:id="@+id/nav_graph"
       app:startDestination="@id/navigation_home">

       <fragment
           android:id="@+id/navigation_home"
           android:name="com.example.lec8b.ui.home.HomeFragment"
           android:label="Home" />

       <fragment
           android:id="@+id/navigation_dashboard"
           android:name="com.example.lec8b.ui.dashboard.DashboardFragment"
           android:label="Dashboard" />

       <fragment
           android:id="@+id/navigation_notifications"
           android:name="com.example.lec8b.ui.notifications.NotificationsFragment"
           android:label="Notifications" />
   </navigation>
   ```

#### 4. Create Menu Resource
1. Right-click `res` > New > Android Resource File
2. Configure:
   - Name: bottom_nav_menu
   - Resource type: Menu
3. Add items in `bottom_nav_menu.xml`:
   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <menu xmlns:android="http://schemas.android.com/apk/res/android">
       <item
           android:id="@+id/navigation_home"
           android:icon="@drawable/ic_home"
           android:title="Home" />
       <item
           android:id="@+id/navigation_dashboard"
           android:icon="@drawable/ic_dashboard"
           android:title="Dashboard" />
       <item
           android:id="@+id/navigation_notifications"
           android:icon="@drawable/ic_notifications"
           android:title="Notifications" />
   </menu>
   ```

#### 5. Update MainActivity Layout
1. Open `activity_main.xml`:
   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <androidx.constraintlayout.widget.ConstraintLayout
       android:layout_width="match_parent"
       android:layout_height="match_parent">

       <com.google.android.material.bottomnavigation.BottomNavigationView
           android:id="@+id/nav_view"
           android:layout_width="match_parent"
           android:layout_height="wrap_content"
           android:layout_marginStart="0dp"
           android:layout_marginEnd="0dp"
           android:background="?android:attr/windowBackground"
           app:layout_constraintBottom_toBottomOf="parent"
           app:layout_constraintLeft_toLeftOf="parent"
           app:layout_constraintRight_toRightOf="parent"
           app:menu="@menu/bottom_nav_menu" />

       <fragment
           android:id="@+id/nav_host_fragment"
           android:name="androidx.navigation.fragment.NavHostFragment"
           android:layout_width="match_parent"
           android:layout_height="0dp"
           app:defaultNavHost="true"
           app:layout_constraintBottom_toTopOf="@id/nav_view"
           app:layout_constraintLeft_toLeftOf="parent"
           app:layout_constraintRight_toRightOf="parent"
           app:layout_constraintTop_toTopOf="parent"
           app:navGraph="@navigation/nav_graph" />

   </androidx.constraintlayout.widget.ConstraintLayout>
   ```

#### 6. Update MainActivity
```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
    }
}
```

### Top TabLayout (Lec8c)

#### 1. Create New Project
1. Follow same steps as above, name it "Lec8c"

#### 2. Add Dependencies
```gradle
implementation 'com.google.android.material:material:1.11.0'
```

#### 3. Update MainActivity Layout
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <com.google.android.material.tabs.TabLayout
        android:id="@+id/tabLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:tabMode="fixed"
        app:tabGravity="fill" />

    <androidx.viewpager2.widget.ViewPager2
        android:id="@+id/viewPager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>
```

#### 4. Create ViewPagerAdapter
```java
public class ViewPagerAdapter extends FragmentStateAdapter {
    private final List<Fragment> fragments = new ArrayList<>();
    private final List<String> fragmentTitles = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        fragmentTitles.add(title);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    public String getPageTitle(int position) {
        return fragmentTitles.get(position);
    }
}
```

#### 5. Update MainActivity
```java
public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        adapter = new ViewPagerAdapter(this);
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new DashboardFragment(), "Dashboard");
        adapter.addFragment(new NotificationsFragment(), "Notifications");

        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
            (tab, position) -> tab.setText(adapter.getPageTitle(position))
        ).attach();
    }
}
```

### Navigation Drawer (Lec8)

#### 1. Create New Project
1. Use Android Studio's "Navigation Drawer Activity" template
2. Name: "Lec8"

#### 2. Update navigation_drawer.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <group android:checkableBehavior="single">
        <item
            android:id="@+id/nav_home"
            android:icon="@drawable/ic_home"
            android:title="Home" />
        <item
            android:id="@+id/nav_gallery"
            android:icon="@drawable/ic_gallery"
            android:title="Gallery" />
        <item
            android:id="@+id/nav_slideshow"
            android:icon="@drawable/ic_slideshow"
            android:title="Slideshow" />
    </group>
</menu>
```

#### 3. Update MainActivity
```java
public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        
        toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
        
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {
            // Handle navigation view item clicks here
            int id = item.getItemId();
            Fragment fragment = null;

            if (id == R.id.nav_home) {
                fragment = new HomeFragment();
            } else if (id == R.id.nav_gallery) {
                fragment = new GalleryFragment();
            } else if (id == R.id.nav_slideshow) {
                fragment = new SlideshowFragment();
            }

            if (fragment != null) {
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit();
            }

            drawer.closeDrawer(GravityCompat.START);
            return true;
        });
    }
}
```

## Common Issues and Solutions

1. **Navigation Components Not Working**
   - Check dependency versions
   - Verify menu item IDs match navigation graph IDs
   - Ensure NavHostFragment is properly configured

2. **ViewPager2 Issues**
   - Use FragmentStateAdapter instead of FragmentPagerAdapter
   - Handle fragment lifecycle properly
   - Use TabLayoutMediator for connecting TabLayout

3. **Drawer Issues**
   - Verify drawer layout is root view
   - Check ActionBarDrawerToggle setup
   - Handle configuration changes

## Best Practices

1. **Navigation**
   - Use Navigation Component when possible
   - Handle back stack properly
   - Implement proper up/back navigation

2. **Fragment Management**
   - Save fragment state
   - Handle configuration changes
   - Clean up resources

3. **UI/UX**
   - Follow Material Design guidelines
   - Add appropriate animations
   - Handle edge cases and errors

## Additional Resources
- [Navigation Component Guide](https://developer.android.com/guide/navigation)
- [Material Design Navigation](https://material.io/components/navigation-drawer)
- [ViewPager2 Documentation](https://developer.android.com/guide/navigation/navigation-swipe-view-2) 