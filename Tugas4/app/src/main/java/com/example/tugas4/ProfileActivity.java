package com.example.tugas4;

import android.os.Bundle;
import android.widget.ImageView;
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

    public static final String PROFILE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        profile = findViewById(R.id.myprofile);
        fullname = findViewById(R.id.myname);
        username = findViewById(R.id.myusername);

        userprofile = getIntent().getParcelableExtra(PROFILE_DATA);
        profile.setImageResource(userprofile.getProfile());
        fullname.setText(userprofile.getFullname());
        username.setText(userprofile.getUsername());

    }
}