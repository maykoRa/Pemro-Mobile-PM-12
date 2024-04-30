package com.example.tugas6;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    public List<User> userList;
    public UserAdapter(List<User> userList){
        this.userList = userList;
    }

    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_user, parent, false);
        return new UserViewHolder(view);
    }

    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.bind(user);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userId = user.getId();
                Log.d("UserAdapter", "Clicked user ID: " + userId);
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra("id", user.getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView avatarImageView;
        private TextView nameTextView;
        private TextView emailTextView;
        private LinearLayout linearLayout;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.user_avatar);
            nameTextView = itemView.findViewById(R.id.user_name);
            emailTextView = itemView.findViewById(R.id.user_email);
            linearLayout = itemView.findViewById(R.id.user_layout);
        }
        public void bind(User user) {
            Picasso.get().load(user.getAvatar()).into(avatarImageView);
            nameTextView.setText(user.getFirst_name() + " " + user.getLast_name());
            emailTextView.setText(user.getEmail());
        }
    }
}
