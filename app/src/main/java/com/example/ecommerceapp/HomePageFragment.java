package com.example.ecommerceapp;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ecommerceapp.adapter.HotDealsAdapter;
import com.example.ecommerceapp.adapter.ImageSliderAdapter;
import com.example.ecommerceapp.adapter.TopCatagoriesAdapter;
import com.example.ecommerceapp.adapter.TrendingAdapter;
import com.example.ecommerceapp.adapter.ViewPagerAdapter;
import com.example.ecommerceapp.pojo.HotDealsPojo;
import com.example.ecommerceapp.pojo.TopCatagoriesPojo;
import com.example.ecommerceapp.pojo.TrendingPojo;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {

    private SliderView sliderView;
    int images[]={R.drawable.sliderimage1,R.drawable.sliderimage2,R.drawable.sliderimage3,};
    String titile[]={"fd ","f ","f "};

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private AllProductFragment allProductFragment;
    private ShirtProductFragment shirtProductFragment;

    private RecyclerView topCatagoriesRV,hotdealsRV,trendingRV;

    int[] productImages = {R.drawable.dress1,R.drawable.dresss2,R.drawable.dresss3,R.drawable.dresss4,R.drawable.dresss5,R.drawable.dresss6};
    String [] productName ={"Ladis", "Grawn Dress","Babe Dress","New Dress","Floor Touch","Kakatua Dress"};
    String [] productCatgoires ={"Ladis", "Men","Babe","HouseHold","Ladis","Men"};
    String [] description ={"It is avaiable now.", "It is avaiable now.","It is avaiable now.","It is avaiable now.","It is avaiable now.","It is avaiable now."};
    int[] productPrice= {100,200,300,4000,5000,6000};
    String [] offerPercent ={"20", "50","70","30","50","30"};

    List<TopCatagoriesPojo> topCatagoriesPojoList = new ArrayList<>();
    List<HotDealsPojo> hotDealsPojoList = new ArrayList<>();
    List<TrendingPojo> trendingPojoList = new ArrayList<>();

    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sliderView = view.findViewById(R.id.imageSlider);
        topCatagoriesRV = view.findViewById(R.id.topCatagoriesRV);
        hotdealsRV = view.findViewById(R.id.hotdealsRV);
        trendingRV = view.findViewById(R.id.trendingRV);


        ImageSliderAdapter adapter = new ImageSliderAdapter(getActivity(), images, titile);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();


        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);

        allProductFragment = new AllProductFragment();
        shirtProductFragment = new ShirtProductFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(allProductFragment, "All");
        viewPagerAdapter.addFragment(shirtProductFragment, "Shirt");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.icon1);
        tabLayout.getTabAt(1).setIcon(R.drawable.icon2);
        BadgeDrawable badgeDrawable = tabLayout.getTabAt(0).getOrCreateBadge();
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(12);

        //Top Catagories RecyleView
        for (int i =0;i<productImages.length;i++)
        {
            TopCatagoriesPojo topCatagoriesPojo = new TopCatagoriesPojo(productName[i],productImages[i]);

            topCatagoriesPojoList.add(topCatagoriesPojo);


        }
        Toast.makeText(getActivity(), "TOp"+topCatagoriesPojoList.size(), Toast.LENGTH_SHORT).show();
        TopCatagoriesAdapter topCatagoriesAdapter = new TopCatagoriesAdapter(getActivity(),topCatagoriesPojoList);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        topCatagoriesRV.setLayoutManager(llm);
        topCatagoriesRV.setAdapter(topCatagoriesAdapter);


        //HotDeals CatagoriesRV
        for (int i =0;i<productImages.length;i++)
        {
            HotDealsPojo hotDealsPojo = new HotDealsPojo(productImages[i],productName[i],productCatgoires[i],productPrice[i],offerPercent[i]);
            hotDealsPojoList.add(hotDealsPojo);

        }

        HotDealsAdapter hotDealsAdapter = new HotDealsAdapter(getActivity(),hotDealsPojoList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        hotdealsRV.setLayoutManager(linearLayoutManager);
        hotdealsRV.setAdapter(hotDealsAdapter);



        //Treding Catagories

        for (int i =0;i<productImages.length;i++)
        {
            TrendingPojo  trendingPojo = new TrendingPojo(productPrice[i],productName[i],description[i],productCatgoires[i],productImages[i]);
            trendingPojoList.add(trendingPojo);

        }

        TrendingAdapter trendingAdapter = new TrendingAdapter(getActivity(),trendingPojoList);
        LinearLayoutManager trendingllm = new LinearLayoutManager(getActivity());
        trendingRV.setLayoutManager(trendingllm);
        trendingRV.setAdapter(trendingAdapter);





    }
}
