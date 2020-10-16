package com.example.taskapp.network;

import com.example.taskapp.model.Rss;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("rss.php")
    Call<Rss> getExchangeRate();

}
