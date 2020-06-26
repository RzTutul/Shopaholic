package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.pojo.HotDealsPojo;
import com.example.ecommerceapp.pojo.TopCatagoriesPojo;

import java.util.List;

public class HotDealsAdapter extends RecyclerView.Adapter<HotDealsAdapter.allProductViewHolder> {

    Context context;
    List<HotDealsPojo> hotDealsPojoList;


    public HotDealsAdapter(Context context, List<HotDealsPojo> hotDealsPojos) {
        this.context = context;
        this.hotDealsPojoList = hotDealsPojos;
    }

    @NonNull
    @Override
    public allProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.hot_deals_row,parent,false);
        return new allProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final allProductViewHolder holder, final int position) {


        holder.productName.setText(hotDealsPojoList.get(position).getProductName());
        holder.productCatagoires.setText(hotDealsPojoList.get(position).getProductCatagories());
        holder.productPrice.setText(String.valueOf(hotDealsPojoList.get(position).getProductPrice()));
        holder.offerPercentTV.setText(hotDealsPojoList.get(position).getOfferPercent()+"%");
        holder.productImage.setImageResource(hotDealsPojoList.get(position).getProductImage());

        //For drawLine through textView
        holder.oldPrice.setPaintFlags(holder.oldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotDealsPojoList.size();
    }

    public class allProductViewHolder extends RecyclerView.ViewHolder
    {
        TextView productName,productPrice,oldPrice,productCatagoires,offerPercentTV;
        ImageView productImage;

        public allProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productName =itemView.findViewById(R.id.productName);
            productImage =itemView.findViewById(R.id.productImage);
            productPrice =itemView.findViewById(R.id.PriceTV);
            oldPrice =itemView.findViewById(R.id.oldPriceTV);
            productCatagoires =itemView.findViewById(R.id.catagoriesTV);
            offerPercentTV =itemView.findViewById(R.id.percentTV);


        }
    }
}
