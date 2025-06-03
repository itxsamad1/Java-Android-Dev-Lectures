package com.example.lec5;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * MainActivity class that extends AppCompatActivity to create the main screen of the application
 * This activity displays three buttons (Teacher, Student, Exam) and a ListView to show different lists
 */
public class MainActivity extends AppCompatActivity {

    // Arrays to store the data that will be displayed in the ListView
    String[] Teacher = {"Abid Ali","Asad","Usaid","Asjad","Arif","Azfar"}; // Array of teacher names
    String[] Student = {"Zahid","Sammad","Adeel","Mudassir","Ali","Afnan","Motasim","Hamza","Saifullah","Aadarsh"}; // Array of student names
    String[] Exam = {"OOP","PF","DBMS","DSA","DDA","SE","PP","BE","ITPS","MA"}; // Array of exam subjects

    // Declaring UI elements as private member variables
    private Button btnt; // Button for Teacher list
    private Button btns; // Button for Student list
    private Button btne; // Button for Exam list
    private ListView listView; // ListView to display the data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Enable edge-to-edge display
        setContentView(R.layout.activity_main); // Set the layout for this activity

        // Initialize all UI elements by finding them by their IDs
        init();

        // Create and set default adapter with Teacher array when app starts
        ArrayAdapter<String> defaultAdapter = new ArrayAdapter<String>(
            getApplicationContext(), 
            android.R.layout.simple_list_item_1, // Using Android's built-in simple list item layout
            Teacher
        );
        listView.setAdapter(defaultAdapter);

        // Set click listener for Teacher button
        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and set adapter with Teacher array when button is clicked
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    Teacher
                );
                listView.setAdapter(arrayAdapter);
            }
        });

        // Set click listener for Student button
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and set adapter with Student array when button is clicked
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    Student
                );
                listView.setAdapter(arrayAdapter);
            }
        });

        // Set click listener for Exam button
        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and set adapter with Exam array when button is clicked
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    Exam
                );
                listView.setAdapter(arrayAdapter);
            }
        });
    }

    /**
     * Helper method to initialize all UI elements
     * This method finds all views by their IDs and assigns them to the corresponding member variables
     */
    public void init() {
        btnt = findViewById(R.id.teacher); // Initialize Teacher button
        btns = findViewById(R.id.student); // Initialize Student button
        btne = findViewById(R.id.exam);    // Initialize Exam button
        listView = findViewById(R.id.data); // Initialize ListView
    }
}