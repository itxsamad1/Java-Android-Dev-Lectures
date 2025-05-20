package com.example.lec4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button Home, Admission, Signin, Signup;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iHome = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(iHome);
            }
        });
    }

    private void init() {
        Home = findViewById(R.id.homebtn);
        Admission = findViewById(R.id.admissionbtn);
        Signin = findViewById(R.id.Signinbtn);
        Signup = findViewById(R.id.signupbtn);
    }
}