package com.example.tugas6;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    private ImageView avatar_details;
    private TextView name_details;
    private TextView email_details;
    private TextView losttextdetails;
    private ProgressBar loaddetails;
    private LinearLayout detailayouts, lostdetails;
    private Button tryagaindetails;
    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        avatar_details = findViewById(R.id.details_avatar);
        name_details = findViewById(R.id.details_name);
        email_details = findViewById(R.id.details_email);
        loaddetails = findViewById(R.id.loadingdetails);
        detailayouts = findViewById(R.id.lineardetails);
        losttextdetails = findViewById(R.id.losttextdetails);
        lostdetails = findViewById(R.id.lostdetails);
        tryagaindetails = findViewById(R.id.tryagaindetails);

        lostdetails.setVisibility(View.GONE);
        detailayouts.setVisibility(View.GONE);
        loaddetails.setVisibility(View.VISIBLE);

        showUsers();

    }

    private void showUsers() {
        int userId = getIntent().getIntExtra("id", -1);
        ApiService service = RetrofitClient.getClient().create(ApiService.class);
        Call<UserResponse> call = service.getUsers(userId);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                loaddetails.setVisibility(View.GONE);
                detailayouts.setVisibility(View.VISIBLE);

                if (response.isSuccessful()) {
                    UserResponse userResponse = response.body();
                    if (userResponse != null && userResponse.getData() != null) {
                        List<User> userList = userResponse.getData();
                        User user = getUserById(userList, userId);
                        if (user != null) {
                            Picasso.get().load(user.getAvatar()).into(avatar_details);
                            name_details.setText(user.getFirst_name() + " " + user.getLast_name());
                            email_details.setText(user.getEmail());
                        } else {
                            Toast.makeText(DetailsActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(DetailsActivity.this, "Failed to fetch user data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DetailsActivity.this, "Failed to fetch user data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                loaddetails.setVisibility(View.GONE);
                lostdetails.setVisibility(View.VISIBLE);
                detailayouts.setVisibility(View.GONE);
                tryagaindetails.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loaddetails.setVisibility(View.VISIBLE);
                        lostdetails.setVisibility(View.GONE);
                        showUsers();
                    }
                });
            }
        });
    }
    private User getUserById(List<User> userList, int userId) {
        for (User user : userList) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }
}
