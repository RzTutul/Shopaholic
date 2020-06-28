package com.example.ecommerceapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerceapp.adapter.CartAdapter;
import com.example.ecommerceapp.adapter.ImageSliderAdapter;
import com.example.ecommerceapp.pojo.ProductDeatilsPojo;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.snackbar.Snackbar;
import com.nex3z.togglebuttongroup.SingleSelectToggleGroup;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import static com.example.ecommerceapp.MainActivity.bottomNavigation;
import static com.example.ecommerceapp.MainActivity.cartCount;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailsFragment extends Fragment {

    SliderView sliderView;
    int images[] = {R.drawable.dresss7, R.drawable.dresss5, R.drawable.dresss3};
    String titile[] = {"fd ", "f ", "f "};
    ChipGroup chipGroup;
    Button increaseQytBtn, descreaseQytBtn;
    MaterialButton addCartBtn,addWishBtn;
    TextView productName,productPrice, QytTV;
    int qyt = 1;
    SingleSelectToggleGroup single;
    String size,color,catagories="Ladies";


    public ProductDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        chipGroup = view.findViewById(R.id.chipsGroup);
        sliderView = view.findViewById(R.id.imageSlider);
        increaseQytBtn = view.findViewById(R.id.increaseQytBtn);
        descreaseQytBtn = view.findViewById(R.id.qytDesc);
        QytTV = view.findViewById(R.id.QytTV);
        productName = view.findViewById(R.id.productNameTV);
        productPrice = view.findViewById(R.id.productPriceTV);
        addCartBtn = view.findViewById(R.id.addCartBtn);
        addWishBtn = view.findViewById(R.id.addWishBtn);

         single =view.findViewById(R.id.group_choices);


        final String[] chipsData = {"Blue", "Red", "Yellow", "Black", "White", "Pink"};

        ArrayList<Integer> colorList = new ArrayList<>();
        colorList.add(R.color.blue);
        colorList.add(R.color.red);
        colorList.add(R.color.yellow);
        colorList.add(R.color.black);
        colorList.add(R.color.white);
        colorList.add(R.color.pink);


        for (int i = 0; i < chipsData.length; i++) {
            final Chip chip = new Chip(view.getContext());
            chip.setText(chipsData[i]);
            chip.setClickable(true);
            chip.setCheckable(true);
            chip.setTextSize(10);
            chip.setElevation(1);
            chip.setChipBackgroundColor(ColorStateList.valueOf(ContextCompat.getColor(getActivity(), colorList.get(i))));

            chipGroup.addView(chip);

            chip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "" + chip.getText().toString(), Toast.LENGTH_SHORT).show();
                    color = chip.getText().toString();
                }
            });

        }


        ImageSliderAdapter adapter = new ImageSliderAdapter(getActivity(), images, titile);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();



        single.setOnCheckedChangeListener(new SingleSelectToggleGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SingleSelectToggleGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.choice_s:
                        size ="S";
                        break;
                        case R.id.choice_l:
                        size ="L";
                        break;
                        case R.id.choice_m:
                        size ="M";
                        break;
                        case R.id.choice_xl:
                        size ="XL";
                        break;
                        case R.id.choice_xx:
                        size ="XX";
                        break;

                }
            }
        });


        increaseQytBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                qyt++;

                QytTV.setText(String.valueOf(qyt));

            }
        });
        descreaseQytBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (qyt > 1) {
                    qyt--;

                    QytTV.setText(String.valueOf(qyt));
                }
            }
        });

        addCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proName = productName.getText().toString();
                String proPrice = productPrice.getText().toString();

                ProductDeatilsPojo productDeatilsPojo = new ProductDeatilsPojo(proName, Integer.parseInt(proPrice),catagories,images[0],size,color,(qyt));

                CartFragment.list.add(productDeatilsPojo);
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment_container).navigate(R.id.cartFragment);

                cartCount++;
              bottomNavigation.setCount(3,String.valueOf(cartCount) );

                Toast.makeText(getActivity(), ""+ cartCount, Toast.LENGTH_SHORT).show();


            }
        });

        addWishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }
}
