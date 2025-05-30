package com.example.connectivityofbackend;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * MainActivity handles the main screen of the application
 * It fetches teacher data from the backend API and displays it in a RecyclerView
 */
public class MainActivity extends AppCompatActivity {

    // UI Components
    private RecyclerView teacher_recycler_view;
    
    // Data holders
    private List<Teacher> teacherList;
    private TeacherAdapter teacherAdapter;
    
    // Backend API URL
    private final String url = "https://automatic-halibut-4jwg9jrw9gqr2j776-5060.app.github.dev/teacher";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView and its components
        teacher_recycler_view = findViewById(R.id.teacherRecyclerview);
        teacher_recycler_view.setLayoutManager(new LinearLayoutManager(this));
        
        // Initialize data structures
        teacherList = new ArrayList<>();
        teacherAdapter = new TeacherAdapter(teacherList, this);
        teacher_recycler_view.setAdapter(teacherAdapter);

        // Load data from API
        loadTeacherfromApi();
    }

    /**
     * Fetches teacher data from the backend API using Volley
     * Parses the JSON response and updates the RecyclerView
     */
    public void loadTeacherfromApi() {
        // Create a new request queue
        RequestQueue queue = Volley.newRequestQueue(this);

        // Create a GET request to fetch teacher data
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    try {
                        Log.d("API", "Response received");
                        // Parse JSON array from response
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            // Create Teacher object from JSON data
                            Teacher teacher = new Teacher(
                                    object.getInt("tid"),
                                    object.getString("tname")
                            );
                            teacherList.add(teacher);
                        }
                        // Notify adapter of data changes
                        teacherAdapter.notifyDataSetChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, error -> {
                    // Handle any errors that occur during the request
                    error.printStackTrace();
                }
        );
        // Add request to queue
        queue.add(stringRequest);
    }
}