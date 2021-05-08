package com.example.fetchapi;

import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("title")
    private String title;


    @SerializedName("thumbnailUrl")
    private String thumbNail;

    @SerializedName("url")
    private String url;

    public Users(String title, String thumbNail, String url) {
        this.title = title;
        this.thumbNail = thumbNail;
        this.url = url;
    }
    public String getTitle() {
        return title;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    public String getUrl() {
        return url;
    }
}
