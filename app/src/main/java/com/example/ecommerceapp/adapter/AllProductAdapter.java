package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.pojo.ProductPojo;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class AllProductAdapter extends RecyclerView.Adapter<AllProductAdapter.allProductViewHolder> {

    Context context;
    List<ProductPojo> productPojos;


    public AllProductAdapter(Context context, List<ProductPojo> productPojos) {
        this.context = context;
        this.productPojos = productPojos;
    }

    @NonNull
    @Override
    public allProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_row_layout,parent,false);
        return new allProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final allProductViewHolder holder, int position) {


        holder.productName.setText(productPojos.get(position).getProductName());
        holder.ProductPrice.setText("৳ "+String.valueOf(productPojos.get(position).getProductPrice()));
        holder.productImage.setImageResource(productPojos.get(position).getProductImage());

        holder.addWish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked())
                {
                    Snackbar.make(holder.itemView,"Added Favorite List",Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(holder.itemView).navigate(R.id.productDetailsFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productPojos.size();
    }

    public class allProductViewHolder extends RecyclerView.ViewHolder
    {
        TextView productName,ProductPrice;
        ImageView productImage;
        CheckBox addWish;

        public allProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productName =itemView.findViewById(R.id.productName);
            ProductPrice =itemView.findViewById(R.id.PriceTV);
            productImage =itemView.findViewById(R.id.productImage);
            addWish =itemView.findViewById(R.id.checkboxIcon);
        }
    }
}
