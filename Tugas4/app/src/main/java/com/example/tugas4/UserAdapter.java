package com.example.tugas4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
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
        holder.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                intent.putExtra(ProfileActivity.PROFILE_DATA, user);
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.fullname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                intent.putExtra(ProfileActivity.PROFILE_DATA, user);
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.deletepost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    showDeleteConfirmationDialog(holder.itemView.getContext(), adapterPosition);
                }            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView fullname, username, caption;
        ImageView profile, post;
        CardView deletepost;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.user_fullname);
            username = itemView.findViewById(R.id.user_username);
            caption = itemView.findViewById(R.id.usercaption);
            profile = itemView.findViewById(R.id.userprofile);
            post = itemView.findViewById(R.id.userimage);
            deletepost = itemView.findViewById(R.id.deletepost);
        }
    }

    private void showDeleteConfirmationDialog(Context context, int position) {

        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_delete_post);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.custom_dialog_bg));

        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        Button btnDelete = dialog.findViewById(R.id.btn_delete);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users.remove(position);
                notifyItemRemoved(position);
                dialog.dismiss();
                Toast.makeText(context, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }

}
