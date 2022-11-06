package com.example.crypto_currency;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    // ivar for DataAdapter
    private Context context;
    private int rowID;
    private Crypto[] cryptos;
    private static RecyclerViewClickListener listener;

    public DataAdapter(Context context, int rowID, Crypto[] cryptos) {
        this.context = context;
        this.rowID = rowID;
        this.cryptos = cryptos;
//        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the layout and make it a viewholder
        View v = LayoutInflater.from(this.context).inflate(rowID, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        // populate viewholder with model data
        holder.currencyCode.setText(cryptos[position].getCoinCode());
        Integer id = context.getResources().getIdentifier(cryptos[position].getImage(),"drawable",context.getPackageName());
        holder.image.setImageResource(id);
        Log.d("image", id.toString());


    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, SecondActivity.class);
            Crypto crypto = cryptos[holder.getAdapterPosition()];
            intent.putExtra("CryptoName", crypto.getName());
            intent.putExtra("CryptoImage", crypto.getImage());
            context.startActivity(intent);

        }
    });




    }

    @Override
    public int getItemCount() {
        return cryptos.length;
    }
    public interface RecyclerViewClickListener{
//        void onClick(View v, int position);


    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView currencyCode;
        public ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.currencyCode = itemView.findViewById(R.id.textViewCryptoName);
            this.image = itemView.findViewById(R.id.imageView);
//            itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            listener.onClick(view,getAdapterPosition());
//
//        }
    }
}