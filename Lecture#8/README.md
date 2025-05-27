# Lecture #8: Android Navigation Components

## Overview

This lecture covers various navigation components in Android, focusing on four main types of navigation menus: Bottom Navigation, Top TabLayout, Bottom TabLayout, and Navigation Drawer. These components are essential for creating intuitive and user-friendly navigation in Android applications.

## Topics Covered

### 1. Bottom Navigation Menu
A material design bottom navigation bar that makes it easy to explore and switch between top-level views in a single tap.

#### Implementation Steps:

1. **Add Dependencies**
   ```gradle
   implementation 'com.google.android.material:material:1.11.0'
   implementation 'androidx.navigation:navigation-fragment:2.7.7'
   implementation 'androidx.navigation:navigation-ui:2.7.7'
   ```

2. **Create Menu Resource**
   ```xml
   <!-- bottom_nav_menu.xml -->
   <menu xmlns:android="http://schemas.android.com/apk/res/android">
       <item
           android:id="@+id/navigation_home"
           android:icon="@drawable/ic_home"
           android:title="Home"/>
       <item
           android:id="@+id/navigation_dashboard"
           android:icon="@drawable/ic_dashboard"
           android:title="Dashboard"/>
       <item
           android:id="@+id/navigation_notifications"
           android:icon="@drawable/ic_notifications"
           android:title="Notifications"/>
   </menu>
   ```

3. **Add BottomNavigationView to Layout**
   ```xml
   <com.google.android.material.bottomnavigation.BottomNavigationView
       android:id="@+id/bottom_navigation"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       app:menu="@menu/bottom_nav_menu"/>
   ```

4. **Handle Navigation in Activity**
   ```java
   bottomNav.setOnItemSelectedListener(item -> {
       Fragment selectedFragment = null;
       
       if (item.getItemId() == R.id.navigation_home) {
           selectedFragment = new HomeFragment();
       } else if (item.getItemId() == R.id.navigation_dashboard) {
           selectedFragment = new DashboardFragment();
       } else if (item.getItemId() == R.id.navigation_notifications) {
           selectedFragment = new NotificationsFragment();
       }
       
       if (selectedFragment != null) {
           getSupportFragmentManager().beginTransaction()
               .replace(R.id.fragment_container, selectedFragment)
               .commit();
       }
       return true;
   });
   ```

### 2. Top TabLayout
Provides a horizontal layout to display tabs, typically used with ViewPager2 for swipeable content.

#### Implementation Steps:

1. **Add TabLayout to Layout**
   ```xml
   <com.google.android.material.tabs.TabLayout
       android:id="@+id/tabLayout"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"/>

   <androidx.viewpager2.widget.ViewPager2
       android:id="@+id/viewPager"
       android:layout_width="match_parent"
       android:layout_height="0dp"
       android:layout_weight="1"/>
   ```

2. **Create ViewPager Adapter**
   ```java
   public class ViewPagerAdapter extends FragmentStateAdapter {
       @Override
       public Fragment createFragment(int position) {
           return TabFragment.newInstance(position);
       }

       @Override
       public int getItemCount() {
           return TAB_COUNT;
       }
   }
   ```

3. **Connect TabLayout with ViewPager2**
   ```java
   new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
       tab.setText("Tab " + (position + 1));
   }).attach();
   ```

### 3. Bottom TabLayout
Similar to Top TabLayout but positioned at the bottom of the screen.

#### Implementation:
- Similar to Top TabLayout but with different layout positioning
- Often combined with ViewPager2 for swipeable content
- Can be customized with different tab styles and indicators

### 4. Navigation Drawer
A panel that slides in from the edge of the screen, containing navigation options.

#### Implementation Steps:

1. **Create Drawer Layout**
   ```xml
   <androidx.drawerlayout.widget.DrawerLayout
       android:id="@+id/drawer_layout"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       
       <!-- Main Content -->
       <FrameLayout
           android:id="@+id/content_frame"
           android:layout_width="match_parent"
           android:layout_height="match_parent"/>
       
       <!-- Navigation Drawer -->
       <com.google.android.material.navigation.NavigationView
           android:id="@+id/nav_view"
           android:layout_width="wrap_content"
           android:layout_height="match_parent"
           android:layout_gravity="start"
           app:menu="@menu/drawer_menu"/>
           
   </androidx.drawerlayout.widget.DrawerLayout>
   ```

2. **Create Drawer Menu**
   ```xml
   <menu xmlns:android="http://schemas.android.com/apk/res/android">
       <item
           android:id="@+id/nav_home"
           android:icon="@drawable/ic_home"
           android:title="Home"/>
       <item
           android:id="@+id/nav_gallery"
           android:icon="@drawable/ic_gallery"
           android:title="Gallery"/>
       <item
           android:id="@+id/nav_settings"
           android:icon="@drawable/ic_settings"
           android:title="Settings"/>
   </menu>
   ```

3. **Setup Navigation Drawer**
   ```java
   ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
       this, drawerLayout, toolbar,
       R.string.drawer_open,
       R.string.drawer_close);
   drawerLayout.addDrawerListener(toggle);
   toggle.syncState();
   
   navigationView.setNavigationItemSelectedListener(item -> {
       // Handle navigation view item clicks here
       int id = item.getItemId();
       
       if (id == R.id.nav_home) {
           // Handle home action
       } else if (id == R.id.nav_gallery) {
           // Handle gallery action
       }
       
       drawerLayout.closeDrawer(GravityCompat.START);
       return true;
   });
   ```

## Best Practices

1. **Navigation Pattern Selection**
   - Use Bottom Navigation for 3-5 top-level destinations
   - Use Navigation Drawer for 5+ destinations
   - Use TabLayout for related, frequently switched content

2. **Visual Feedback**
   - Provide clear visual indicators for selected items
   - Use consistent icons and labels
   - Implement smooth transitions between destinations

3. **Performance**
   - Lazy load fragments when possible
   - Cache fragments appropriately
   - Handle configuration changes properly

4. **Accessibility**
   - Provide content descriptions for navigation items
   - Ensure proper focus order
   - Support keyboard navigation

## Common Pitfalls

1. Improper fragment management leading to memory leaks
2. Not handling configuration changes correctly
3. Overcrowding navigation menus
4. Inconsistent navigation patterns
5. Poor state preservation during navigation

## Resources

- [Material Design Navigation](https://material.io/components/navigation-drawer)
- [Android Navigation Component](https://developer.android.com/guide/navigation)
- [Bottom Navigation](https://material.io/components/bottom-navigation)
- [Navigation Drawer](https://material.io/components/navigation-drawer) 