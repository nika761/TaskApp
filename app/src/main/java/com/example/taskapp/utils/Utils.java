package com.example.taskapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class Utils {
    public static boolean checkNetworkConnection(Context context) {
        boolean wifiConnected = false;
        boolean mobileDataConnected = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = (connectivityManager).getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                wifiConnected = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
                mobileDataConnected = networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            }
            return wifiConnected || mobileDataConnected;
        }
        return false;
    }

}
