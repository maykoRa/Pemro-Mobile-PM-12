package com.example.tugas7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView loginNim, loginPass;
    private Button login, register;
    private SharedPreferences sharedPreferences;

    private static final String IS_LOGGED_IN = "isLoggedIn";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        loginNim = findViewById(R.id.loginNim);
        loginPass = findViewById(R.id.loginPass);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        sharedPreferences = getSharedPreferences("theDarkest", Context.MODE_PRIVATE);
        boolean isDarkModeEnabled = sharedPreferences.getBoolean("darkMode", false);
        AppCompatDelegate.setDefaultNightMode(isDarkModeEnabled ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

        sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE);
        String nim = sharedPreferences.getString("NIM", "");
        String password = sharedPreferences.getString("pass", "");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        boolean loggedIn = sharedPreferences.getBoolean(IS_LOGGED_IN, false);

        if (loggedIn) {
            Intent intent = new Intent(this, AppActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }

        login.setOnClickListener(v -> {
            if (loginNim.getText().toString().trim().isEmpty()) {
                loginNim.setError("Please fill this field");
                return;
            } if (loginPass.getText().toString().trim().isEmpty()) {
                loginPass.setError("Please fill this field");
                return;
            }
            String nimInput = loginNim.getText().toString();
            String passInput = loginPass.getText().toString();
            if (nimInput.equals(nim) && passInput.equals(password)) {
                editor.putString("NIM", nimInput);
                editor.putBoolean(IS_LOGGED_IN, true);
                editor.apply();
                Intent intent = new Intent(this, AppActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                Toast.makeText(this, "NIM atau Password salah", Toast.LENGTH_SHORT).show();
            }
        });

        register.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });

    }
}