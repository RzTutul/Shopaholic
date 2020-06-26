package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.pojo.ProductDeatilsPojo;
import com.example.ecommerceapp.pojo.ProductPojo;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.allProductViewHolder> {

    Context context;
    List<ProductDeatilsPojo> productPojos;


    public CartAdapter(Context context, List<ProductDeatilsPojo> productPojos) {
        this.context = context;
        this.productPojos = productPojos;
    }

    @NonNull
    @Override
    public allProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cart_row_layout, parent, false);
        return new allProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final allProductViewHolder holder, final int position) {

        final int subTotal = productPojos.get(position).getProductPrice() * (productPojos.get(position).getProdcutQyt());
        final int[] qyt = {productPojos.get(position).getProdcutQyt()};

        holder.productName.setText(productPojos.get(position).getProductName());
        holder.productPriceTV.setText("৳ " + String.valueOf(productPojos.get(position).getProductPrice()));
        holder.productImage.setImageResource(productPojos.get(position).getProductImages());
        holder.productCatgoriesTV.setText(productPojos.get(position).getProductCatagories());
        holder.QytTV.setText(String.valueOf(productPojos.get(position).getProdcutQyt()));
        holder.sizeTV.setText(productPojos.get(position).getProductSize());
        holder.colorTV.setText(productPojos.get(position).getProductColor());
        holder.subtotalTV.setText(String.valueOf(subTotal));
        holder.removeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productPojos.remove(productPojos.get(position));
                notifyDataSetChanged();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(holder.itemView).navigate(R.id.productDetailsFragment);
            }
        });

        holder.qytIncreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                qyt[0]++;

                holder.QytTV.setText(String.valueOf(qyt[0]));

                holder.subtotalTV.setText(String.valueOf(productPojos.get(position).getProductPrice() * qyt[0]));

            }
        });

        holder.qytDescreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (qyt[0]>1)
                {
                    qyt[0]--;
                    holder.QytTV.setText(String.valueOf(qyt[0]));
                    holder.subtotalTV.setText(String.valueOf(productPojos.get(position).getProductPrice() * qyt[0]));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return productPojos.size();
    }

    public class allProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productPriceTV, productCatgoriesTV, QytTV, sizeTV, colorTV, subtotalTV;
        ImageView productImage;
        TextView removeCard;
        TextView qytIncreaseBtn, qytDescreaseBtn;

        public allProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.cproductNameTV);
            productPriceTV = itemView.findViewById(R.id.cproductPriceTV);
            productCatgoriesTV = itemView.findViewById(R.id.cproductCatagoriesTV);
            productImage = itemView.findViewById(R.id.cproductImage);
            QytTV = itemView.findViewById(R.id.cQytTV);
            sizeTV = itemView.findViewById(R.id.csizeTV);
            colorTV = itemView.findViewById(R.id.ccolorTV);
            subtotalTV = itemView.findViewById(R.id.csubTotalTV);
            removeCard = itemView.findViewById(R.id.removeCard);
            qytIncreaseBtn = itemView.findViewById(R.id.increaseQytBtn);
            qytDescreaseBtn = itemView.findViewById(R.id.qytDescBtn);
        }
    }
}
