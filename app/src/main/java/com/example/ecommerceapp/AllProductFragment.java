package com.example.ecommerceapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ecommerceapp.adapter.AllProductAdapter;
import com.example.ecommerceapp.pojo.ProductPojo;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllProductFragment extends Fragment {

    RecyclerView allProductRV;
    GridLayoutManager gridLayoutManager;
    List<ProductPojo> productPojos = new ArrayList<>();

    int[] productImages = {R.drawable.dress1,R.drawable.dresss2,R.drawable.dresss3,R.drawable.dresss4,R.drawable.dresss5,R.drawable.dresss6};
    String [] productName ={"Ladis Pant","Grawn Dress","Babe Dress","New Dress","Floor Touch","Kakatua Dress"};
    int[] productPrice= {100,200,300,4000,5000,6000};

    public AllProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        allProductRV = view.findViewById(R.id.allProductRV);


        for (int i=0;i<productImages.length;i++)
        {
            Log.i(TAG, "onViewCreated:  "+productImages[i]);
            ProductPojo productPojo = new ProductPojo(productImages[i],productName[i],productPrice[i]);
            productPojos.add(productPojo);
        }
        AllProductAdapter allProductAdapter = new AllProductAdapter(getActivity(),productPojos);
         gridLayoutManager = new GridLayoutManager(getActivity(),2);
         allProductRV.setLayoutManager(gridLayoutManager);
        allProductRV.setAdapter(allProductAdapter);
    }


}
