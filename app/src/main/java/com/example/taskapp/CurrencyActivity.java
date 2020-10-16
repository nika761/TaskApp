package com.example.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.taskapp.model.Rss;
import com.example.taskapp.utils.Utils;

public class CurrencyActivity extends AppCompatActivity implements CurrencyListener {

    private WebView webView;
    private LottieAnimationView loader;
    private TextView title, copyright;
    private Button tryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        initUI();
        checkNetworkConnection();
    }

    public void checkNetworkConnection() {
        if (Utils.checkNetworkConnection(this)) {
            sendRequest();
        } else {
            noConnection();
        }
    }

    public void sendRequest() {
        showLoader(true);
        CurrencyPresenter currencyPresenter = new CurrencyPresenter(this);
        currencyPresenter.getCurrencyRates();
    }

    public void noConnection() {
        Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG).show();
        tryAgain.setVisibility(View.VISIBLE);
    }

    public void showLoader(boolean visible) {
        if (visible)
            loader.setVisibility(View.VISIBLE);
        else
            loader.setVisibility(View.GONE);
    }

    public void initUI() {
        loader = findViewById(R.id.loader);
        webView = findViewById(R.id.web_view);
        title = findViewById(R.id.currency_title);
        copyright = findViewById(R.id.currency_copyright);
        tryAgain = findViewById(R.id.try_again_btn);
        tryAgain.setOnClickListener(v -> {
            checkNetworkConnection();
        });
    }

    public void updateUI(Rss responseBody) {
        showLoader(false);
        tryAgain.setVisibility(View.GONE);
        title.setText(responseBody.getChannel().getItem().getTitle());
        copyright.setText(responseBody.getChannel().getCopyright());
        webView.loadData("<html><body>" + responseBody.getChannel().getItem().getDescription() + "</body></html>", "text/html", "UTF-8");
    }

    @Override
    public void onRequestSuccess(Rss responseBody) {
        updateUI(responseBody);
    }

    @Override
    public void onRequestError(String message) {
        showLoader(false);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
