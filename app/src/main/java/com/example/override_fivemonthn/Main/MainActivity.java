package com.example.override_fivemonthn.Main;



import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.override_fivemonthn.Adapter.HeartFragment;

import com.example.override_fivemonthn.R;
import com.example.override_fivemonthn.data.SharedPr;
import com.example.override_fivemonthn.presentation.intro.IntroActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity  {



    BottomNavigationView navigationView;
        private ViewPager viewPager;

     //   public static void start(Context context) {
   //         context.startActivity(new Intent(context, MainActivity.class));
   //     }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            navigationView = findViewById(R.id.navigView);
            viewPager = findViewById(R.id.main_view_pager);
            NavigationViewPager();


            boolean isShow = SharedPr.getInstance(this).isShown();
            if (!isShow) {
                startActivity(new Intent(this, IntroActivity.class));
                finish();
                return;

        }





        }
        private void NavigationViewPager() {
            viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
            viewPager.setOffscreenPageLimit(2);
            navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.Home0:
                            viewPager.setCurrentItem(0,false);
                            break;
                        case R.id.Heart0:
                            viewPager.setCurrentItem(1,false);
                            break;
                    }
                    return true;
                }
            });
        }

    public void DarkMode(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();


        }

    public void LightMode(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();

    }

    public class MainPagerAdapter extends FragmentPagerAdapter {

            public MainPagerAdapter(@NonNull FragmentManager fm, int behavior) {
                super(fm, behavior);
            }

            public MainPagerAdapter(@NonNull FragmentManager fm) {
                super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            }


            @NonNull
            @Override
            public Fragment getItem(int position) {
                Fragment fragment;
                switch (position) {
                    case 0:
                        fragment = Fragment_main.newInstance();
                        break;
                    case 1:
                        fragment = HeartFragment.newInstance();
                        break;
                    default:
                        fragment = Fragment_main.newInstance();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        }

    }







