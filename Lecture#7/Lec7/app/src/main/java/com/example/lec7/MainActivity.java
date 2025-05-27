package com.example.lec7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Button Call, Chat, Status;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        loadFragment(new chatFragment(), 0);

        Chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new chatFragment(), 1);
            }
        });
        Status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new StatusFragment(), 1);
            }
        });
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new callFragment(), 1);
            }
        });
    }

    public void init() {
        Chat = findViewById(R.id.btnchat);
        Status = findViewById(R.id.btnstatus);
        Call = findViewById(R.id.btncall);
        frameLayout = findViewById(R.id.fragcontainer);
    }

    public void loadFragment(Fragment fragment, int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag == 0)
            ft.add(R.id.fragcontainer, fragment);
        else
            ft.replace(R.id.fragcontainer, fragment);
        ft.commit();
    }
}