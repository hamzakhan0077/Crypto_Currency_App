package com.example.crypto_currency;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_4);

        Bundle bund = getIntent().getExtras();

        WebView myWebView = findViewById(R.id.webView);
        myWebView.loadUrl(bund.getString("CryptoUrl"));




        }
    }

