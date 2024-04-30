package com.example.tugas5;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private final ArrayList<User> users;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        User user = users.get(position);

        holder.fullname.setText(user.getFullname());
        holder.username.setText(user.getUsername());
        holder.caption.setText(user.getCaption());
        holder.profile.setImageResource(user.getProfile());
        Integer img = user.getPost();
        Uri img2 = user.getAddpost();
        if (img != null) {
            holder.post.setImageResource(user.getPost());
        } else if (img2 != null) {
            holder.post.setImageURI(user.getAddpost());
        }
        holder.postlinear.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                intent.putExtra(ProfileActivity.PROFILE_DATA, user);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView fullname, username, caption;
        ImageView profile, post;

        LinearLayout postlinear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.user_fullname);
            username = itemView.findViewById(R.id.user_username);
            caption = itemView.findViewById(R.id.usercaption);
            profile = itemView.findViewById(R.id.userprofile);
            post = itemView.findViewById(R.id.userimage);
            postlinear = itemView.findViewById(R.id.postlinear);
        }
    }
}
