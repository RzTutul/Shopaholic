package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerceapp.R;
import com.example.ecommerceapp.pojo.TopCatagoriesPojo;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class TopCatagoriesAdapter extends RecyclerView.Adapter<TopCatagoriesAdapter.allProductViewHolder> {

    Context context;
    List<TopCatagoriesPojo> topCatagoriesPojoList;


    public TopCatagoriesAdapter(Context context, List<TopCatagoriesPojo> topCatagoriesPojos) {
        this.context = context;
        this.topCatagoriesPojoList = topCatagoriesPojos;
    }

    @NonNull
    @Override
    public allProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.catagories_top_row,parent,false);
        return new allProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final allProductViewHolder holder, final int position) {


        holder.catagoriesName.setText(topCatagoriesPojoList.get(position).getTopCatagoriesName());
        holder.catagoriesImage.setImageResource(topCatagoriesPojoList.get(position).getTopCatagoriesImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return topCatagoriesPojoList.size();
    }

    public class allProductViewHolder extends RecyclerView.ViewHolder
    {
        TextView catagoriesName;
        ImageView catagoriesImage;

        public allProductViewHolder(@NonNull View itemView) {
            super(itemView);

            catagoriesName =itemView.findViewById(R.id.topCatagoriesName);
            catagoriesImage =itemView.findViewById(R.id.topCatagoriesImage);

        }
    }
}
