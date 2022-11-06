package com.example.crypto_currency;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        ImageView coinImage = findViewById(R.id.imageView2);
        TextView textViewCryptoName = findViewById(R.id.textView_img);
        Button buttonCoinInfo = findViewById(R.id.button);

        Bundle bund = getIntent().getExtras();
        textViewCryptoName.setText(bund.getString("CryptoName"));
        Integer id = SecondActivity.this.getResources().getIdentifier(bund.getString("CryptoImage"),"drawable",
                SecondActivity.this.getPackageName());
        coinImage.setImageResource(id);
//        CryptoFromXML crypto = new CryptoFromXML(this);

        buttonCoinInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(SecondActivity.this, ThirdActivity.class);

//                Crypto[] cryptos = crypto.getCryptoCurrencies();
                intent.putExtra("CryptoCode",bund.getString("CryptoCode") );
                intent.putExtra("CryptoValue",bund.getString("CryptoValue") );
                intent.putExtra("CryptoMarketCap",bund.getString("CryptoMarketCap") );
                intent.putExtra("CryptoUrl",bund.getString("CryptoUrl") );
                startActivity(intent);


            }


        });

    }
}
