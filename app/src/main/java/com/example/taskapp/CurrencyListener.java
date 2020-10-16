package com.example.taskapp;

import com.example.taskapp.model.Rss;

public interface CurrencyListener {

    void onRequestSuccess(Rss responseBody);

    void onRequestError(String message);

}
