package com.example.fetchapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView superList;
    ArrayAdapter<String> myAdapter;
    List<String> myHeroes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        superList = (ListView) findViewById(R.id.superListView);
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myHeroes);
        superList.setAdapter(myAdapter);
        getSuperHeroes();
    }

    private void getSuperHeroes() {
        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getSuperHeroes();

        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                List<Results> myheroList = response.body();
//                String[] oneHeroes = new String[myheroList.size()];
                Log.d("TAG", "Success");
//                Log.d("TAG", myheroList.toString());
                Toast.makeText(getApplicationContext(), "Successfully fetched", Toast.LENGTH_LONG).show();
                for (int i =0;i<myheroList.size();i++) {
//                    oneHeroes[i] = myheroList.get(i).getName();
//                    Log.d("TAG", oneHeroes[i]);
                        myHeroes.add(myheroList.get(i).getName());

                }
                myAdapter.notifyDataSetChanged();
//                superList.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Log.d("TAG", "Error");
                Toast.makeText(getApplicationContext(), "An error has been occured", Toast.LENGTH_LONG).show();
            }
        });
    }
}