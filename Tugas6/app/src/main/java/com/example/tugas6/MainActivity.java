package com.example.tugas6;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private String TAG = "TAG";
    private ProgressBar loadingmore, loadingapp;
    private Button loadmore, tryagain;
    private TextView losttext;
    private LinearLayout lostlayout;
    Handler handler = new Handler(Looper.getMainLooper());
    Handler handler1 = new Handler(Looper.getMainLooper());
    private int loadedUsersCount = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingmore = findViewById(R.id.loadingmore);
        loadingapp = findViewById(R.id.loadingapp);
        loadmore = findViewById(R.id.loadmore);
        tryagain = findViewById(R.id.tryagain);
        losttext = findViewById(R.id.losttext);
        lostlayout = findViewById(R.id.lostlayout);

        apiService = RetrofitClient.getClient().create(ApiService.class);
        recyclerView = findViewById(R.id.rv_users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        lostlayout.setVisibility(View.GONE);

        loadingapp.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        loadmore.setVisibility(View.GONE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 2000);

        loadUsers();

        loadingmore.setVisibility(View.GONE);
        loadmore.setOnClickListener(view -> {
            loadmore.setVisibility(View.GONE);
            loadingmore.setVisibility(View.VISIBLE);
            loadedUsersCount += 6;
            loadUsers();
        });

    }

    private void loadUsers() {
        Call<UserResponse> call = apiService.getUsers(loadedUsersCount);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                recyclerView.setVisibility(View.VISIBLE);
                loadmore.setVisibility(View.VISIBLE);
                loadingapp.setVisibility(View.GONE);
                loadingmore.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    List<User> users = response.body().getData();
                    userAdapter = new UserAdapter(users);
                    recyclerView.setAdapter(userAdapter);
                    userAdapter.notifyDataSetChanged();
                } else {

                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                loadingapp.setVisibility(View.GONE);
                lostlayout.setVisibility(View.VISIBLE);
                loadmore.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
                loadingmore.setVisibility(View.GONE);
                tryagain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lostlayout.setVisibility(View.GONE);
                        loadingapp.setVisibility(View.VISIBLE);
                        loadUsers();
                    }
                });
            }
        });
    }
}