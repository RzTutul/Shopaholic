package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.pojo.HotDealsPojo;
import com.example.ecommerceapp.pojo.TrendingPojo;

import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.allProductViewHolder> {

    Context context;
    List<TrendingPojo> trendingPojoList;


    public TrendingAdapter(Context context, List<TrendingPojo> trendingPojos) {
        this.context = context;
        this.trendingPojoList = trendingPojos;
    }

    @NonNull
    @Override
    public allProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.trending_row,parent,false);
        return new allProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final allProductViewHolder holder, final int position) {

        holder.productName.setText(trendingPojoList.get(position).getProductName());
        holder.productCatagoires.setText(trendingPojoList.get(position).getProductCatgoires());
        holder.productPrice.setText(String.valueOf(trendingPojoList.get(position).getProductPrice()));
        holder.productDiscription.setText(trendingPojoList.get(position).getProductDiscription());
        holder.productImage.setImageResource(trendingPojoList.get(position).getProductImages());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        if(trendingPojoList.size()>4)
        {
            return 4;
        }
        else
        {
            return trendingPojoList.size();
        }


    }

    public class allProductViewHolder extends RecyclerView.ViewHolder
    {
        TextView productName,productPrice,productCatagoires,productDiscription;
        ImageView productImage;

        Button cartBtn;
        CheckBox addWishList;

        public allProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productName =itemView.findViewById(R.id.productNameTV);
            productImage =itemView.findViewById(R.id.productImge);
            productPrice =itemView.findViewById(R.id.PriceTV);
            productCatagoires =itemView.findViewById(R.id.productCatagoriesTV);
            productDiscription =itemView.findViewById(R.id.productDescription);


        }
    }
}
