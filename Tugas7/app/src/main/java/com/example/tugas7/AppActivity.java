package com.example.tugas7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AppActivity extends AppCompatActivity {

    private TextView welcome;
    private Button logout, setting;
    private SharedPreferences sharedPreferences;

    private static final String IS_LOGGED_IN = "isLoggedIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app);

        welcome = findViewById(R.id.welcome);
        logout = findViewById(R.id.logout);
        setting = findViewById(R.id.setting);

        sharedPreferences = getSharedPreferences("theDarkest", Context.MODE_PRIVATE);
        boolean isDarkModeEnabled = sharedPreferences.getBoolean("darkMode", false);
        AppCompatDelegate.setDefaultNightMode(isDarkModeEnabled ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

        sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE);
        String nimHello = sharedPreferences.getString("NIM", "");
        welcome.setText("Selamat datang " + nimHello);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        logout.setOnClickListener(v -> {
            editor.putBoolean(IS_LOGGED_IN, false);
            editor.apply();
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        setting.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        });





    }
}