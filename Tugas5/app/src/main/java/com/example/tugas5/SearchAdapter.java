package com.example.tugas5;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    private ArrayList<User> searchs;
    private HashSet<String> uniqueUsernames;

    public SearchAdapter(ArrayList<User> searchs) {
        this.searchs = searchs;
        this.uniqueUsernames = new HashSet<>();
    }

    public void setFilteredUsers(ArrayList<User> filteredUsers) {
        uniqueUsernames.clear();
        ArrayList<User> filteredList = new ArrayList<>();
        for (User user : filteredUsers) {
            if (!uniqueUsernames.contains(user.getUsername())) {
                filteredList.add(user);
                uniqueUsernames.add(user.getUsername());
            }
        }
        this.searchs = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_search, parent, false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        User search = searchs.get(position);

        holder.fullname.setText(search.getFullname());
        holder.username.setText(search.getUsername());
        holder.profile.setImageResource(search.getProfile());
        holder.searchlinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                intent.putExtra(ProfileActivity.PROFILE_DATA, search);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView fullname, username;
        ImageView profile;
        CardView searchlinear;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.user_fullname);
            username = itemView.findViewById(R.id.user_username);
            profile = itemView.findViewById(R.id.userprofile);
            searchlinear = itemView.findViewById(R.id.searchlinear);
        }
    }
}
