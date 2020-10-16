package com.example.taskapp;

import com.example.taskapp.model.Rss;
import com.example.taskapp.network.ApiService;
import com.example.taskapp.network.RetrofitManager;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class CurrencyPresenter {
    private CurrencyListener currencyListener;
    private ApiService apiService;

    CurrencyPresenter(CurrencyListener currencyListener) {
        this.currencyListener = currencyListener;
        this.apiService = RetrofitManager.getApiService();
    }

    void getCurrencyRates() {
        apiService.getExchangeRate().enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(@NotNull Call<Rss> call, @NotNull Response<Rss> response) {
                if (response.isSuccessful() && response.body() != null) {
                    currencyListener.onRequestSuccess(response.body());
                } else {
                    currencyListener.onRequestError(response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<Rss> call, @NotNull Throwable t) {
                currencyListener.onRequestError(t.getMessage());
            }
        });
    }
}
