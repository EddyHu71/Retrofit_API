package com.example.fetchapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    ArrayList<Users> usersArrayList;
    //improve paging and singleton
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =  findViewById(R.id.rvContacts);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getSuperHeroes();
    }

    private void getSuperHeroes() {
        Call<List<Users>> call = RetrofitClient.getInstance().getMyApi().getUsers();

        call.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if (response.isSuccessful()) {
                    List<Users> usersData = response.body();
                    UserAdapter userAdapter = new UserAdapter(usersData);
//                    userAdapter.setData(userData);
                    recyclerView.setAdapter(userAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Log.d("TAG", "Error");
                Toast.makeText(getApplicationContext(), "An error has been occured", Toast.LENGTH_LONG).show();
            }
        });
    }
}