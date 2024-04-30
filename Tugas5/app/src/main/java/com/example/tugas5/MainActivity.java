package com.example.tugas5;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame;
    private BottomNavigationView bottomnav;
    private TextView pagetitle;
    String title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        frame = findViewById(R.id.frame);
        bottomnav = findViewById(R.id.bottomnav);
        pagetitle = findViewById(R.id.pagetitle);

        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int itemId = menuItem.getItemId();

                if (itemId == R.id.home) {
                    loadFragment(new HomeFragment(), false);
                    title = "Home";

                } else if (itemId == R.id.search) {
                    loadFragment(new SearchFragment(), false);
                    title = "Search User";

                }  else if (itemId == R.id.post) {
                    loadFragment(new PostingFragment(), false);
                    title = "Add Post";

                } else {
                    loadFragment(new ProfileFragment(), false);
                    title = "Profile";
                }

                pagetitle.setText(title);
                return true;
            }
        });

        loadFragment(new HomeFragment(), true);
        title = "Home";
        pagetitle.setText(title);

    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.frame, fragment);
        } else {
            fragmentTransaction.replace(R.id.frame, fragment);
        }

        fragmentTransaction.commit();
    }

}