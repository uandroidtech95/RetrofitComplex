package com.example.utsav.retrofitcomplex;

import com.example.utsav.retrofitcomplex.model.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by utsav on 22-06-2017.
 */

public interface UtsavWebservice {
    @GET("/users")
    Call<ArrayList<UserResponse>> getUserData();
}
// new dddd


// new ewehwqkh  ywerge grvh fgher tvrsegjrjw,vejr