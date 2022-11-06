package com.example.crypto_currency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerView = null;
    public DataAdapter adapter = null;
    public CryptoFromXML crypto = null;
//    private DataAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setTheme(R.style.Theme_Crypto_Currency);
        setContentView(R.layout.activity_main);
        // setup recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());






        crypto = new CryptoFromXML(this);
        Crypto[] cryptos = crypto.getCryptoCurrencies();


        // make adapter for it
        adapter = new DataAdapter(this, R.layout.row_layout, cryptos);
        recyclerView.setAdapter(adapter);







    }
}