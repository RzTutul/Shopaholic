package com.example.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

   public static MeowBottomNavigation bottomNavigation;
   public static int cartCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigation = findViewById(R.id.bottomNav);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_format_list_bulleted_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_add_shopping_cart_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_favorite_fill_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_search_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(6, R.drawable.ic_person_black_24dp));



        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                // your codes
                switch (item.getId())
                {
                    case 1:
                        Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment_container).navigate(R.id.homePageFragment);
                        break;

                    case 2:
                        Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment_container).navigate(R.id.mainCatagoriesFragment);
                        break;
                    case 5:
                        Bundle bundle = new Bundle();
                        bundle.putInt("key",1);

                        Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_container).navigate(R.id.mainCatagoriesFragment,bundle);
                        break;

                    case 3:
                        Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment_container).navigate(R.id.cartFragment);
                        break;



                        default:
                            break;

                }




            }
        });

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                // your codes
            }
        });

        bottomNavigation.show(1,true);




        bottomNavigation.setCount(3,String.valueOf(cartCount) );


    }
}
