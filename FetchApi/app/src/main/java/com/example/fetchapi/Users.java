package com.example.fetchapi;

import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("name")
    private String name;


    @SerializedName("email")
    private String email;

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
