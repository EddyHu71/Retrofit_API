package com.example.fetchapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<Users> usersList;
    Context context;
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
        String thumbNail = users.getThumbNail();
        String title = users.getTitle();
        String url = users.getUrl();

//        PicassoClient.downloadImage(context, thumbNail, holder.imageView);
//        Picasso.get(context).load(thumbNail).placeholder(R.drawable.ic_launcher_background).into(holder.imageView);
//        PicassoClient.downloadImage(thumbNail, holder.imageView);
        if (getItemCount() == 0) {
            Toast.makeText(context.getApplicationContext(), "No data", Toast.LENGTH_LONG).show();
        } else {
            Picasso.get().load(thumbNail).into(holder.imageView);
            holder.title.setText(title);
            holder.url.setText(url);
        }
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title;
        TextView url;
//        ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            progressBar = itemView.findViewById(R.id.loadImage);
            imageView = itemView.findViewById(R.id.imgThumbnail);
            title = itemView.findViewById(R.id.textTitle);
            url = itemView.findViewById(R.id.textUrl);
        }
    }
}
