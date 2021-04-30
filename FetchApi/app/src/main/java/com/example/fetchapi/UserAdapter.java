package com.example.fetchapi;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<Users> usersList;
    public UserAdapter(List<Users> usersList) {
        this.usersList = usersList;
    }
//
//    public void setData(List<Users> usersList) {
//        this.usersList = usersList;
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        return new UserAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.users, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        Users users = usersList.get(position);

        String name = users.getName();
        String email = users.getEmail();

        holder.name.setText(name);
        holder.email.setText(email);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textNama);
            email = itemView.findViewById(R.id.textEmail);
        }
    }
}
