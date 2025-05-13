package com.example.lec3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText FirstName,LastNam,Address,Phone;
    private Button Submit;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        FirstName = findViewById(R.id.first_name);
        LastNam = findViewById(R.id.last_name);
        Address = findViewById(R.id.address);
        Phone = findViewById(R.id.phone);
        Submit = findViewById(R.id.btn);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lname,fname,address,phone;
                fname = FirstName.getText().toString();
                lname = LastNam.getText().toString();
                address = Address.getText().toString();
                phone = Phone.getText().toString();

                String data = "First Name : "+fname+", \nLast Name : "+lname+", \n Address :  "+address+", \nPhone Number : "+phone+";";

                Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();

                FirstName.setText("");
                LastNam.setText("");
                Address.setText("");
                Phone.setText("");
            }
        });
    }
}