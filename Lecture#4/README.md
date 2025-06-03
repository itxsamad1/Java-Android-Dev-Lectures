# Lecture #4: Intents and Splash Screens

## Overview

### Intent Class
An Intent is a messaging object used to request an action from another app component such as activities, services, and broadcast receivers. Intents facilitate communication between components in several ways:

- **Starting Activities**: Launch a new activity or bring an existing one to the foreground
- **Starting Services**: Initiate background operations through services
- **Delivering Broadcasts**: Send system-wide announcements to registered BroadcastReceivers

Intents can be explicit (specify the exact component to start) or implicit (declare a general action, allowing the system to find an appropriate component).

### Splash Screen
A Splash Screen is the initial screen displayed when an application launches. It serves multiple purposes:

- **Branding Opportunity**: Showcases the app's logo, name, and identity
- **User Experience**: Provides visual feedback that the app is loading
- **Loading Time Management**: Masks initialization processes and resource loading
- **First Impression**: Creates a professional first touchpoint with users

Modern Android development offers both traditional Activity-based splash screens and the newer SplashScreen API introduced in Android 12.

## Topics Covered

1. **Intent Class**
   - What are Intents in Android?
   - Using Intents to navigate between activities
   - Types of Intents:
     - Explicit Intents: Directly specify the target component
     - Implicit Intents: Let the system find appropriate component
   - Passing data between activities
   - Intent Extras and Bundles
   - Common Intent actions (ACTION_VIEW, ACTION_SEND, etc.)

2. **Splash Screen**
   - What is a Splash Screen?
   - Purpose and best practices for Splash Screens
   - Implementation approaches:
     - Using a dedicated Activity
     - Using the SplashScreen API (Android 12+)
     - Using Handler with postDelayed()
   - Adding animations to Splash Screens
   - Displaying brand elements and app identity

## Step-by-Step Implementation Guide

### Creating a Splash Screen and Multi-Activity App

1. **Create a New Android Project**
   - Open Android Studio
   - Click on "New Project"
   - Select "Empty Activity" template
   - Set application name (e.g., "Lecture4Demo")
   - Select API level (minimum API 21)
   - Choose Java as the language
   - Click Finish to create the project

2. **Create the Splash Screen Activity**
   - Right-click on the `java/[package_name]` folder
   - Select New > Activity > Empty Activity
   - Name it "SplashActivity"
   - Make sure "Generate Layout File" is checked
   - Click Finish

3. **Design the Splash Screen Layout**
   - Open `activity_splash.xml`
   - Add your app logo or branding elements:
   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       tools:context=".SplashActivity">

       <ImageView
           android:id="@+id/imageView"
           android:layout_width="200dp"
           android:layout_height="200dp"
           android:src="@drawable/app_logo"
           app:layout_constraintBottom_toBottomOf="parent"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toTopOf="parent" />

       <TextView
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="My App"
           android:textSize="24sp"
           android:textStyle="bold"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toBottomOf="@+id/imageView"
           android:layout_marginTop="16dp" />

   </androidx.constraintlayout.widget.ConstraintLayout>
   ```

4. **Implement the Splash Screen Logic**
   - Open `SplashActivity.java`
   - Add the timer to delay and then launch the main activity:
   ```java
   package com.example.lecture4demo;

   import androidx.appcompat.app.AppCompatActivity;
   import android.content.Intent;
   import android.os.Bundle;
   import android.os.Handler;

   public class SplashActivity extends AppCompatActivity {

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_splash);
           
           // Set delay time for splash screen (3 seconds)
           new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   // Create Intent to launch MainActivity
                   Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                   startActivity(intent);
                   
                   // Close this activity
                   finish();
               }
           }, 3000); // 3000 milliseconds = 3 seconds
       }
   }
   ```

5. **Create a Home Activity (Optional)**
   - Right-click on the `java/[package_name]` folder
   - Select New > Activity > Empty Activity
   - Name it "HomeActivity"
   - Click Finish

6. **Design the Home Activity Layout**
   - Open `activity_home.xml`
   - Add UI elements including a button to navigate to another screen:
   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:orientation="vertical"
       android:gravity="center"
       android:padding="16dp"
       tools:context=".HomeActivity">

       <TextView
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="Welcome to Home Screen"
           android:textSize="24sp"
           android:textStyle="bold"
           android:layout_marginBottom="32dp" />

       <Button
           android:id="@+id/btnGoToMain"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="Go to Main Activity" />

   </LinearLayout>
   ```

7. **Implement Intent in Home Activity**
   - Open `HomeActivity.java`
   - Implement the button click event to navigate to MainActivity:
   ```java
   package com.example.lecture4demo;

   import androidx.appcompat.app.AppCompatActivity;
   import android.content.Intent;
   import android.os.Bundle;
   import android.view.View;
   import android.widget.Button;

   public class HomeActivity extends AppCompatActivity {

       private Button btnGoToMain;

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_home);
           
           btnGoToMain = findViewById(R.id.btnGoToMain);
           
           btnGoToMain.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   // Create explicit intent to navigate to MainActivity
                   Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                   
                   // Add data to pass to the next activity
                   intent.putExtra("message", "Hello from Home Activity!");
                   
                   // Start the activity
                   startActivity(intent);
               }
           });
       }
   }
   ```

8. **Modify Main Activity to Receive Intent Data**
   - Open `MainActivity.java`
   - Add code to retrieve data passed from HomeActivity:
   ```java
   package com.example.lecture4demo;

   import androidx.appcompat.app.AppCompatActivity;
   import android.os.Bundle;
   import android.widget.TextView;

   public class MainActivity extends AppCompatActivity {

       private TextView tvMessage;

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
           
           tvMessage = findViewById(R.id.tvMessage);
           
           // Check if there's any data passed via Intent
           if (getIntent().hasExtra("message")) {
               String message = getIntent().getStringExtra("message");
               tvMessage.setText(message);
           }
       }
   }
   ```

9. **Update Main Activity Layout**
   - Open `activity_main.xml`
   - Add TextView to display received message:
   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       tools:context=".MainActivity">

       <TextView
           android:id="@+id/tvMessage"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="No message received"
           android:textSize="18sp"
           app:layout_constraintBottom_toBottomOf="parent"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toTopOf="parent" />

   </androidx.constraintlayout.widget.ConstraintLayout>
   ```

10. **Update AndroidManifest.xml**
    - Open `AndroidManifest.xml`
    - Set SplashActivity as the launcher activity:
    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="com.example.lecture4demo">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/Theme.Lecture4Demo">
            
            <!-- Splash Activity as launcher -->
            <activity
                android:name=".SplashActivity"
                android:exported="true">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />
                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
            
            <activity
                android:name=".HomeActivity"
                android:exported="false" />
                
            <activity
                android:name=".MainActivity"
                android:exported="false" />
        </application>

    </manifest>
    ```

11. **Run the Application**
    - Click the "Run" button or press Shift+F10
    - The app will start with the Splash Screen
    - After 3 seconds, it will navigate to MainActivity
    - You can test button navigation from the Home Activity to Main Activity

## Sample Code
The `Lec4` directory contains a complete Android Studio project demonstrating these concepts:

1. `MainActivity.java` - Entry point to the application
2. `SplashActivity.java` - Implementation of a Splash Screen
3. `SecondActivity.java` - Destination activity for Intent demonstration
4. Various layout files for the UI components

## Key Concepts

### Intent Usage Example
```java
// Explicit Intent example
Intent intent = new Intent(MainActivity.this, SecondActivity.class);
intent.putExtra("KEY_NAME", "value");  // Pass data
startActivity(intent);

// Implicit Intent example
Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com"));
startActivity(browserIntent);
```

### Splash Screen Implementation
```java
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // 3 seconds delay
    }
}
```

## Resources
- [Android Intents Documentation](https://developer.android.com/guide/components/intents-filters)
- [Splash Screen API Guide](https://developer.android.com/develop/ui/views/launch/splash-screen)
- Lecture slides and notes in the PDF directory

## Assignment #01: Multi-Activity Android Application

The `Assignment1` directory contains a complete Android application that demonstrates core mobile development concepts including multi-screen navigation, user authentication, data handling, and interactive features.

### Features

1. **Splash Screen**
   - Branded launch screen with automatic transition after 5 seconds
   - Demonstrates use of Handler and Intent for delayed navigation

2. **Main Activity**
   - Central navigation hub with options for:
     - Home (with Game)
     - Admission Form
     - Sign In
     - Sign Up
   - Implements Intent-based navigation between activities

3. **Home Activity**
   - Contains a Tic-Tac-Toe game implementation
   - Demonstrates state management and user interaction

4. **Sign In/Sign Up**
   - User authentication with validation
   - Data storage using SharedPreferences
   - Form validation and error handling

5. **Admission Form**
   - Data collection from user
   - Input validation
   - Feedback using Toast messages

### Implementation Details
The assignment demonstrates practical application of:
- Activity lifecycle management
- Intent-based navigation
- Data passing between activities
- UI design with various layouts and components
- Form handling and validation
- SharedPreferences for simple data persistence

### Source Code Reference
The complete source code is also available at: [MAD-Assignment1-App-Java](https://github.com/itxsamad1/MAD-Assignment1-App-Java.git) 