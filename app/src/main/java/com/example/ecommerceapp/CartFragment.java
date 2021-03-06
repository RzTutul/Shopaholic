package com.example.ecommerceapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ecommerceapp.adapter.CartAdapter;
import com.example.ecommerceapp.pojo.ProductDeatilsPojo;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    RecyclerView cartRV;
    TextView totalPrice;
   public static List<ProductDeatilsPojo> list = new ArrayList<>();

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cartRV = view.findViewById(R.id.cartRV);
        totalPrice = view.findViewById(R.id.totalPrice);
        int total_price=0;
        for (ProductDeatilsPojo productDeatilsPojo : list)
        {
            total_price= total_price+(productDeatilsPojo.getProductPrice()*productDeatilsPojo.getProdcutQyt());
        }

        totalPrice.setText(String.valueOf(total_price));



        CartAdapter cartAdapter = new CartAdapter(getActivity(),list);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        cartRV.setLayoutManager(llm);
        cartRV.setAdapter(cartAdapter);
    }
}
