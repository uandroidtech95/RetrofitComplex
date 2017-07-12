package com.example.utsav.retrofitcomplex;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by utsav on 22-06-2017.
 */

public class RestClient {
    private static final String API_BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static UtsavWebservice getWebservice() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(UtsavWebservice.class);
    }
}
