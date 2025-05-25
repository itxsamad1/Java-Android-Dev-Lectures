package com.example.lec5_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lec5_2.DataAdapter;

public class MainActivity extends AppCompatActivity {

    // Arrays to hold our different types of data
    private final String[] Teacher = {"Abid Ali", "Asad", "Usaid", "Asjad", "Arif", "Azfar"};
    private final String[] Student = {"Zahid", "Sammad", "Adeel", "Mudassir", "Ali", "Afnan", "Motasim", "Hamza", "Saifullah", "Aadarsh"};
    private final String[] Exam = {"OOP", "PF", "DBMS", "DSA", "DDA", "SE", "PP", "BE", "ITPS", "MA"};

    // UI Components
    private Button btnt, btns, btne;
    private RecyclerView recyclerView;
    private com.example.lec5_2.DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        initializeViews();

        // Setup RecyclerView
        setupRecyclerView();

        // Set click listeners for buttons
        setupButtonListeners();
    }

    // Initialize all views
    private void initializeViews() {
        btnt = findViewById(R.id.teacher);
        btns = findViewById(R.id.student);
        btne = findViewById(R.id.exam);
        recyclerView = findViewById(R.id.recyclerView);
    }

    // Setup RecyclerView with initial data
    private void setupRecyclerView() {
        // Set the layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        // Create and set the adapter with initial data (Teacher data)
        adapter = new DataAdapter(Teacher);
        recyclerView.setAdapter(adapter);
    }

    // Setup click listeners for all buttons
    private void setupButtonListeners() {
        // Teacher button click listener
        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.updateData(Teacher);
            }
        });

        // Student button click listener
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.updateData(Student);
            }
        });

        // Exam button click listener
        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.updateData(Exam);
            }
        });
    }
} 