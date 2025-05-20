# Lecture #4: Intents and Splash Screens

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