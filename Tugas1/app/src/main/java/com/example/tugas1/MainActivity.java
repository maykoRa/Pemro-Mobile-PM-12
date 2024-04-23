package com.example.tugas1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText et1;
    ArrayList<String> list_text;
    ArrayAdapter<String> adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.submit_hobby);
        et1 = findViewById(R.id.input_hobby);
        lv = findViewById(R.id.list_hobby);

        list_text = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_text);
        lv.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input_text = et1.getText().toString().trim();
                if (!input_text.isEmpty()){
                    list_text.add(input_text);
                    adapter.notifyDataSetChanged();
                    et1.setText("");
                }
            }
        });




    }


}