package com.example.lenovo.meteoapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyAdapter(getFragmentManager()));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CloudFragment();
                case 1:
                    return new TemperatureFragment();
                case 2:
                    return new HumidityFragment();
                case 3:
                    return new EquivalentFragment();
            }
            throw new RuntimeException("");
        }


        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 :
                    return "podstawa";
                case 1 :
                    return "temperatura";
                case 2 :
                    return "wilgotność";
                case 3 :
                    return "równoważnik";
            }
            throw new RuntimeException("");
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
