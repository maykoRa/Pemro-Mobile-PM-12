package com.example.tugas7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    private TextView registNim, registPass;
    private Button registAcc;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        registNim = findViewById(R.id.registNim);
        registPass = findViewById(R.id.registPass);
        registAcc = findViewById(R.id.registAcc);

        sharedPreferences = getSharedPreferences("theDarkest", Context.MODE_PRIVATE);
        boolean isDarkModeEnabled = sharedPreferences.getBoolean("darkMode", false);
        AppCompatDelegate.setDefaultNightMode(isDarkModeEnabled ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);

        sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        registAcc.setOnClickListener(v -> {
            if (registNim.getText().toString().trim().isEmpty()) {
                registNim.setError("Please fill this field");
                return;
            } if (registPass.getText().toString().trim().isEmpty()) {
                registPass.setError("Please fill this field");
                return;
            } else {
                editor.putString("NIM", registNim.getText().toString());
                editor.putString("pass", registPass.getText().toString());
                editor.apply();
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(this, "Berhasil membuat akun", Toast.LENGTH_SHORT).show();

            }
        });

    }
}