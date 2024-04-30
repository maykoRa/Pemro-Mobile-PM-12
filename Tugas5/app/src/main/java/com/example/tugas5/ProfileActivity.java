package com.example.tugas5;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    private ImageView profile;
    private TextView fullname, username;
    User userprofile;
    ProgressBar spinner;
    LinearLayout profilelayout;
    Handler handler = new Handler(Looper.getMainLooper());

    public static final String PROFILE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        profile = findViewById(R.id.myprofile);
        fullname = findViewById(R.id.myname);
        username = findViewById(R.id.myusername);
        spinner = findViewById(R.id.spinner);
        profilelayout = findViewById(R.id.profilelayout);

        userprofile = getIntent().getParcelableExtra(PROFILE_DATA);
        profilelayout.setVisibility(View.GONE);
        spinner.setVisibility(View.VISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                spinner.setVisibility(View.GONE);
                profilelayout.setVisibility(View.VISIBLE);

                profile.setImageResource(userprofile.getProfile());
                fullname.setText(userprofile.getFullname());
                username.setText(userprofile.getUsername());
            }
        }, 2000);

    }
}