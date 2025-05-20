# Lecture #3: Android UI Components and Event Handling

## Overview
This lecture explores the interactive elements of Android applications through UI components and event handling mechanisms. Android's UI framework is component-based, with each element serving specific functions within the application interface. Understanding how to capture and respond to user interactions is fundamental to creating responsive and intuitive applications.

UI components are the building blocks through which users interact with your application. Event handling provides the framework for responding to these interactions in meaningful ways. Together, they create the interactive experience that defines modern mobile applications.

## Topics Covered

### UI Components
- **TextView**: Display text to users
  - Customizing appearance (size, color, style)
  - HTML formatting and compound drawables
  
- **EditText**: Collect user input
  - Input types (text, number, email, password)
  - Input filters and validation
  - Hint text and error messages
  
- **Button**: Trigger actions within the app
  - Click and long-click handling
  - Styling and state management
  - Disabled/Enabled states
  
- **CheckBox and RadioButton**: Selection components
  - State changes and handling selections
  - Grouping related options
  
- **ImageView**: Display images and icons
  - Resource management
  - Scaling and transformation options

### Event Handling
- **OnClickListener**: Respond to touch events
- **TextWatcher**: Track changes in text fields
- **FocusChangeListener**: Detect when components gain/lose focus
- **Event propagation**: How events travel through the view hierarchy
- **Custom event listeners**: Creating specialized interaction models

## Sample Application: User Registration Form
The application demonstrates a simple registration form with the following features:
- Input fields for first name, last name, address, and phone number
- Submit button that collects and processes form data
- Toast notification displaying the submitted information
- Form clearing after submission
- Basic UI styling with colors and spacing

## Key Code Concepts

### View Binding and Component Initialization
```java
FirstName = findViewById(R.id.first_name);
LastNam = findViewById(R.id.last_name);
Address = findViewById(R.id.address);
Phone = findViewById(R.id.phone);
Submit = findViewById(R.id.btn);
```

### Event Handling with OnClickListener
```java
Submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String lname, fname, address, phone;
        fname = FirstName.getText().toString();
        lname = LastNam.getText().toString();
        address = Address.getText().toString();
        phone = Phone.getText().toString();

        String data = "First Name : "+fname+", \nLast Name : "+lname+", \n Address :  "+address+", \nPhone Number : "+phone+";";

        Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();

        // Clear form fields after submission
        FirstName.setText("");
        LastNam.setText("");
        Address.setText("");
        Phone.setText("");
    }
});
```

### XML Layout Structure
The layout uses LinearLayout with vertical orientation to organize input fields and button:
```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="20px"
    android:orientation="vertical">
    
    <!-- UI components -->
    
</LinearLayout>
```

### Using Toast for User Feedback
Toast messages provide a simple way to display information to users without interrupting their workflow:

```java
// Simple toast
Toast.makeText(context, "Message", Toast.LENGTH_SHORT).show();

// Custom positioning
Toast toast = Toast.makeText(context, "Custom Position", Toast.LENGTH_LONG);
toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
toast.show();
```

### Input Validation Example
```java
private boolean validateInput() {
    boolean isValid = true;
    
    if (FirstName.getText().toString().isEmpty()) {
        FirstName.setError("First name is required");
        isValid = false;
    }
    
    if (Phone.getText().toString().isEmpty()) {
        Phone.setError("Phone number is required");
        isValid = false;
    } else if (!Patterns.PHONE.matcher(Phone.getText().toString()).matches()) {
        Phone.setError("Please enter a valid phone number");
        isValid = false;
    }
    
    return isValid;
}
```

## Implementation Notes
- The app follows a simple single-activity architecture
- Form data is collected but not persistently stored
- Input validation is minimal in this implementation
- UI is styled with basic colors and text formatting

## Advanced Concepts

### TextWatcher for Real-time Input Validation
```java
phoneField.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        // Validate phone number format as user types
        if (s.length() > 0 && !isValidPhoneNumber(s.toString())) {
            phoneField.setError("Invalid phone format");
        }
    }
});
```

### Context Menus and Long-press Behavior
```java
@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    menu.setHeaderTitle("Options");
    menu.add(0, v.getId(), 0, "Copy");
    menu.add(0, v.getId(), 0, "Clear");
}

@Override
public boolean onContextItemSelected(MenuItem item) {
    if (item.getTitle() == "Copy") {
        // Copy text to clipboard
    } else if (item.getTitle() == "Clear") {
        // Clear the field
    }
    return true;
}
```

## Key Takeaways
- Understanding the relationship between XML layouts and Java code
- Implementation of event listeners for user interaction
- Proper gathering and processing of user input
- Providing feedback to users with Toast messages
- Basic form handling techniques
- Responsive design for different user interactions

## Running the Application
1. Open the project in Android Studio
2. Run the application on an emulator or physical device
3. Enter information in the form fields
4. Click the Submit button to see the toast message with collected data

## Resources
- [Android UI Components](https://developer.android.com/guide/topics/ui)
- [Input Events Documentation](https://developer.android.com/guide/topics/ui/ui-events)
- [EditText Documentation](https://developer.android.com/reference/android/widget/EditText)
- [Toast Documentation](https://developer.android.com/guide/topics/ui/notifiers/toasts) 