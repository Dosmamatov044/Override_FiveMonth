package com.example.override_fivemonthn.Main;



import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.override_fivemonthn.Adapter.Adapter;
import com.example.override_fivemonthn.Adapter.HeartFragment;

import com.example.override_fivemonthn.BatteryReceiver;
import com.example.override_fivemonthn.R;
import com.example.override_fivemonthn.data.SharedPr;
import com.example.override_fivemonthn.presentation.intro.IntroActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity   {



SwitchCompat switchCompat;
    SharedPreferences sharedPreferences=null;
    BottomNavigationView navigationView;
        private ViewPager viewPager;

    private BatteryReceiver mBatteryReceiver=new BatteryReceiver();
    private IntentFilter mIntentFilter=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

     //   public static void start(Context context) {
   //         context.startActivity(new Intent(context, MainActivity.class));
   //     }


    @Override
    public void onPause() {
       unregisterReceiver(mBatteryReceiver);
        super.onPause();


    }


    @Override
    public void onResume() {

        super.onResume();
registerReceiver(mBatteryReceiver,mIntentFilter);

    }

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        navigationView = findViewById(R.id.navigView);
            viewPager = findViewById(R.id.main_view_pager);
switchCompat=findViewById(R.id.switchCompat);

sharedPreferences =getSharedPreferences("night",0);
Boolean booleanValue=sharedPreferences.getBoolean("night_mode",true);
if (booleanValue){

    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    switchCompat.setChecked(true); }
switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked){

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            switchCompat.setChecked(true);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("night_mode",true);
            editor.commit();
        }else {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            switchCompat.setChecked(false);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putBoolean("night_mode",false);
            editor.commit();


        }

    }
});





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













/*   public void DarkMode(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();


        }

    public void LightMode(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();

    }*/



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







