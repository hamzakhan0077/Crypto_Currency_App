package com.example.crypto_currency;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Crypto_Currency);
        setContentView(R.layout.activity_main_3);
        TextView textViewData = findViewById(R.id.textView_data);
        Button buttonWebInfo = findViewById(R.id.button_to_webinfo);

        Bundle bund = getIntent().getExtras();

//        textViewData.setText(bund.getString("CryptoName"));
//        textViewData.append(bund.getString("CryptoValue"));
        textViewData.setText("Coin: "+ bund.getString("CryptoCode"));
        textViewData.append("\nCurrent Price(USD) : " + bund.getString("CryptoValue"));
        textViewData.append("\nMarket Cap: "+bund.getString("CryptoMarketCap"));

        buttonWebInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ThirdActivity.this, FourthActivity.class);
                intent.putExtra("CryptoUrl", bund.getString("CryptoUrl"));
                startActivity(intent);


            }


        });
    }
}