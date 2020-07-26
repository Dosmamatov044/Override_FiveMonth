package com.example.override_fivemonthn.presentation.intro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;

import android.widget.RelativeLayout;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.override_fivemonthn.Main.MainActivity;
import com.example.override_fivemonthn.R;
import com.example.override_fivemonthn.data.SharedPr;
import com.google.android.material.tabs.TabLayout;


public class IntroActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tablayout;
    Button buttonSkip;
    Button buttonNext;
    RelativeLayout color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_intro);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tablayout = findViewById(R.id.tabLayout);
        tablayout.setupWithViewPager(viewPager, true);

        buttonSkip = findViewById(R.id.btn_skip);
        color= findViewById(R.id.color);
        buttonNext = findViewById(R.id.next);
        buttonSkip.setVisibility(View.VISIBLE);
        ViewPagerScrolling();

        // saveIsShown();
    }public void next(View view) {

        SharedPr.getInstance(this).saveShown();

        if (viewPager.getCurrentItem() < 2) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() +1, true);
        } else {
            startActivity(new Intent(this, MainActivity.class));
            finish();

        }

    }public void skip(View view) {

        SharedPr.getInstance(this).saveShown();
        startActivity(new Intent(this, MainActivity.class));
        finish();


    }public void ViewPagerScrolling() {
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        buttonSkip.setVisibility(View.VISIBLE);
                        buttonNext.setVisibility(View.VISIBLE);
                        buttonNext.setText("NEXT");
                        color.setBackgroundColor(Color.YELLOW);

                        break;
                    case 1:



                        buttonSkip.setVisibility(View.VISIBLE);
                        buttonNext.setVisibility(View.VISIBLE);
                        buttonNext.setText("NEXT");
                        color.setBackgroundColor(Color.BLACK);
                        break;
                    case 2:
                        buttonNext.setText("Start");
                        buttonSkip.setVisibility(View.GONE);
                        color.setBackgroundColor(Color.RED);

                }
            }

        });}

    class PagerAdapter extends FragmentPagerAdapter {


        public PagerAdapter(@NonNull FragmentManager fm) {
            super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putInt("keyForPosition", position);
            IntroFragment fragment = new IntroFragment();
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }}

//private boolean saveIsShown(){









//}


// public void swipeRight(int x){
//      if(x < 2){
//        saveIsShown();
//        viewPager.setCurrentItem(x + 1);
//
//      }
// }



