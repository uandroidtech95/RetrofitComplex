package com.example.utsav.retrofitcomplex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.utsav.retrofitcomplex.adapter.UserDataAdapter;
import com.example.utsav.retrofitcomplex.model.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<UserResponse> userResponseArrayList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_getdata);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        RestClient.getWebservice().getUserData().enqueue(new Callback<ArrayList<UserResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<UserResponse>> call, Response<ArrayList<UserResponse>> response) {
                userResponseArrayList = response.body();
                UserDataAdapter userDataAdapter = new UserDataAdapter(userResponseArrayList, MainActivity.this);
                recyclerView.setAdapter(userDataAdapter);

            }

            @Override
            public void onFailure(Call<ArrayList<UserResponse>> call, Throwable t) {


            }
        });
    }
}
