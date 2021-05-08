package com.example.fetchapi;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PicassoClient {

    public static void downloadImage(String thumbNail, ImageView imageView){

        if (thumbNail != null && thumbNail.length() == 0) {
            Picasso.get().load(thumbNail).into(imageView);
        } else {
            Picasso.get().load(R.drawable.ic_launcher_background).into(imageView);
        }
    }
}
